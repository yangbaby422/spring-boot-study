package com.soft1721.jianyue.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private MailService mailService;

    @Scheduled(cron = "0 35 9 ? * *")
    public void proces(){
        mailService.sendMail("16422802@qq.com","洋酱的简单邮件","定时9.35");
        System.out.println("邮件发送成功");
    }
}
