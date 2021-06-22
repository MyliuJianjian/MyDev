package com.my.exception;

/**
 * 功能描述
 *
 * @author LIUJIANJIAN
 * @date 2021年6月22日15:13:10$
 */
public class MyException extends Exception {
    public MyException(){}
    public MyException(String msg){
        super(msg);
    }
}
