package com.supi.mh.email.restful.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.supi.mh.api.EmailContextService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by supiccc on 2018-10-30 17:04
 */
@RestController
@RequestMapping(value = "/email/v1")
public class SendEmail {
    @Reference(version = "1.0.0")
    EmailContextService e;

    @RequestMapping(value = "/sendtoAdmin", method = RequestMethod.POST)
    public String send2Admin(String content) {
        e.getIntance("toAdmin");
        e.sendto("", content);
        return "Ok";
    }
}
