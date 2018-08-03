package org.calendar.jan.repository;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.calendar.jan.model.Biubiu;

/**
 * 手写的Dao
 * @author xman
 *
 */
public interface CommonDao {

	@Select("SELECT * FROM biubiu")
	@Results({
		@Result(property = "id",  column = "id"),
		@Result(property = "name", column = "name"),
		@Result(property = "age", column = "age"),
		@Result(property = "address", column = "address"),
		@Result(property = "time", column = "time", javaType = Date.class)
	})
	List<Biubiu> getAll();
	
	@Select("SELECT * FROM biubiu WHERE id = #{id}")
	@Results({
		@Result(property = "time", column = "time", javaType = Date.class)
	})
	Biubiu getOne(Integer id);

	@Insert("INSERT INTO biubiu(name, age, address, time) VALUES(#{name}, #{age}, #{address}, #{time,jdbcType=TIMESTAMP})")
	void insert(Biubiu biubiu);

	@Update("UPDATE biubiu SET name=#{name}, age=#{age}, address=#{address}, time=#{time,jdbcType=TIMESTAMP} WHERE id = #{id}")
	void update(Biubiu biubiu);

	@Delete("DELETE FROM biubiu WHERE id = #{id}")
	void delete(Integer id);
	
}
