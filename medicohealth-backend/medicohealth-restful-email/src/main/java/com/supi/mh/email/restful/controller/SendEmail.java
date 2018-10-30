package com.supi.mh.email.restful.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.supi.mh.api.EmailContextService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by supiccc on 2018-10-30 17:04
 */
@RestController
@RequestMapping(value = "/email/v1")
public class SendEmail {
    @Reference(version = "1.0.0")
    EmailContextService e;

    @RequestMapping(value = "/sendtoAdmin")
    public String send2Admin(String email, String subject, String mode) {
        e.getIntance("toAdmin");
        e.sendto(email, 0, subject, mode);
        return "Ok";
    }
}
