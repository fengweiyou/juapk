package com.juapk.frame.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class CommonIndexTag extends TagSupport {

	private static final long serialVersionUID = 450536697028385541L;
	private boolean disp = false;
	private String displayCount;
	private String styleClass = null;
	private String currentPageStyleClass = "selected";

	public int doStartTag() throws JspException {

		String dispStrs = (String) pageContext
				.getAttribute(CommonMPageTag.DISP);
		if ((dispStrs != null) && (!dispStrs.equals(""))) {
			if (dispStrs.equals("on"))
				disp = true;
			else if (dispStrs.equals("off"))
				disp = false;
		}

		int start = ((Integer) pageContext.getAttribute(CommonMPageTag.START))
				.intValue();
		int count = ((Integer) pageContext.getAttribute(CommonMPageTag.COUNT))
				.intValue();
		int allCount = ((Integer) pageContext
				.getAttribute(CommonMPageTag.ALLCOUNT)).intValue();
		String url = (String) pageContext.getAttribute(CommonMPageTag.URLNAME);

		StringBuffer buf = new StringBuffer(100);

		int numPages = 0;
		if (allCount != count) {
			numPages = (int) Math.ceil((double) allCount / (double) count);
		} else {
			numPages = 1;
		}

		// Calculate the starting point & end points (the count of pages to
		// display)
		int currentPage = 1;
		if (count > 0) {
			currentPage = (start / count) + 1;
		}

		if ((displayCount == null) || (displayCount.length() == 0))
			this.displayCount = "5"; // default 5
		int dispCount = Integer.parseInt(displayCount);
		int lo = currentPage - dispCount;
		if (lo <= 0) {
			lo = 1;
		}
		int hi = currentPage + dispCount;

		// print out a link to the first page if we're beyond that page
		if (lo > 1) {
			buf.append("<a href=\"").append(url);
			if (styleClass == null) {
				buf.append("\" title=\"Go to the first page\">1</a> ... ");
			} else {
				buf.append("\" class=\"");
				buf.append(styleClass);
				buf.append("\" title=\"Go to the first page\">1</a> ... ");
			}
		}

		// Print the page numbers before the current page
		while (lo < currentPage) {
			buf.append("<a href=\"").append(url);
			buf.append("&offset=");
			buf.append(((lo - 1) * count));
			if (styleClass == null) {
				buf.append("\">");
			} else {
				buf.append("\" class=\"");
				buf.append(styleClass);
				buf.append("\">");
			}
			buf.append(lo);
			buf.append("</a>");
			lo++;
		}

		// Print the current page
		buf.append("<a href=\"#");
		if (currentPageStyleClass == null) {
			buf.append("\">");
			buf.append(currentPage);
		} else {
			buf.append("\" class=\"");
			buf.append(currentPageStyleClass);
			buf.append("\">");
			buf.append(currentPage);
		}
		buf.append("</a>");
		currentPage++;

		// Print page numbers after the current page
		while ((currentPage <= hi) && (currentPage <= numPages)) {
			buf.append("<a href=\"").append(url);
			buf.append("&offset=");
			buf.append(((currentPage - 1) * count));
			if (styleClass == null) {
				buf.append("\">");
			} else {
				buf.append("\" class=\"");
				buf.append(styleClass);
				buf.append("\">");
			}
			buf.append(currentPage);
			buf.append("</a>");
			currentPage++;
		}

		if (currentPage <= numPages) {
			buf.append(" ... ");
			buf.append("<a href=\"").append(url);
			buf.append("&offset=");
			buf.append(((numPages - 1) * count));
			if (styleClass == null) {
				buf.append("\" title=\"Go to the last page\">");
			} else {
				buf.append("\" class=\"");
				buf.append(styleClass);
				buf.append("\" title=\"Go to the last page\">");
			}
			buf.append(numPages);
			buf.append("</a>");
		}

		JspWriter writer = pageContext.getOut();
		try {
			if (disp)
				writer.print(buf.toString());
		} catch (IOException e) {
			throw new JspException("PrevTag error");
		}
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
	 * @return Returns the displayCount.
	 */
	public String getDisplayCount() {
		return displayCount;
	}

	/**
	 * @param displayCount
	 *            The displayCount to set.
	 */
	public void setDisplayCount(String displayCount) {
		this.displayCount = displayCount;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	public String getStyleClass() {
		return styleClass;
	}
}