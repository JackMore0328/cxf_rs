package com.rs.service.mail;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.core.io.FileSystemResource;

public abstract class BaseMailSender {
	@Resource(name = "mailSender")
	private JavaMailSender mailSender;

	private static MimeMessage mimeMessage;
	// 并发监控
	private static Object monitor = new Object();

	protected MimeMessage getMimeMessage() {
		if (mimeMessage == null) {
			synchronized (monitor) {
				if (mimeMessage == null) {
					mimeMessage = mailSender.createMimeMessage();
				}
			}
		}
		return mimeMessage;
	}

	protected void getMessageHelper(MimeMessage mimeMessage) throws MessagingException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd");
		String dateTile = sdf.format(new Date());
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("851838199@qq.com");
		helper.setTo("820456036@qq.com");
		helper.setSubject("日志文件_" + dateTile);
		helper.setText("这是一封日志记录邮件");
		helper.addAttachment("附件-1", FileAttachment());
		mailSender.send(mimeMessage);
	}

	protected void sendMail() throws MessagingException {
		getMessageHelper(getMimeMessage());
	}

	abstract FileSystemResource FileAttachment();

}
