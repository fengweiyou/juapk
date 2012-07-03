package com.juapk.domain;

import java.sql.Date;

/**
 * 项目名称：juapk
 * 类名称：Soft
 * 类描述：软件表 
 * 创建人：hubin
 * 创建时间：2011.12.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class Soft {
	private String soft_id; //软件 ID
	private String soft_sort_id; //软件类别 ID
	private int soft_type; //软件类型
	private int gold_coin; //金币
	private int grade; //积分
	private String cn_name; //中文名
	private String en_name; //英文名
	private String soft_version; //版本
	private String author; //作者
	private String details; //详细说明
	private String image_a; //图片 A
	private String image_b; //图片 B
	private String image_c; //图片 C
	private String image_d; //图片 D
	private String image_e; //图片 E
	private String icon; //图标
	private String package_name; //包名
	private String package_size; //包大小
	private String down_url; //下载地址
	private int down_amount; //下载数量
	private String barcode; //条形码
	private Date upload_date; //上传时间
	
	public String getSoft_id() {
		return soft_id;
	}
	public void setSoft_id(String softId) {
		soft_id = softId;
	}
	public int getSoft_type() {
		return soft_type;
	}
	public void setSoft_type(int softType) {
		soft_type = softType;
	}
	public String getSoft_sort_id() {
		return soft_sort_id;
	}
	public void setSoft_sort_id(String softSortId) {
		soft_sort_id = softSortId;
	}
	public int getGold_coin() {
		return gold_coin;
	}
	public void setGold_coin(int goldCoin) {
		gold_coin = goldCoin;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getCn_name() {
		return cn_name;
	}
	public void setCn_name(String cnName) {
		cn_name = cnName;
	}
	public String getEn_name() {
		return en_name;
	}
	public void setEn_name(String enName) {
		en_name = enName;
	}
	public String getSoft_version() {
		return soft_version;
	}
	public void setSoft_version(String softVersion) {
		soft_version = softVersion;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getImage_a() {
		return image_a;
	}
	public void setImage_a(String imageA) {
		image_a = imageA;
	}
	public String getImage_b() {
		return image_b;
	}
	public void setImage_b(String imageB) {
		image_b = imageB;
	}
	public String getImage_c() {
		return image_c;
	}
	public void setImage_c(String imageC) {
		image_c = imageC;
	}
	public String getImage_d() {
		return image_d;
	}
	public void setImage_d(String imageD) {
		image_d = imageD;
	}
	public String getImage_e() {
		return image_e;
	}
	public void setImage_e(String imageE) {
		image_e = imageE;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getPackage_name() {
		return package_name;
	}
	public void setPackage_name(String packageName) {
		package_name = packageName;
	}
	public String getPackage_size() {
		return package_size;
	}
	public void setPackage_size(String packageSize) {
		package_size = packageSize;
	}
	public String getDown_url() {
		return down_url;
	}
	public void setDown_url(String downUrl) {
		down_url = downUrl;
	}
	public int getDown_amount() {
		return down_amount;
	}
	public void setDown_amount(int downAmount) {
		down_amount = downAmount;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public Date getUpload_date() {
		return upload_date;
	}
	public void setUpload_date(Date uploadDate) {
		upload_date = uploadDate;
	}
}