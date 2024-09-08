package com.asliutkarsh.springbootmailserver.controller;

import com.asliutkarsh.springbootmailserver.dto.MailRequest;
import com.asliutkarsh.springbootmailserver.service.MailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailController {

     private final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping("/send")
    public ResponseEntity<?> sendMail(@RequestBody MailRequest mailRequest) {
        if (mailRequest.isHtml()) {
            mailService.sendMailWithHtml(mailRequest.getTo(), mailRequest.getSubject(), mailRequest.getContent());
        } else {
            mailService.sendMail(mailRequest.getTo(), mailRequest.getSubject(), mailRequest.getContent());
        }
        return new ResponseEntity<>("Mail sent successfully", HttpStatus.OK);
    }

    @PostMapping("/sendBulk")
    public ResponseEntity<?> sendBulkMail(@RequestBody MailRequest mailRequest) {
        if (mailRequest.isHtml()) {
            mailService.sendBulkMailWithHtml(mailRequest.getToBulk(), mailRequest.getSubject(), mailRequest.getContent());
        } else {
            mailService.sendBulkMail(mailRequest.getToBulk(), mailRequest.getSubject(), mailRequest.getContent());
        }
        return new ResponseEntity<>("Mail sent successfully", HttpStatus.OK);
    }
}
