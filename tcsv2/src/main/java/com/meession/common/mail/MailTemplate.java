package com.meession.common.mail;

import java.io.File;

import javax.mail.Address;
import javax.mail.SendFailedException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.meession.common.exception.BusinessException;

/**
 * @author sam
 */
public class MailTemplate {

	private static final Logger logger = LoggerFactory
			.getLogger(MailTemplate.class);

	private JavaMailSenderImpl mailSender;

	public JavaMailSenderImpl getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSenderImpl mailSender) {
		this.mailSender = mailSender;
	}

	public void send(String[] to, String[] cc, String[] bcc, String title,
			String content, boolean html) {
		send(to, cc, bcc, title, content, html, null, null);
	}

	public void send(String[] to, String[] cc, String[] bcc, String title,
			String content, boolean html, String[] attachments,
			String[][] inlineResources) {
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(mailSender.getJavaMailProperties().getProperty(
					"mail.smtp.from"));
			if (to != null) {
				helper.setTo(to);
			}
			if (cc != null) {
				helper.setCc(cc);
			}
			if (bcc != null) {
				helper.setBcc(bcc);
			}
			helper.setSubject(title);
			helper.setText(content, html);
			if (attachments != null) {
				for (String attachment : attachments) {
					FileSystemResource file = new FileSystemResource(new File(
							attachment));
					helper.addAttachment(file.getFilename(), file);
				}
			}
			if (inlineResources != null) {
				for (String[] inlineResourceArray : inlineResources) {
					FileSystemResource file = new FileSystemResource(new File(
							inlineResourceArray[0]));
					helper.addAttachment(inlineResourceArray[1], file);
				}
			}

			mailSender.send(message);
		} catch (MailSendException e) {
			Exception exception = e.getMessageExceptions()[0];
			if (exception instanceof SendFailedException) {
				SendFailedException sendFailedException = (SendFailedException) exception;
				Address[] invalidAddresses = sendFailedException
						.getInvalidAddresses();
				if (invalidAddresses != null && invalidAddresses.length > 0) {
					logger.warn("Invalid emails: {}",
							invalidAddresses.toString());
				} else {
					throw e;
				}
			} else {
				throw e;
			}
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

}
