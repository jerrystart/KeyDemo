package com.app.demo.utils;

/**
 * TODO:功能说明
 *
 * @author: hejie
 * @date: 2016-09-30 14:39
 */

import com.google.gson.JsonObject;

import java.util.Map;

/**
 * 请求协议实体
 */

public class IOEntity {

    public static final int HTTP_TIMEOUT = 3000;
    /**
     * 请求地址
     */

    public String requestUrl;

    /**
     * 表单请求参数
     */

    public Map<String, String> params;
    /**
     * JSON请求参数
     */
    public JsonObject jsonObject;
    /**
     * get 请求参数
     */
    public Map<String, String> getObject;

    /**
     * header
     */
    public Map<String, String> headMap;
    /**
     * 是否开启转轮
     */
    public boolean isShowbar = true;
    /**
     * 转轮提示文字
     */
    public String barMessage;
    /**
     * 是否打断请求
     */
    public boolean canCancel = true;
    /**
     * 是否退出当前页面
     */
    public boolean canFinish = false;

    private IOEntity(String requestUrl, Map<String, String> params, JsonObject jsonObject, Map<String, String> getObject, Map<String, String> headMap
            , boolean isShowbar, String barMessage, boolean canCancel, boolean canFinish) {
        this.requestUrl = requestUrl;
        this.params = params;
        this.jsonObject = jsonObject;
        this.getObject = getObject;
        this.headMap = headMap;
        this.isShowbar = isShowbar;
        this.barMessage = barMessage;
        this.canCancel = canCancel;
        this.canFinish = canFinish;
    }

    /**
     * 表单
     */
    public IOEntity(String requestUrl, Map<String, String> params, boolean isShowbar, boolean canFinish, boolean canCancel, String barMessage) {
        this(requestUrl, params, null, null, null, isShowbar, barMessage, canCancel, canFinish);
    }

    /**
     * json
     */
    public IOEntity(String requestUrl, JsonObject jsonObject, boolean isShowbar, boolean canFinish, boolean canCancel, String barMessage) {
        this(requestUrl, null, jsonObject, null, null, isShowbar, barMessage, canCancel, canFinish);
    }

    /**
     * get
     */
    public IOEntity(String requestUrl, Map<String, String> getObject, boolean isShowbar, boolean canFinish, boolean canCancel) {
        this(requestUrl, null, null, getObject, null, isShowbar, "请稍等", canCancel, canFinish);
    }

}
