package com.japtoch.translation.controller;

import lombok.Data;

import java.io.Serializable;

@Data
public class JsonResult<E>  implements Serializable {
    // 状态码
    private Integer state;
    // 描述信息
    private String message;
    // 数据
    private E data;



}
