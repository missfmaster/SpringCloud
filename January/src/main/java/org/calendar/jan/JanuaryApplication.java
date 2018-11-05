package org.calendar.jan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("org.calendar.jan.repository") // 扫描mybatis映射类
@ComponentScan("org.calendar.jan") // 扫描指定包
public class JanuaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(JanuaryApplication.class, args);
	}
	
}