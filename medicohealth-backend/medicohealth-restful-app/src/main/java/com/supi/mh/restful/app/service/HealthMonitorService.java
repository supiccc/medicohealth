package com.supi.mh.restful.app.service;

import com.supi.mh.entity.pojo.MonitorBloodPressure;
import com.supi.mh.entity.pojo.MonitorBloodSugar;
import com.supi.mh.entity.pojo.MonitorHeightWeight;

/**
 * Created by supiccc on 2019-03-20 14:48
 */
public interface HealthMonitorService {

    boolean insertBloodPressure(MonitorBloodPressure record);


    boolean insertBloodSugar(MonitorBloodSugar record);

    boolean insertHeightWeight(MonitorHeightWeight record);
}
