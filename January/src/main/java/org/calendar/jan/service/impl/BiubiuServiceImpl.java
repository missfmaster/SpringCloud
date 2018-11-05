package org.calendar.jan.service.impl;

import java.util.List;

import org.calendar.jan.model.Biubiu;
import org.calendar.jan.model.BiubiuCriteria;
import org.calendar.jan.repository.BiubiuDao;
import org.calendar.jan.service.BiubiuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BiubiuServiceImpl implements BiubiuService {

	@Autowired
	private BiubiuDao biubiuDao;
	
	@Override
	public void insertBiubiu(Biubiu biubiu) {
		biubiuDao.insert(biubiu);
	}

	@Override
	public void updateBiubiu(Biubiu biubiu) {
		biubiuDao.updateByPrimaryKeySelective(biubiu);
	}

	@Override
	public void deleteBiubiu(Integer id) {
		biubiuDao.deleteByPrimaryKey(id);
	}

	@Override
	public Biubiu queryBiubiu(Integer id) {
		return biubiuDao.selectByPrimaryKey(id);
	}

	@Override
	public List<Biubiu> queryBiubius() {
		BiubiuCriteria bc = new BiubiuCriteria();
		bc.setOrderByClause("time desc");
		return biubiuDao.selectByCriteria(bc);
	}

	@Override
	public Biubiu resetBiubiu(Biubiu biubiu) {
		biubiuDao.deleteByPrimaryKey(biubiu.getId());
		biubiuDao.insert(biubiu);
		return biubiu;
	}

}
