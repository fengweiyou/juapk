package com.juapk.domain;

import java.sql.Date;

/**
 * 项目名称：juapk
 * 类名称：TopicSoft
 * 类描述：专题软件表
 * 创建人：hubin
 * 创建时间：2012-6-24 下午5:58:46
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class TopicSoft {
	private String id;
	private String topic_id;
	private String soft_id;
	private int location;
	private int flag;
	private Date topic_date;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTopic_id() {
		return topic_id;
	}
	public void setTopic_id(String topicId) {
		topic_id = topicId;
	}
	public String getSoft_id() {
		return soft_id;
	}
	public void setSoft_id(String softId) {
		soft_id = softId;
	}
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public Date getTopic_date() {
		return topic_date;
	}
	public void setTopic_date(Date topicDate) {
		topic_date = topicDate;
	}
}