package com.juapk.service;

import java.util.List;

import com.juapk.domain.Ad;
import com.juapk.frame.common.PageModel;
import com.juapk.frame.exception.BaseException;

/**
 * 项目名称：juapk
 * 类名称：AdService
 * 类描述：广告数据访问服务 
 * 创建人：hubin 
 * 创建时间：2012-6-01
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public interface AdService {

	void insertAd(Ad customer) throws BaseException;

	void updateAd(Ad Ad) throws BaseException;

	void deleteAdById(int id) throws BaseException;

	Ad queryAdById(Integer id) throws BaseException;

	PageModel getAdById() throws BaseException;
	
	List<Ad> getAllAdList(int location) throws BaseException;
}
