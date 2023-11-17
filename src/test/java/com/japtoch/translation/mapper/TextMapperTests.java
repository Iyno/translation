package com.japtoch.translation.mapper;


import com.japtoch.translation.entity.TextEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TextMapperTests {
    @Autowired
    private TextMapper textMapper;

    @Test
    public void insert(){
        TextEntity textEntity = new TextEntity();
//        textEntity.setId(1);
        textEntity.setJapaneseQuestion("これはテストだよ");
        textEntity.setChineseQuestion("这个是一个测试");
        Integer rows = textMapper.insert(textEntity);
        System.out.println(rows);
    }

    @Test
    public void findByUsername(){
        TextEntity text=textMapper.findById(1);
        System.out.println(text);
    }

    @Test
    public void updateInfoByUid(){
        TextEntity textEntity = new TextEntity();
        textEntity.setId(1);
        textEntity.setChineseQuestion("更新后的文本");
        textEntity.setJapaneseQuestion("これは更新したの文書");
        textMapper.updateInfoById(textEntity);
    }
    @Test
    public void deleteById(){
        textMapper.deleteById(1);
    }



}
