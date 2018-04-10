package com.rs.service.mail;

import java.io.File;
import javax.mail.MessagingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import com.rs.framwork.utils.Common;

@Component
public class ScheduledMail  extends BaseMailSender{

	private static Logger logger = LoggerFactory.getLogger(ScheduledMail.class); // 日志记录

	@Override
	FileSystemResource FileAttachment() {
		String filepath = Common.getConfig("mailUrl") + "1.txt";
		FileSystemResource file = new FileSystemResource(new File(filepath));
		return file;
	}

	
	
	public void sendLogMail() {
		try {
			sendMail();
		} catch (MessagingException e) {
			e.printStackTrace();
			logger.error("日志邮件发送异常", e);
		}
	}
	
	
	

}
