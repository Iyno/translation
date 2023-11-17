package com.japtoch.translation.controller;

import com.japtoch.translation.entity.TextEntity;
import com.japtoch.translation.service.TextService;
import jakarta.servlet.http.HttpSession;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 测试数据
 * http://localhost:8666/text/add?id=9&japaneseQuestion=%22nihao%22&chineseQuestion=%22hh%22
 *在终端实现：
 * 根据id查询文章
 * curl -X GET http://localhost:7788/text/7
 * 根据id删除文章
 * curl -X DELETE http://localhost:7788/text/2
 * 根据id修改文章
 *  curl -X PUT -H "Content-Type: application/json" -d
 *  '{"id": 3, "japaneseQuestion": "更新后的标题", "chineseQuestion": "更新后的内容"}'
 *  http://localhost:7788/text/7
 *
 *  新增文章
 *  curl -X POST -H "Content-Type: application/json" -d '{"japaneseQuestion": "新文章标题", "chineseQuestion": "新文章内容"}' http://localhost:7788/text/add
 *
 *
 *
 */
@RestController
@RequestMapping("text")
public class TextController {
    @Autowired
    private TextService textService;


//    新增文章
    @RequestMapping("add")
    public ResponseEntity<Void> addText(@RequestBody TextEntity textEntity){
// 打印日志以确认参数是否正确传递
        System.out.println("Received id: " + textEntity.toString());

        // 打印日志以确认实际执行的查询语句
        System.out.println("Executing query for id: " + textEntity.toString());
        try{
            textService.addText(textEntity);
        }
        catch (RuntimeException e){
            System.err.println(e.getMessage());

        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

//    查询文章
    @GetMapping("/{id}")
    public ResponseEntity<TextEntity> getById(@PathVariable Integer id){
        // 打印日志以确认参数是否正确传递
        System.out.println("Received id: " + id);

        // 打印日志以确认实际执行的查询语句
        System.out.println("Executing query for id: " + id);

        if(id == null){
            throw new RuntimeException("id不能为空");
        }
        TextEntity textEntity = textService.getById(id);
        return new ResponseEntity<>(textEntity, HttpStatus.OK);
    }

//    删除文章
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteText(@PathVariable Integer id) {
        // 打印日志以确认参数是否正确传递
        System.out.println("Received id: " + id);

        // 打印日志以确认实际执行的查询语句
        System.out.println("Executing query for id: " + id);
        if(id == null){
            throw new RuntimeException("id不能为空");
        }
        textService.deleteText(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
//    修改文章
    @PutMapping("/{id}")
    public ResponseEntity<Void> changeInfo(@PathVariable Integer id,@RequestBody TextEntity textEntity) {
        textEntity.setId(id);
        textService.changeInfo(id,textEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
