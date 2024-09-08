package com.asliutkarsh.springbootmailserver.service;

public interface MailService {

    //sending simple text mail to a single person
    void sendMail(String to, String subject, String text);

    //sending mail with html to single person
    void sendMailWithHtml(String to, String subject, String htmlContent);

//    //sending mail with attachment to single person
//    boolean sendMailWithAttachment(String to, String subject, String text, String pathToAttachment);
//
//    //sending mail with inline image to single person
//    boolean sendMailWithInlineImage(String to, String subject, String text, String pathToInlineImage);

    //sending bulk mail to multiple person
    void sendBulkMail(String[] to, String subject, String text);

    //sending bulk mail with html to multiple person
    void sendBulkMailWithHtml(String[] to, String subject, String htmlContent);



}
