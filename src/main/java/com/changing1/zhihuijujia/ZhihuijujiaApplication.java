/**
 * 
 */
package com.changing1.zhihuijujia;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.changing1.zhihuijujia.mapper") //扫描的mapper
//@ServletComponentScan
/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
public class ZhihuijujiaApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZhihuijujiaApplication.class, args);
	}

}
