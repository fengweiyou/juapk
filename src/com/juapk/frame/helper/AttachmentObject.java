package com.juapk.frame.helper;

public class AttachmentObject {
	private String Path;
	private String Disposition;
	private String Description;
	private String Name;
	
	public AttachmentObject(){
	}
	
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
	public String getDisposition() {
		return Disposition;
	}
	public void setDisposition(String disposition) {
		Disposition = disposition;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
}
