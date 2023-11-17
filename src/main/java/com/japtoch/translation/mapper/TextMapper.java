package com.japtoch.translation.mapper;

import com.japtoch.translation.entity.TextEntity;

public interface TextMapper {
    /**
     * 插入文章
     * @param
     * @return 受影响的行数
     * 可根据返回值来判断是否执行成功
     */

    Integer insert(TextEntity textEntity);

    /**
     * 根据id来查询文章的数据
     * @param  id 文章id
     * @return 如果找到对应的文章则返回这个文章的数据，如果没有找到这返回null
     */

    TextEntity findById(int id);

    /**
     * 根据id来删除数据
     * @param id
     * @return
     */
    Integer deleteById(int id);

    /**
     * 更新数据
     * @param textEntity
     * @return
     */
    Integer updateInfoById(TextEntity textEntity);
}
