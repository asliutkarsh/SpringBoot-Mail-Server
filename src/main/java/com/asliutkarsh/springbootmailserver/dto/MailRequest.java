package com.asliutkarsh.springbootmailserver.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class MailRequest {
    private String to;
    private String[] toBulk;
    private String subject;
    private String content;
    @JsonAlias("isHtml")
    private boolean isHtml;
}
