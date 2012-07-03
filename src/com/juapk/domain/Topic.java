package com.juapk.domain;

/**
 * 项目名称：juapk
 * 类名称：Topic
 * 类描述：专题表
 * 创建人：hubin
 * 创建时间：2011.12.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class Topic {
	private String topic_id;
	private String title;
	private String sub_title;
	private String image;
	private String details;
	private int location;
	private int state;
	
	public String getTopic_id() {
		return topic_id;
	}
	public void setTopic_id(String topicId) {
		topic_id = topicId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSub_title() {
		return sub_title;
	}
	public void setSub_title(String subTitle) {
		sub_title = subTitle;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public int getLocation() {
		return location;
	}
	public void setLocation(int location) {
		this.location = location;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
}