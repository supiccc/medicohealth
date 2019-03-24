package com.supi.mh.api.mybatis;

import com.supi.mh.entity.pojo.Warning;

import java.util.ArrayList;

/**
 * Created by supiccc on 2019-03-23 02:31
 */
public interface WarningDaoService {
    ArrayList<Warning> getAll();
}
