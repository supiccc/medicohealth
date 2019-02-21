package com.supi.mh.service.mybatis.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.supi.mh.api.mybatis.HospitalService;
import com.supi.mh.entity.pojo.OrganizationHospital;
import com.supi.mh.service.mybatis.dao.OrganizationHospitalMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by supiccc on 2019-02-22 01:08
 */
@Service(version = "${dubbo.application.version}")
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    private OrganizationHospitalMapper organizationHospitalMapper;

    @Override
    public List<OrganizationHospital> getAll() {
        return organizationHospitalMapper.selectAll();
    }
}
