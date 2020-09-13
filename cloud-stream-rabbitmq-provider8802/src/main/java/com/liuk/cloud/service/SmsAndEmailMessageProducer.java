package com.liuk.cloud.service;

public interface SmsAndEmailMessageProducer {
    void sendSms(String smsMessage);

    void sendEmail(String emailMessage);
}
