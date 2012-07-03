package com.juapk.frame.common;

/**
 * 项目名称：juapk
 * 类名称：QueryItem
 * 类描述：分页查询实体类 
 * 创建人：hubin
 * 创建时间：2012.01.16
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class QueryItem {
	private int offset;	// 起始页
	private int pageSize;	// 页总数
	private String sql;	// where 条件
	
	public QueryItem(){
	}
	
	public QueryItem(int offset, int pageSize){
		this.offset = offset;
		this.pageSize = pageSize;
	}

	public QueryItem(String offset, String pageSize){
		try{
			this.offset = Integer.parseInt(offset);
		}catch(Exception e){
			this.offset = 0;
		}
		try{
			this.pageSize = Integer.parseInt(pageSize);
		}catch(Exception e){
			this.pageSize = 10;
		}
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}