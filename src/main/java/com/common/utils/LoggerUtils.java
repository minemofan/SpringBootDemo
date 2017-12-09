package com.common.utils;

import org.slf4j.Logger;

public class LoggerUtils {

    /**
     * Description info级别
     * @param log
     * @param msg
     */
    public static void info(Logger log, String msg){
        if(log.isInfoEnabled()) {
            log.info(msg);
        }
    }

    /**
     * Description info级别
     * @param log
     * @param objs
     */
    public static void info(Logger log, String msg, Object... objs){
        if(log.isInfoEnabled()) {
            for(int i=0;i<objs.length;i++){
                String flag = "{"+ i + "}";
                if(msg.indexOf(flag) > 0){
                    Object obj = objs[i];
                    msg = msg.replace(flag, String.valueOf(obj));
                }
            }
            log.info(msg);
        }
    }


    /**
     * Description warn级别
     * @param log
     * @param msg
     */
    public static void warn(Logger log, String msg){
        if(log.isWarnEnabled()){
            log.warn(msg);
        }

    }


}
