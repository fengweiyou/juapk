package com.juapk.service.impl;

import java.util.List;

import com.juapk.dao.AdDAO;
import com.juapk.domain.Ad;
import com.juapk.frame.common.PageModel;
import com.juapk.frame.exception.BaseException;
import com.juapk.service.AdService;

/**
 * 项目名称：juapk
 * 类名称：AdService
 * 类描述：广告数据访问服务实现类 
 * 创建人：hubin 
 * 创建时间：2012-6-01
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class AdServiceImpl implements AdService {
	private AdDAO adDAO;
	
	public void setAdDAO(AdDAO adDAO) {
		this.adDAO = adDAO;
	}

	@Override
	public void deleteAdById(int id) throws BaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertAd(Ad ad) throws BaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public PageModel getAdById() throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ad queryAdById(Integer id) throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAd(Ad ad) throws BaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Ad> getAllAdList(int location) throws BaseException {
		return adDAO.getAllAdList(location);
	}

}
