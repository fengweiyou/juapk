package com.juapk.dao;

import java.util.List;

import com.juapk.domain.SoftTop;
import com.juapk.frame.common.QueryItem;
import com.juapk.frame.exception.BaseException;

/**
 * 项目名称：juapk
 * 类名称：SoftTopDAO
 * 类描述：排行软件数据访问对象
 * 创建人：hubin
 * 创建时间：2011.12.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public interface SoftTopDAO {
	
	/**
	 * 新增软件排行信息
	 * 
	 * @param softTop
	 * @throws SoftTopException
	 */
	void insertSoftTop(SoftTop softTop) throws BaseException;

	/**
	 * 修改软件排行信息
	 * 
	 * @param softTop
	 * @throws BaseException
	 */

	void updateSoftTop(SoftTop softTop) throws BaseException;

	/**
	 * 根据id删除软件排行信息
	 * 
	 * @param id
	 *            指定id
	 * @throws BaseException
	 */

	void deleteSoftTopById(int id) throws BaseException;

	/**
	 * 根据id 查询一条记录
	 * 
	 * @param id
	 *            指定id
	 * @return 返回的对象
	 * @throws BaseException
	 */

	SoftTop getSoftTopById(Integer id) throws BaseException;
	
	/**
	 * 查询软件排行列表记录
	 * @return 软件排行记录
	 * @param queryItem
	 * @throws BaseException
	 */
	List<SoftTop> getSoftTopListByQueryItem(QueryItem queryItem) throws BaseException;
	
	/**
	 * 查询满足 where 条件的软件排行记录
	 * 
	 * @param where
	 *            	SQL WHERE 查询条件
	 * @return List<SoftTop>
	 * 				软件排行记录
	 * @throws BaseException
	 */
	List<SoftTop> getSoftTopListByWhere(String where) throws BaseException;
	
	/**
	 * 查询满足条件的软件排行数量
	 * @return 软件排行数量
	 * @throws BaseException
	 */
	int getSoftTopCountByWhere(String where) throws BaseException;
	
}