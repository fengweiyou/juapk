package com.juapk.domain;

/**
 * 项目名称：juapk
 * 类名称：Ad
 * 类描述：广告表
 * 创建人：hubin
 * 创建时间：2011.12.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class Ad {
	private String ad_id;
	private String title;
	private String content;
	private String image;
	private String url;
	private int location;
	private int state;
	
	public String getAd_id() {
		return ad_id;
	}
	public void setAd_id(String adId) {
		ad_id = adId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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