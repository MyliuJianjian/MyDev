package com.my.common;

import java.io.Serializable;
import java.util.logging.Logger;

/**
 * 功能描述
 *
 * @author LIUJIANJIAN
 * @date 2021年6月22日15:21:03$
 */
public class ResultUtils<T> implements Serializable {
        private static final long serialVersionUID = 1L;

        public static final String CODE_0000 = "0000";
        public static final String MSG_0000 = "请求成功！";
        public static final String CODE_0001 = "0001";
        public static final String MSG_0001 = "请求失败！";

        private String code;

        private T data;

        private String msg;

        public void setCode(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public ResultUtils() {
            this.code = ResultUtils.CODE_0000;
            this.msg = ResultUtils.MSG_0000;
        }

        public ResultUtils(String code, String msg, T data) {
            this.code = code;
            this.msg = msg;
            this.data = data;
        }

        public static ResultUtils Error(ResultUtils result, String msg, Logger log){
            result.setCode(ResultUtils.CODE_0001);
            result.setMsg(msg);
            log.info(msg);
            return result;
        }

    public static ResultUtils Error( String msg){
        ResultUtils result=new ResultUtils();
        result.setCode(ResultUtils.CODE_0001);
        result.setMsg(msg);
        return result;
    }

        public static ResultUtils Error(ResultUtils result){
            result.setCode(ResultUtils.CODE_0001);
            result.setMsg(ResultUtils.MSG_0001);
            return result;
        }

        public static ResultUtils Success(ResultUtils result, String msg, Logger log){
            result.setCode(ResultUtils.CODE_0000);
            result.setMsg(msg);
            log.info(msg);
            return result;
        }

        public static ResultUtils Success(ResultUtils result){
            result.setCode(ResultUtils.CODE_0000);
            result.setMsg(ResultUtils.MSG_0000);
            return result;
        }
}
