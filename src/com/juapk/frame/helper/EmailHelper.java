package com.juapk.frame.helper;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.MultiPartEmail;

/**
 * 项目名称：juapk
 * 类名称：EmailHelper
 * 类描述：邮件系统commons-email接口辅助类
 * 创建人：hubin
 * 创建时间：2012-6-26 下午9:52:56
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class EmailHelper {
	
	/**
	 * SendingEmailsWithAttachments(Sending emails with attachments)
	 * @param  AttachmentObject
	 * @param  EmailObject
	 * @Exception EmailException
	 * @since  V1.0
	 */
	public void SendingEmailsWithAttachments(AttachmentObject attachmentObject,
			EmailObject emailObject) throws EmailException {
		// Create the email message
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath(attachmentObject.getPath());
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription(attachmentObject.getDescription());
		attachment.setName(attachmentObject.getName());
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName(emailObject.getHostName());
		email.addTo(emailObject.getTo());
		// email.setFrom("me@apache.org", "Me");
		email.setFrom(emailObject.getEmail(),emailObject.getEmailName());
		email.setSubject(emailObject.getSubject());
		email.setMsg(emailObject.getMsg());
		// add the attachment
		email.attach(attachment);
		// send the email
		email.send();
	}
	
	/**
	 * SendingHTMLformattedEmail(Sending HTML formatted email)
	 * @param  name
	 * @return String    DOM对象
	 * @Exception 异常对象
	 * @since  V1.0
	 */
	public void SendingHTMLformattedEmail(EmailObject emailObject) throws EmailException{
		// Create the email message
		HtmlEmail email = new HtmlEmail();
		email.setHostName(emailObject.getHostName());
		email.addTo(emailObject.getTo());
		// email.setFrom("me@apache.org", "Me");
		email.setFrom(emailObject.getEmail(),emailObject.getEmailName());
		email.setSubject(emailObject.getSubject());
		// embed the image and get the content id
		URL url = null;
		try {
			url = new URL(emailObject.getURL());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		String cid = email.embed(url, emailObject.getEmbed());
		// set the html message ("<html>The apache logo - <img src=\"cid:"+cid+"\"></html>")
		email.setHtmlMsg("<html>"+emailObject.getHtmlMsg() +"<img src=\"cid:"+cid+"\"></html>");
		// set the alternative message ("Your email client does not support HTML messages")
		email.setTextMsg(emailObject.getTextMsg());
		// send the email
		email.send();
	}
	
	/**
	 * SendingHTMLformattedEmailWithEmbeddedImages
	 * 		(Sending HTML formatted email with embedded images)
	 * @param  name
	 * @return String    DOM对象
	 * @Exception 异常对象
	 * @since  V1.0
	 */
	public void SendingHTMLformattedEmailWithEmbeddedImages(EmailObject emailObject) throws EmailException{
		// load your HTML email template
		String htmlEmailTemplate = "";
		// define you base URL to resolve relative resource locations
		URL url = null;
		try {
			url = new URL(emailObject.getURL());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		// create the email message
		HtmlEmail email = new ImageHtmlEmail();
		// email.setDataSourceResolver(new DataSourceResolverImpl(url));
		email.setHostName(emailObject.getHostName());
		email.addTo(emailObject.getTo());
		// email.setFrom("me@apache.org", "Me");
		email.setFrom(emailObject.getEmail(),emailObject.getEmailName());
		email.setSubject(emailObject.getSubject());
		// set the html message
		email.setHtmlMsg(htmlEmailTemplate);
		// set the alternative message
		email.setTextMsg(emailObject.getTextMsg());
		// send the email
		email.send();
	}

}