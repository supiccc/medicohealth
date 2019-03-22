package com.supi.mh.restful.app.service;

import com.supi.mh.entity.pojo.MonitorBloodPressure;

/**
 * Created by supiccc on 2019-03-20 14:48
 */
public interface HealthMonitorService {

    boolean insertBloodPressure(MonitorBloodPressure record);
}
