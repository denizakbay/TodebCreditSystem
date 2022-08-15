package com.todeb.creditsystem.service.impl;

import com.todeb.creditsystem.domain.CreditApplication;
import com.todeb.creditsystem.enums.CreditStatus;
import com.todeb.creditsystem.service.MessageService;
import com.twilio.Twilio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.twilio.rest.api.v2010.account.Message;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    public static final String ACCOUNT_SID = "AC67b03825ffd6ff5680b724f7914e5797";
    public static final String AUTH_TOKEN = "7ba9324df9fbed2697accd2b9aa772a8";

    public void sendMessage(CreditApplication creditApplication) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        CreditStatus creditStatus = creditApplication.getStatus();
        String name = creditApplication.getCustomer().getFirstName();
        String surname = creditApplication.getCustomer().getLastName();
        BigDecimal creditLimit = creditApplication.getCreditLimit();
        String phone = creditApplication.getCustomer().getPhone();

        String body = "Dear " + name + " " + surname + " your credit status is " + creditStatus;
        if (creditStatus == CreditStatus.ACCEPTED) {
            body = body + " and your credit limit is = " + creditLimit;
        }

        Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(phone),
                        new com.twilio.type.PhoneNumber("+12132619470"),
                        body)
                .create();

        System.out.println(message.getSid());

        System.out.println(message.getSid());
    }
}