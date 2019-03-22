package com.supi.mh.restful.app.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.supi.mh.api.mybatis.HealthMonitorService;
import com.supi.mh.api.mybatis.UserService;
import com.supi.mh.entity.pojo.*;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.ResponseJson;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by supiccc on 2019-03-17 23:22
 */
@RestController
@RequestMapping("/monitor/v1")
public class HealthMonitorController {

    @Reference(version = "1.0.0")
    private HealthMonitorService healthMonitorService;

    @Reference(version = "1.0.0")
    private UserService userService;

    private com.supi.mh.restful.app.service.HealthMonitorService h;

    public com.supi.mh.restful.app.service.HealthMonitorService getH() {
        return h;
    }

    @Autowired
    public void setH(com.supi.mh.restful.app.service.HealthMonitorService h) {
        this.h = h;
    }

    /**
     * 获取居民最新的血压值
     * @param id 用户id
     * @return 0 成功返回，1 未查询到结果，2 未登陆
     */
    @RequestMapping("/LastestBloodPressure")
    public ResponseJson getLastestBloodPressure(int id, HttpServletRequest request) {
        // 判断用户是否登录
        String token = request.getHeader("token") == null ? "" : request.getHeader("token");
        if (token.equals("")) return new ResponseJson(2, "no login", null);

        // 判断是否本人



        try {
            // 获取居民id
            int elder_id = userService.findElderIdById(id);

            // 获取数据
            LatestBloodPressure l = healthMonitorService.getLatestBloodPressure(elder_id);
            return new ResponseJson(0, "success", l);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return new ResponseJson(1, "error", null);
    }

    /**
     * 获取居民最新的血氧值
     * @param id 用户id
     * @param request
     * @return 0 成功返回，1 未查询到结果，2 未登陆
     */
    @RequestMapping("/LastestBloodOxygen")
    public ResponseJson getLastestBloodOxygen(int id, HttpServletRequest request) {
        // 判断用户是否登录
        String token = request.getHeader("token") == null ? "" : request.getHeader("token");
        if (token.equals("")) return new ResponseJson(2, "no login", null);

        // 判断是否本人

        try {
            int elder_id = userService.findElderIdById(id);

            MonitorBloodOxygen m = healthMonitorService.getLatestBloodOxygen(elder_id);
            return new ResponseJson(0, "success", m);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return new ResponseJson(1, "error", null);
    }

    /**
     * 获取居民最新的血糖值
     * @param id 用户id
     * @param request
     * @return 0 成功返回，1 未查询到结果，2 未登陆
     */
    @RequestMapping("/LatestBloodSugar")
    public ResponseJson getLatestBloodSugar(int id, HttpServletRequest request) {
        // 判断用户是否登录
        String token = request.getHeader("token") == null ? "" : request.getHeader("token");
        if (token.equals("")) return new ResponseJson(2, "no login", null);

        // 判断是否本人

        try {
            int elder_id = userService.findElderIdById(id);

            MonitorBloodSugar m = healthMonitorService.getLatestBloodSugar(elder_id);
            return new ResponseJson(0, "success", m);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return new ResponseJson(1, "error", null);
    }


    /**
     * 获取居民最新的胆固醇值
     * @param id 用户id
     * @param request
     * @return 0 成功返回，1 未查询到结果，2 未登陆
     */
    @RequestMapping("/LatestCholesterol")
    public  ResponseJson getLatestCholesterol(int id, HttpServletRequest request) {
        // 判断用户是否登录
        String token = request.getHeader("token") == null ? "" : request.getHeader("token");
        if (token.equals("")) return new ResponseJson(2, "no login", null);

        // 判断是否本人

        try {
            int elder_id = userService.findElderIdById(id);

            MonitorCholesterol m = healthMonitorService.getLatestCholesterol(elder_id);
            return new ResponseJson(0, "success", m);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return new ResponseJson(1, "error", null);
    }

    @RequestMapping("/LatestFat")
    public ResponseJson getLatestFat(int id, HttpServletRequest request) {
        // 判断用户是否登录
        String token = request.getHeader("token") == null ? "" : request.getHeader("token");
        if (token.equals("")) return new ResponseJson(2, "no login", null);

        // 判断是否本人

        try {
            int elder_id = userService.findElderIdById(id);

            MonitorFat m = healthMonitorService.getLatestFat(elder_id);
            return new ResponseJson(0, "success", m);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return new ResponseJson(1, "error", null);
    }

    @RequestMapping("/LatestHeightWeight")
    public ResponseJson getLatestHeightWeight(int id, HttpServletRequest request) {
        // 判断用户是否登录
        String token = request.getHeader("token") == null ? "" : request.getHeader("token");
        if (token.equals("")) return new ResponseJson(2, "no login", null);

        // 判断是否本人

        try {
            int elder_id = userService.findElderIdById(id);

            MonitorHeightWeight m = healthMonitorService.getLatestHeightWeight(elder_id);
            return new ResponseJson(0, "success", m);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return new ResponseJson(1, "error", null);
    }

    @RequestMapping("/LatestUricAcid")
    public ResponseJson getLatestUricAcid(int id, HttpServletRequest request) {
        // 判断用户是否登录
        String token = request.getHeader("token") == null ? "" : request.getHeader("token");
        if (token.equals("")) return new ResponseJson(2, "no login", null);

        // 判断是否本人

        try {
            int elder_id = userService.findElderIdById(id);

            MonitorUricAcid m = healthMonitorService.getLatestUricAcid(elder_id);
            return new ResponseJson(0, "success", m);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return new ResponseJson(1, "error", null);
    }

    /**
     * 插入新的血压值
     * @param m 新值
     * @param request 请求
     * @return 0 成功；1 失败
     */
    @RequestMapping("/insert/bloodpressure")
    public ResponseJson insertBloodPressure(MonitorBloodPressure m, HttpServletRequest request) {
        // 判断用户是否登录
//        String token = request.getHeader("token") == null ? "" : request.getHeader("token");
//        if (token.equals("")) return new ResponseJson(2, "no login", null);

        // 判断是否本人

        // 插入
        return h.insertBloodPressure(m) ? new ResponseJson(0, "success", null) : new ResponseJson(1,"error", null);

    }
}
