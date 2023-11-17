package com.japtoch.translation;

import com.japtoch.translation.entity.TextEntity;
import com.japtoch.translation.service.TextService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TranslationApplicationTests {

	@Autowired
	private TextService textService;
	@Test
	public void insertText() {
		try {
			TextEntity textEntity = new TextEntity();
			textEntity.setId(55);
			textEntity.setChineseQuestion("中文插入数据");
			textEntity.setJapaneseQuestion("これは日本語ですよう");
			textService.addText(textEntity);
			System.out.println("ok");
		} catch (RuntimeException e) {
			// 获取类的对象，在获取类的名称
			System.out.println(e.getClass().getSimpleName());
// 获取异常的具体描述信息
			System.out.println(e.getMessage());

		}
	}
	@Test
	void contextLoads() {
	}

}
