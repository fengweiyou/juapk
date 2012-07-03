package com.juapk.dao;

import java.util.List;

import com.juapk.domain.Soft;
import com.juapk.frame.common.QueryItem;
import com.juapk.frame.exception.BaseException;

/**
 * 项目名称：juapk
 * 类名称：SoftDAO
 * 类描述：软件数据访问对象
 * 创建人：hubin
 * 创建时间：2011.12.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public interface SoftDAO {
	
	/**
	 * 新增软件信息
	 * 
	 * @param soft
	 * 			软件
	 * @throws BaseException
	 */
	void insertSoft(Soft soft) throws BaseException;

	/**
	 * 修改软件信息
	 * 
	 * @param soft
	 * @throws BaseException
	 */

	void updateSoft(Soft soft) throws BaseException;

	/**
	 * 根据id删除软件信息
	 * 
	 * @param id
	 *            指定id
	 * @throws BaseException
	 */

	void deleteSoftById(int id) throws BaseException;

	/**
	 * 查询满足 where 条件的软件对象
	 * 
	 * @param where
	 *            SQL WHERE 查询条件
	 * @return Soft 软件记录
	 * @throws BaseException
	 */
	Soft getSoftByWhere(String where) throws BaseException;
	
	/**
	 * 查询满足 QueryItem 条件的软件记录
	 * @param queryItem
	 * 				SQL QueryItem 查询条件
	 * @return List<Soft>
	 * 				软件记录
	 * @throws BaseException
	 */
	List<Soft> getSoftListByQueryItem(QueryItem queryItem) throws BaseException;
	
	/**
	 * 查询满足 where 条件的软件记录
	 * @param where
	 * 			SQL WHERE 查询条件
	 * @return List<Soft>
	 * 			软件记录
	 */
	List<Soft> getSoftListByWhere(String where) throws BaseException;
	
	/**
	 * 查询满足 where 条件的软件数量
	 * @param where
	 * 			SQL WHERE 查询条件
	 * @return int
	 * 			软件数量
	 * @throws BaseException
	 */
	int getSoftCountByWhere(String where) throws BaseException;
	
	/**
	 * 查询满足 type 条件的Top软件排行记录
	 * @param where
	 * 			SQL WHERE 查询条件
	 * @return List<Soft>
	 * 			Top 软件排行记录
	 */
	List<Soft> getSoftTopListByType(int type) throws BaseException;

	/**
	 * 查询满足 where 条件的推荐软件记录
	 * @param where
	 * 			SQL WHERE 查询条件
	 * @return List<Soft>
	 * 			推荐软件记录
	 */
	List<Soft> getSoftCommendListByWhere(String where) throws BaseException;
	
	/**
	 * 查询满足 QueryItem 条件的推荐软件记录
	 * @param queryItem
	 * 				SQL QueryItem 查询条件
	 * @return List<Soft>
	 * 				推荐软件记录
	 * @throws BaseException
	 */
	List<Soft> getSoftCommendListByQueryItem(QueryItem queryItem) throws BaseException;
	
	/**
	 * 查询满足 where 条件的Topic专题软件记录
	 * @param where
	 * 			SQL WHERE 查询条件
	 * @return List<Soft>
	 * 			Topic专题软件记录
	 */
	List<Soft> getSoftTopicListByWhere(String where) throws BaseException;
	
	/**
	 * 查询满足 QueryItem 条件的Topic专题软件记录
	 * @param queryItem
	 * 				SQL QueryItem 查询条件
	 * @return List<Soft>
	 * 				Topic专题软件记录
	 * @throws BaseException
	 */
	List<Soft> getSoftTopicListByQueryItem(QueryItem queryItem) throws BaseException;

}