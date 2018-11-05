package org.calendar.jan;

import java.util.Date;

import org.calendar.jan.model.Biubiu;
import org.calendar.jan.repository.BiubiuDao;
import org.calendar.jan.repository.CommonDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("org.calendar.jan.repository")
public class JanuaryApplicationTests {

	@Autowired
	private BiubiuDao biubiuDao;
	@Autowired
	private CommonDao commonDao;
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@Test
	public void contextLoads() {
		System.out.println(biubiuDao);
		System.out.println(commonDao);
	}
	
	@Test
	public void redisTest() {
		// 字符串测试
		System.out.println(redisTemplate);
		//redisTemplate.opsForValue().set("testKey", "testValue");
		//String testValue = (String) redisTemplate.opsForValue().get("testKey");
		//System.out.println(testValue);
		// 对象测试
		Biubiu biu = new Biubiu();
		biu.setId(11);
		biu.setName("小王");
		biu.setAge(22);
		biu.setAddress("🌎");
		biu.setTime(new Date());
		redisTemplate.opsForValue().set("testObj", biu);
		ValueOperations<String, Object> ops = redisTemplate.opsForValue();
		Object obj = ops.get("testObj");
		System.out.println(obj);
	}

}
