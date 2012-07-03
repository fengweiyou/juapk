package com.juapk.dao;

import java.util.List;

import com.juapk.domain.SoftSort;
import com.juapk.frame.common.QueryItem;
import com.juapk.frame.exception.BaseException;

/**
 * 项目名称：juapk
 * 类名称：SoftSortDAO
 * 类描述：软件类型数据访问对象
 * 创建人：hubin
 * 创建时间：2011.12.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public interface SoftSortDAO {
	
	/**
	 * 新增软件类别信息
	 * 
	 * @param softSort
	 * 				软件类别
	 * @throws BaseException
	 */
	void insertSoftSort(SoftSort softSort) throws BaseException;

	/**
	 * 根据id删除软件类别信息
	 * 
	 * @param id
	 *            指定id
	 * @throws BaseException
	 */
	void deleteSoftSortById(String id) throws BaseException;
	
	/**
	 * 修改软件类别信息
	 * 
	 * @param softSort
	 * 				软件类别
	 * @throws BaseException
	 */

	void updateSoftSort(SoftSort softSort) throws BaseException;

	/**
	 * 根据id 查询一条记录
	 * 
	 * @param id
	 *            指定id
	 * @return 返回的对象
	 * @throws BaseException
	 */

	SoftSort getSoftSortById(Integer id) throws BaseException;
	
	/**
	 * 查询满足 where 条件的软件类别记录
	 * 
	 * @param where
	 *            SQL WHERE 查询条件
	 * @return List<SoftSort> 软件类别记录
	 * @throws BaseException
	 */
	List<SoftSort> getSoftSortListByWhere(String where) throws BaseException;
	
	/**
	 * 查询满足 where 条件的软件类别数量
	 * @param where
	 * 				SQL WHERE 查询条件
	 * @return int
	 * 				软件类别数量
	 * @throws BaseException
	 */
	int getSoftSortCountByWhere(String where) throws BaseException;
	
	/**
	 * 查询满足 QueryItem 条件的软件类别记录
	 * @param queryItem
	 * 				SQL QueryItem 查询条件
	 * @return List<SoftSort>
	 * 				软件类别记录
	 * @throws BaseException
	 */
	List<SoftSort> getSoftSortListByQueryItem(QueryItem queryItem) throws BaseException;
	
}