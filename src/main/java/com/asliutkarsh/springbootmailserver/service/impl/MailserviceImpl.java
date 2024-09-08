package com.asliutkarsh.springbootmailserver.service.impl;

import com.asliutkarsh.springbootmailserver.service.MailService;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;

@Service
@Slf4j
public class MailserviceImpl implements MailService {

    private final JavaMailSender javaMailSender;

    public MailserviceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendMail(String to, String subject, String text) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(to);
            mailMessage.setSubject(subject);
            mailMessage.setText(text);
            javaMailSender.send(mailMessage);
            log.info("Mail sent successfully");
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while sending mail", e);
        }
    }

    @Override
    public void sendMailWithHtml(String to, String subject, String htmlContent) {
        try {
            MimeMessage mail = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail, true, "UTF-8");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(htmlContent,true);
            javaMailSender.send(mail);
            log.info("HTML Mail sent successfully");
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while sending HTML mail", e);
        }
    }

    @Override
    public void sendBulkMail(String[] to, String subject, String text) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(to);
            mailMessage.setSubject(subject);
            mailMessage.setText(text);
            javaMailSender.send(mailMessage);
            log.info("Bulk Mail sent successfully");
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while sending Bulk mail", e);
        }
    }

    @Override
    public void sendBulkMailWithHtml(String[] to, String subject, String htmlContent) {
        try {
            MimeMessage mail = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail, true, "UTF-8");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(htmlContent,true);
            javaMailSender.send(mail);
            log.info("Bulk HTML Mail sent successfully");
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while sending Bulk HTML mail", e);
        }
    }
}
