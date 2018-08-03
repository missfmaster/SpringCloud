package org.calendar.jan;

import org.calendar.jan.repository.BiubiuDao;
import org.calendar.jan.repository.CommonDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("org.calendar.jan.repository")
public class JanuaryApplicationTests {

	@Autowired
	private BiubiuDao biubiuDao;
	@Autowired
	private CommonDao commonDao;
	
	@Test
	public void contextLoads() {
		System.out.println(biubiuDao);
		System.out.println(commonDao);
	}

}
