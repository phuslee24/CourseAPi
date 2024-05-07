package com.example.demo.Services.IRepositoryServices;

import com.example.demo.Model.Mail;

public interface IMailRepo {
       String SendMail(Mail details);
 
       String SendMailWithAttachment(Mail details);
}
