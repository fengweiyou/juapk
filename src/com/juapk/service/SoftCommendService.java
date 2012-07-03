package com.juapk.service;

import java.util.List;

import com.juapk.domain.SoftCommend;
import com.juapk.frame.common.QueryItem;
import com.juapk.frame.exception.BaseException;

/**
 * 项目名称：juapk
 * 类名称：SoftCommendService
 * 类描述：推荐软件数据访问服务
 * 创建人：hubin
 * 创建时间：2011.12.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public interface SoftCommendService {
	
	void insertSoftCommend(SoftCommend softCommend) throws BaseException;

	void updateSoftCommend(SoftCommend softCommend) throws BaseException;

	void deleteSoftCommendById(int id) throws BaseException;

	SoftCommend getSoftCommendByWhere(String where) throws BaseException;
	
	List<SoftCommend> getSoftCommendListByQueryItem(QueryItem queryItem) throws BaseException;
	
	List<SoftCommend> getSoftCommendListByWhere(String where) throws BaseException;
	
	int getSoftCommendCountByWhere(String where) throws BaseException;
	
}