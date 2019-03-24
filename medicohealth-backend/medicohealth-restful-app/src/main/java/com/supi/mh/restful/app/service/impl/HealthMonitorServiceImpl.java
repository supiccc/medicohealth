package com.supi.mh.restful.app.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.supi.mh.entity.pojo.MonitorBloodPressure;
import com.supi.mh.entity.pojo.MonitorBloodSugar;
import com.supi.mh.entity.pojo.MonitorHeightWeight;
import com.supi.mh.entity.pojo.Warning;
import com.supi.mh.restful.app.service.HealthMonitorService;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by supiccc on 2019-03-20 14:49
 */
@Service
public class HealthMonitorServiceImpl implements HealthMonitorService {

    @Reference(version = "1.0.0")
    private com.supi.mh.api.mybatis.HealthMonitorService healthMonitorService;

    @Override
    public boolean insertBloodPressure(MonitorBloodPressure record) {

        // 插入
        healthMonitorService.insertBloodPressure(record);

        // 发送到预警系统
        if (record.getDiastolic() > 60 && record.getDiastolic() < 90 && record.getShrink() <= 140 && record.getShrink() > 90) {
            return true;
        }
        else {
            String type = "血压";
            StringBuilder content = new StringBuilder("于").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())).append("测量了血压，");
            if (record.getDiastolic() < 60 || record.getDiastolic() > 90) {
                content.append("舒张压：").append(record.getDiastolic()).append(" ");
            }
            if (record.getShrink() < 90 || record.getShrink() > 140) {
                content.append("收缩压：").append(record.getShrink()).append(" ");
            }
            Warning w = new Warning();
            w.setState((byte) 0);
            w.setContent(content.toString());
            w.setType(type);
            w.setElderId(record.getElderId());
            healthMonitorService.insertWarning(w);
        }

        return true;
    }

    /**
     * 插入血糖值
     * @param record
     * @return
     */
    @Override
    public boolean insertBloodSugar(MonitorBloodSugar record) {

        healthMonitorService.insertBloodSugar(record);

        if (record.getBloodSugarvalue() < 3.9 || record.getBloodSugarvalue() > 6.1) {
            String type = "血糖";
            StringBuilder content = new StringBuilder("于").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    .format(new Date())).append("测量了血糖，血糖值：").append(record.getBloodSugarvalue());
            Warning w = new Warning();
            w.setState((byte) 0);
            w.setContent(content.toString());
            w.setType(type);
            w.setElderId(record.getUserElderElderId());
            healthMonitorService.insertWarning(w);

        }
        return true;
    }

    @Override
    public boolean insertHeightWeight(MonitorHeightWeight record) {
        healthMonitorService.insertHeightWeight(record);

        double BMI = record.getWeight() / (record.getHeight()/100 * record.getHeight()/100);

        if(BMI > 23.9 || BMI < 18.5) {
            String type = "BMI";
            StringBuilder content = new StringBuilder("于").append(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    .format(new Date())).append("测量了身高体重，BMI：").append(new DecimalFormat("##0.0").format(BMI));
            Warning w = new Warning();
            w.setState((byte) 0);
            w.setContent(content.toString());
            w.setType(type);
            healthMonitorService.insertWarning(w);
        }
        return true;
    }
}
