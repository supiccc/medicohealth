package com.supi.mh.api.mybatis;

import com.supi.mh.entity.pojo.*;

/**
 * Created by supiccc on 2019-03-17 23:02
 */
public interface HealthMonitorService {
    LatestBloodPressure getLatestBloodPressure(int id);

    int insertBloodPressure(MonitorBloodPressure record);

    int insertWarning(Warning warning);

    MonitorBloodSugar getLatestBloodSugar(int id);

    int insertBloodSugar(MonitorBloodSugar record);

    MonitorBloodOxygen getLatestBloodOxygen(int id);

    int insertBloodOxygen(MonitorBloodOxygen record);

    MonitorCholesterol getLatestCholesterol(int id);

    int insertCholesterol(int id);

    MonitorFat getLatestFat(int id);

    int insertFat(int id);

    MonitorHeightWeight getLatestHeightWeight(int id);

    int insertHeightWeight(int id);

    MonitorUricAcid getLatestUricAcid(int id);

    int insertUricAcid(int id);
}
