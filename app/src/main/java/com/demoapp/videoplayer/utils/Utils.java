package com.demoapp.videoplayer.utils;

public class Utils {
    public static String BASE_URL = "http://0.tcp.in.ngrok.io:14752/";

    public static String ARG_VIDEO_URL = "VIDEO_URL";
    public static String ARG_VIDEO_INFO = "VIDEO_INFO";

    public static String formatUrl(String url) {
        if (url.startsWith("//")) {
            return "https:" + url;
        } else {
            return url;
        }
    }
}
