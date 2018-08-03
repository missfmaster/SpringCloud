package org.calendar.jan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.calendar.jan.repository") // 扫描mybatis映射类
public class JanuaryApplication {

	public static void main(String[] args) {
		
	}
}