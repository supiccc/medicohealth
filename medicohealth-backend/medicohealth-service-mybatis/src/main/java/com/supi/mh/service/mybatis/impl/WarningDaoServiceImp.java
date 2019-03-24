package com.supi.mh.service.mybatis.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.supi.mh.api.mybatis.WarningDaoService;
import com.supi.mh.entity.pojo.Warning;
import com.supi.mh.service.mybatis.dao.WarningMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

/**
 * Created by supiccc on 2019-03-23 02:32
 */
@Service(version = "${dubbo.application.version}")
public class WarningDaoServiceImp implements WarningDaoService {

    private WarningMapper warningMapper;

    public WarningMapper getWarningMapper() {
        return warningMapper;
    }

    @Autowired
    public void setWarningMapper(WarningMapper warningMapper) {
        this.warningMapper = warningMapper;
    }

    @Override
    public ArrayList<Warning> getAll() {
        return warningMapper.selectAll();
    }
}
