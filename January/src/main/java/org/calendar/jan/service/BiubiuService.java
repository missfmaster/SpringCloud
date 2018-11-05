package org.calendar.jan.service;

import java.util.List;

import org.calendar.jan.model.Biubiu;

/**
 * 操作biubiu 
 * @author xman
 *
 */
public interface BiubiuService {

	public void insertBiubiu(Biubiu biubiu);
	
	public void updateBiubiu(Biubiu biubiu);
	
	public void deleteBiubiu(Integer id);
	
	public Biubiu queryBiubiu(Integer id);
	
	public List<Biubiu> queryBiubius();
	
	/**
	 * 实现先根据ID删除，然后再插入的事务性.
	 * @param biubiu
	 * @return
	 */
	public Biubiu resetBiubiu(Biubiu biubiu);
	
}
