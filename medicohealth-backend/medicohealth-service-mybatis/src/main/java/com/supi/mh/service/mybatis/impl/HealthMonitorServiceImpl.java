package com.supi.mh.service.mybatis.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.supi.mh.api.mybatis.HealthMonitorService;
import com.supi.mh.entity.pojo.*;
import com.supi.mh.service.mybatis.dao.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by supiccc on 2019-03-17 23:04
 */
@Service(version = "${dubbo.application.version}")
public class HealthMonitorServiceImpl implements HealthMonitorService {

    @Autowired
    private MonitorBloodPressureMapper monitorBloodPressureMapper;

    @Autowired
    private WarningMapper warningMapper;

    @Autowired
    private MonitorBloodSugarMapper monitorBloodSugarMapper;

    @Autowired
    private MonitorBloodOxygenMapper monitorBloodOxygenMapper;

    @Autowired
    private MonitorCholesterolMapper monitorCholesterolMapper;

    @Autowired
    private MonitorHeightWeightMapper monitorHeightWeightMapper;

    @Autowired
    private MonitorUricAcidMapper monitorUricAcidMapper;

    @Autowired
    private MonitorFatMapper monitorFatMapper;


    /**
     * 获取最新的血压
     * @param id 档案id
     * @return
     */
    @Override
    public LatestBloodPressure getLatestBloodPressure(int id) {
        return monitorBloodPressureMapper.selectLatest(id);
    }

    @Override
    public int insertBloodPressure(MonitorBloodPressure record) {
        return monitorBloodPressureMapper.insertSelective(record);
    }

    /**
     * 插入警告信息
     * @param warning 警告信息
     * @return
     */
    @Override
    public int insertWarning(Warning warning) {
        return warningMapper.insertSelective(warning);
    }

    /**
     * 查询最近的血糖值
     * @param id 用户id
     * @return
     */
    @Override
    public MonitorBloodSugar getLatestBloodSugar(int id) {
        return monitorBloodSugarMapper.selectLatest(id);
    }

    @Override
    public int insertBloodSugar(MonitorBloodSugar record) {
        return monitorBloodSugarMapper.insertSelective(record);
    }

    /**
     * 查询最近的血氧值
     * @param id 用户id
     * @return
     */
    @Override
    public MonitorBloodOxygen getLatestBloodOxygen(int id) {
        return monitorBloodOxygenMapper.selectLatest(id);
    }

    @Override
    public int insertBloodOxygen(MonitorBloodOxygen record) {
        return 0;
    }

    /**
     * 查询最近的胆固醇值
     * @param id 用户id
     * @return
     */
    @Override
    public MonitorCholesterol getLatestCholesterol(int id) {
        return monitorCholesterolMapper.selectLatest(id);
    }

    @Override
    public int insertCholesterol(int id) {
        return 0;
    }

    @Override
    public MonitorFat getLatestFat(int id) {
        return monitorFatMapper.selectLatest(id);
    }

    @Override
    public int insertFat(int id) {
        return 0;
    }

    @Override
    public MonitorHeightWeight getLatestHeightWeight(int id) {
        return monitorHeightWeightMapper.selectLatest(id);
    }

    @Override
    public int insertHeightWeight(MonitorHeightWeight record) {
        return monitorHeightWeightMapper.insertSelective(record);
    }

    @Override
    public MonitorUricAcid getLatestUricAcid(int id) {
        return monitorUricAcidMapper.selectLatest(id);
    }

    @Override
    public int insertUricAcid(int id) {
        return 0;
    }
}
