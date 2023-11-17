# translation

1、你需要在本地创建数据库：
CREATE TABLE `TranslateInfo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `japanese_question` varchar(200) DEFAULT NULL,
  `chinese_question` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

插入数据：
INSERT INTO TranslateInfo values(1,"これはテストのケース","测试数据");
INSERT INTO TranslateInfo values(2,"これはテストのケース","测试数据");

2、application.yml文件里面的数据库名称和用户名密码需要根据实际情况进行修改
spring:
  datasource:
    type: com.zaxxer.hikari.HikariDataSource
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/exercise?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true&allowPublicKeyRetrieval=true
    username: springstudent
    password: springstudent

3、使用终端进行测试的数据如下
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
 
