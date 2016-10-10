package com.app.demo.net;

import java.util.List;
import java.util.Map;

/**
 * TODO:功能说明
 *
 * @author: hejie
 * @date: 2016-09-30 15:34
 */
public abstract class RequestCallback {
    public abstract void netWork();

    public abstract void complete(Exception e, int code, String result);

    public abstract void onHeaders(Map<String, List<String>> headMap);
}
