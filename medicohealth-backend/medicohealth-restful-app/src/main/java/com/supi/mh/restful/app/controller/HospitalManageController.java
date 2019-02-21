package com.supi.mh.restful.app.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.supi.mh.api.mybatis.HospitalService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import utils.ResponseJson;

/**
 * Created by supiccc on 2019-02-22 01:13
 */
@RestController
@RequestMapping("/hospital/v1")
public class HospitalManageController {

    @Reference(version = "1.0.0")
    private HospitalService hospitalService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseJson getAll() {
        try {
            return new ResponseJson(0, null, hospitalService.getAll());
        } catch (Exception e) {
            return new ResponseJson(1, null, null);
        }
    }

}
