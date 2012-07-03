package com.juapk.frame.common;

import java.util.List;

/**
 * 项目名称：juapk
 * 类名称：PageModel
 * 类描述：分页实体类
 * 创建人：hubin
 * 创建时间：2012.01.16
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class PageModel {
	private int pageSize;
	private String linkUrl;
	private List<?> data;
	private int count;
	private int offset;

	public PageModel() {
	}

	public PageModel(int offset, int pageSize) {
		this.offset = offset;
		this.pageSize = pageSize;
	}
	
	public PageModel(List<?> data, int offset, int pageSize,
			int count, String linkUrl) {
		this.data = data;
		this.offset = offset;
		this.pageSize = pageSize;
		this.count = count;
		this.linkUrl = linkUrl;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}
}