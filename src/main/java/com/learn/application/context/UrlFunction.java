package com.learn.application.context;


import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yf003 on 2017/9/6.
 */
public class UrlFunction {


    protected static String urlExtension = ".do";

    public static String buildUrl(String urlStr, Object... param) {
        StringBuffer url = new StringBuffer();
        HttpServletRequest request = SpringContextUtil.getRequest();
        String host = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        url.append(host);
        urlStr = urlStr.trim();
        String requestURI = request.getRequestURI();
        if(StringUtils.isBlank(urlStr)) {
            url.append(requestURI);
        } else {
            if(urlStr.charAt(0) != 47) {
                int i = requestURI.lastIndexOf("/");
                String substring = requestURI.substring(0, i);
                url.append(substring).append("/");
            } else {
                String contextPath = request.getContextPath();
                url.append(contextPath);
            }

            buildParam(urlStr, url, param);
        }

        return url.toString();
    }

    private static void buildParam(String urlStr, StringBuffer url, Object[] param) {
        Pattern pattern = Pattern.compile("\\?");
        Matcher matcher = pattern.matcher(urlStr);
        if(matcher.find()) {
            matcher.appendReplacement(url, urlExtension + "?");
            if(param != null) {
                for(int childIndex = 0; matcher.find() && childIndex < param.length; ++childIndex) {
                    if(param[childIndex] == null) {
                        matcher.appendReplacement(url, "");
                    } else {
                        matcher.appendReplacement(url, String.valueOf(param[childIndex]));
                    }
                }

                matcher.appendTail(url);
            }
        } else {
            url.append(urlStr).append(urlExtension);
        }

    }


}
