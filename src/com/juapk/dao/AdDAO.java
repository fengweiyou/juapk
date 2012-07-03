package com.juapk.dao;

import java.util.List;

import com.juapk.domain.Ad;
import com.juapk.frame.common.PageModel;
import com.juapk.frame.exception.BaseException;

/**
 * 项目名称：juapk
 * 类名称：AdDAO
 * 类描述：广告数据访问对象
 * 创建人：hubin
 * 创建时间：2011.12.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public interface AdDAO {
	/**
	 * 新增广告
	 * 
	 * @param customer
	 * @throws CustomerException
	 */
	void insertAd(Ad ad) throws BaseException;

	/**
	 * 修改广告
	 * 
	 * @param customer
	 * @throws CustomerException
	 */

	void updateAd(Ad ad) throws BaseException;

	/**
	 * 根据id删除广告
	 * 
	 * @param id
	 *            指定id
	 * @throws BaseException
	 */

	void deleteAdById(int id) throws BaseException;

	/**
	 * 根据id 查询一条记录
	 * 
	 * @param id
	 *            指定id
	 * @return 返回的对象
	 * @throws BaseException
	 */

	Ad getAdById(Integer id) throws BaseException;

	/**
	 * 查询所有广告
	 * 
	 * @return 包含所有广告的集合对象
	 * @throws BaseException
	 */

	PageModel queryAllAds() throws BaseException;
	
	/**
	 * 根据广告位置 location 查询广告记录
	 * @param location
	 * 				广告位置、如:焦点图,Bannaer
	 * @return List<Ad> 广告记录
	 * @exception BaseException
	 */
	List<Ad> getAllAdList(int location) throws BaseException;
	
}
