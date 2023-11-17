package com.japtoch.translation.service;


import com.japtoch.translation.entity.TextEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class TextServiceTests {
    @Autowired
    private TextService textService;
    @Test
    public void insertText(){
        try{
            TextEntity textEntity = new TextEntity();
            textEntity.setId(55);
            textEntity.setChineseQuestion("中文插入数据");
            textEntity.setJapaneseQuestion("これは日本語ですよう");
            textService.addText(textEntity);
            System.out.println("ok");
        }catch (RuntimeException e){
            // 获取类的对象，在获取类的名称
            System.out.println(e.getClass().getSimpleName());
// 获取异常的具体描述信息
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void getByUid(){
        System.out.println(textService.getById(2));
    }

    @Test
    public void changeInfo(){
        TextEntity textEntity = new TextEntity();
        textEntity.setChineseQuestion("13500090009");
        textEntity.setJapaneseQuestion("これは更新の情報です我问问123@qq.com");

        textService.changeInfo(2,textEntity);
    }



}
