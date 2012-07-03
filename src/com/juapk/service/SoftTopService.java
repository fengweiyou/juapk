package com.juapk.service;

import java.util.List;

import com.juapk.domain.SoftTop;
import com.juapk.frame.common.QueryItem;
import com.juapk.frame.exception.BaseException;

/**
 * 项目名称：juapk
 * 类名称：SoftTopService
 * 类描述：软件排行数据访问服务 
 * 创建人：hubin
 * 创建时间：2012.02.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public interface SoftTopService {
	
	void insertSoftTop(SoftTop softTop) throws BaseException;

	void updateSoftTop(SoftTop softTop) throws BaseException;

	void deleteSoftTopById(int id) throws BaseException;

	SoftTop getSoftTopById(Integer id) throws BaseException;
	
	List<SoftTop> getSoftTopListByQueryItem(QueryItem queryItem) throws BaseException;
	
	List<SoftTop> getSoftTopListByWhere(String where) throws BaseException;
	
	int getSoftTopCountByWhere(String where) throws BaseException;
	
}