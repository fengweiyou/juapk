package com.juapk.frame.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.taglibs.standard.resources.Resources;
import org.apache.taglibs.standard.tag.common.core.ImportSupport;

import com.juapk.frame.common.PageModel;

public class CommonMPageTag extends TagSupport {

	private static final long serialVersionUID = 7567654476561712107L;

	public final static String URLNAME = "URL";

	public final static String COUNT = "COUNT";

	public final static String START = "START";

	public final static String ALLCOUNT = "ALLCOUNT";

	public final static String NEXTPAGE = "NEXTPAGE";

	public final static String DISP = "DISP";

	private Object var;

	public Object getVar() {
		return var;
	}

	public void setVar(Object var) throws JspException {
		this.var = var;
	}

	public int doStartTag() throws JspException {
		String nextPage = "";
		int currentPage = 1;
		try {
			int start = ((PageModel) var).getOffset();
			int count = ((PageModel) var).getPageSize();
			int allCount = ((PageModel) var).getCount();
			String urlObj = ((PageModel) var).getLinkUrl();

			if (urlObj == null)
				urlObj = "";
			if (count == 0)
				count = 1;

			if (allCount > (start + count)) {
				nextPage = "NEXTPAGE";
			}

			String url = resolveUrl(urlObj, null, pageContext);

			pageContext.setAttribute(URLNAME, url);
			pageContext.setAttribute(START, start);
			pageContext.setAttribute(COUNT, count);
			pageContext.setAttribute(ALLCOUNT, allCount);
			pageContext.setAttribute(NEXTPAGE, nextPage);

			if (count > 0) {
				currentPage = (start / count) + 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// only one page
		if ((currentPage == 1) && (nextPage.length() == 0)) {
			pageContext.setAttribute(DISP, "off");
		} else {
			pageContext.setAttribute(DISP, "on");
		}
		// Evaluate the body of this tag
		return (EVAL_BODY_INCLUDE);
	}

	/**
	 * Render the end of the hyperlink.
	 * 
	 * @exception JspException
	 *                if a JSP exception has occurred
	 */
	public int doEndTag() throws JspException {
		return (EVAL_PAGE);
	}

	/**
	 * Release any acquired resources.
	 */
	public void release() {
		super.release();
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
