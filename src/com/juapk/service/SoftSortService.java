package com.juapk.service;

import java.util.List;

import com.juapk.domain.SoftSort;
import com.juapk.frame.common.QueryItem;
import com.juapk.frame.exception.BaseException;

/**
 * 项目名称：juapk
 * 类名称：SoftSortService
 * 类描述：软件类型数据访问服务 
 * 创建人：hubin
 * 创建时间：2012.02.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public interface SoftSortService {

	/**
	 * 新增软件类别信息
	 * 
	 * @param softSort
	 * 				软件类别
	 * @throws BaseException
	 */
	void insertSoftSort(SoftSort softSort) throws BaseException;

	void updateSoftSort(SoftSort softSort) throws BaseException;

	/**
	 * 根据id删除软件类别信息
	 * 
	 * @param id
	 *            指定id
	 * @throws BaseException
	 */
	void deleteSoftSortById(String id) throws BaseException;

	SoftSort getSoftSortById(Integer id) throws BaseException;
	
	List<SoftSort> getSoftSortListByWhere(String where) throws BaseException;

	List<SoftSort> getSoftSortListByQueryItem(QueryItem queryItem) throws BaseException;
	
	int getSoftSortCountByWhere(String where) throws BaseException;
	
}