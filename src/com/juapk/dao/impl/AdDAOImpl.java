
package com.juapk.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.juapk.dao.AdDAO;
import com.juapk.domain.Ad;
import com.juapk.frame.common.PageModel;
import com.juapk.frame.exception.BaseException;
import com.juapk.frame.ibatis.IBatisEntityDao;

/**
 * 项目名称：juapk
 * 类名称：AdDAOImpl
 * 类描述：广告数据访问对象实现类 
 * 创建人：hubin
 * 创建时间：2011.12.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class AdDAOImpl extends IBatisEntityDao<Ad> implements AdDAO {
	/** 错误日志 */
	private static transient final Logger LOGGER = LoggerFactory.getLogger(AdDAOImpl.class);
	private static final String GET_AD_BYLOACTION = "getAdByLocation";
	
	@Override
	public void deleteAdById(int id) throws BaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertAd(Ad ad) throws BaseException {
		// TODO Auto-generated method stub

	}

	@Override
	public PageModel queryAllAds() throws BaseException {
		return null;
	}

	@Override
	public Ad getAdById(Integer id) throws BaseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAd(Ad ad) throws BaseException {
		// TODO Auto-generated method stub

	}

	/**
	 * 根据广告位置 location 查询广告记录
	 * @param location
	 * 				广告位置、如:焦点图,Bannaer
	 * @return List<Ad>
	 * 				广告记录
	 * @exception BaseException
	 */
	@Override
	public List<Ad> getAllAdList(int location) throws BaseException {
		List<Ad> adList = null;
		try {
			adList = (List<Ad>) this.findBy("location", location);
		} catch (SQLException e) {
			LOGGER.error("根据广告位置 location 查询广告记录失败."+e.getMessage());
		}
		return adList;
	}

}
