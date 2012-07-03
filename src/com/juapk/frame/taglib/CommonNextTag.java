package com.juapk.frame.taglib;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.taglibs.standard.resources.Resources;
import org.apache.taglibs.standard.tag.common.core.ImportSupport;


public class CommonNextTag extends BodyTagSupport {

	private static final long serialVersionUID = -646767145414211162L;

	private boolean disp = false;

	private String name = null;

	private String styleClass = "next";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	public String getStyleClass() {
		return styleClass;
	}

	public int doStartTag() throws JspException {

		String dispStrs = (String) pageContext.getAttribute(CommonMPageTag.DISP);
		if ((dispStrs != null) && (!dispStrs.equals(""))) {
			if (dispStrs.equals("on")) {
				disp = true;
			} else if (dispStrs.equals("off")) {
				disp = false;
			}
		}

		int start = ((Integer) pageContext.getAttribute(CommonMPageTag.START)).intValue();
		int count = ((Integer) pageContext.getAttribute(CommonMPageTag.COUNT)).intValue();
		int allCount = ((Integer) pageContext.getAttribute(CommonMPageTag.ALLCOUNT)).intValue();
		String url = (String) pageContext.getAttribute(CommonMPageTag.URLNAME);

		StringBuffer buf = new StringBuffer(100);

		if ((allCount > (start + count))) {
			buf.append("<a href=\"");
			buf.append(url);
			buf.append("&offset=");
			buf.append((start + count));

			if (styleClass != null) {
				buf.append("\" ");
				buf.append("class=\"");
				buf.append(styleClass);
			}
			buf.append("\" >");

			if (name != null) {
				buf.append("<img src='");
				buf.append(resolveUrl(name, null, pageContext));
				buf.append("' border=0 />");
			} else {
				buf.append("下一页");
			}

		} else {
			disp = false;
			buf.append("");
		}
		output(buf.toString());
		return (EVAL_BODY_INCLUDE);
	}

	/**
	 * Render the end of the hyperlink.
	 * 
	 * @exception JspException
	 *                if a JSP exception has occurred
	 */
	public int doEndTag() throws JspException {
		if (disp) {
			output("</a>");
		}
		return (EVAL_PAGE);
	}

	private void output(String s) throws JspException {
		JspWriter writer = pageContext.getOut();
		try {
			writer.print(s);
		} catch (IOException e) {
			throw new JspException("NextTag error");
		}
	}

	public void release() {
		super.release();
		disp = false;
		name = null;
		styleClass = null;
	}

	public static String resolveUrl(String url, String context, PageContext pageContext) throws JspException {
		// don't touch absolute URLs
		if (ImportSupport.isAbsoluteUrl(url))
			return url;

		// normalize relative URLs against a context root
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		if (context == null) {
			if (url.startsWith("/"))
				return (request.getContextPath() + url);
			else
				return url;
		} else {
			if (!context.startsWith("/") || !url.startsWith("/")) {
				throw new JspTagException(Resources.getMessage("IMPORT_BAD_RELATIVE"));
			}
			if (context.equals("/")) {
				// Don't produce string starting with '//', many
				// browsers interpret this as host name, not as
				// path on same host.
				return url;
			} else {
				return (context + url);
			}
		}
	}
}