package com.chen.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.chen.service.FilmService;

/**
 * 容器启动完成后初始化索引文件
 * 
 */
public class InitIndexListener implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private FilmService filmService;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (event.getApplicationContext().getParent() == null) {//确定父容器初始化好了
			System.out.println("建立索引文件");
			filmService.initIndexFile();// 建立索引文件
		}
	}

}
