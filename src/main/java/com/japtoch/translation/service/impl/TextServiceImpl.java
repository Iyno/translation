package com.japtoch.translation.service.impl;

import com.japtoch.translation.entity.TextEntity;
import com.japtoch.translation.mapper.TextMapper;
import com.japtoch.translation.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TextServiceImpl implements TextService {
    @Autowired
    private TextMapper textMapper;

    @Override
    public void addText(TextEntity textEntity) {
        Integer rows = textMapper.insert(textEntity);

    }

    @Override
    public TextEntity getById(Integer id) {
//        TextEntity result = textMapper.findById(id);
        if (id == null){
            throw new RuntimeException("数据不存在");
        }

        return textMapper.findById(id);

//        TextEntity textEntity = new TextEntity();
//        textEntity.setJapaneseQuestion(result.getJapaneseQuestion());
//        textEntity.setChineseQuestion(result.getChineseQuestion());


    }

    @Override
    public void changeInfo(Integer id, TextEntity textEntity) {
        TextEntity result = textMapper.findById(id);
        if (result == null){
            throw new RuntimeException("数据不存在");
        }
        textEntity.setId(id);
        Integer rows = textMapper.updateInfoById(textEntity);

        if (rows != 1){
            throw new RuntimeException("更新数据产生未知的异常");
        }


    }

    @Override
    public void deleteText(Integer id) {
        TextEntity result = textMapper.findById(id);
        if (result == null){
            throw new RuntimeException("数据不存在");
        }

        Integer rows = textMapper.deleteById(id);

        if (rows != 1){
            throw new RuntimeException("更新数据产生未知的异常");
        }

    }
}
