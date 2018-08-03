package org.calendar.jan.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.calendar.jan.model.Biubiu;
import org.calendar.jan.model.BiubiuCriteria;

/**
 * 此类为mybatis自动生成类
 * @author xman
 *
 */
public interface BiubiuDao {
	
    long countByCriteria(BiubiuCriteria criteria);

    int deleteByCriteria(BiubiuCriteria criteria);

    int deleteByPrimaryKey(Integer id);

    int insert(Biubiu record);

    int insertSelective(Biubiu record);

    List<Biubiu> selectByCriteria(BiubiuCriteria criteria);

    Biubiu selectByPrimaryKey(Integer id);

    int updateByCriteriaSelective(@Param("record") Biubiu record, @Param("criteria") BiubiuCriteria criteria);

    int updateByCriteria(@Param("record") Biubiu record, @Param("criteria") BiubiuCriteria criteria);

    int updateByPrimaryKeySelective(Biubiu record);

    int updateByPrimaryKey(Biubiu record);
}