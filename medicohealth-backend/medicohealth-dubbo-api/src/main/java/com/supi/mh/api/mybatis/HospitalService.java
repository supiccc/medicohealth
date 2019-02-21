package com.supi.mh.api.mybatis;

import com.supi.mh.entity.pojo.OrganizationHospital;

import java.util.List;

/**
 * Created by supiccc on 2019-02-22 01:07
 */
public interface HospitalService {

    /**
     * 获取所有医院信息
     * @return 医院列表
     */
    List<OrganizationHospital> getAll();
}
