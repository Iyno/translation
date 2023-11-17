package com.japtoch.translation.service;

import com.japtoch.translation.entity.TextEntity;

public interface TextService {
    //插入文章
    void addText(TextEntity textEntity);
//    根据id查询文章
    TextEntity getById(Integer id);
//    根据id修改文章
    void changeInfo(Integer id,TextEntity textEntity);
//    根据id删除文章
    void deleteText(Integer id);



}
