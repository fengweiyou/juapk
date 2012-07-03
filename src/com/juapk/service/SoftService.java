package com.juapk.service;

import java.util.List;

import com.juapk.domain.Soft;
import com.juapk.frame.common.QueryItem;
import com.juapk.frame.exception.BaseException;

/**
 * 项目名称：juapk
 * 类名称：SoftService
 * 类描述：软件数据访问服务 
 * 创建人：hubin
 * 创建时间：2012.02.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public interface SoftService {
	
	/**
	 * 新增软件信息
	 * 
	 * @param soft
	 * 			软件
	 * @throws BaseException
	 */
	void insertSoft(Soft soft) throws BaseException;

	void updateSoft(Soft soft) throws BaseException;

	void deleteSoftById(int id) throws BaseException;

	/**
	 * 根据关键字段 ID 获得软件对象
	 * @param id 
	 * 			软件关键字段 ID
	 * @return Soft 软件记录
	 * @exception BaseException
	 */
	Soft getSoftById(Integer id) throws BaseException;

	Soft getSoftByWhere(String where) throws BaseException;
	
	List<Soft> getSoftListByQueryItem(QueryItem queryItem) throws BaseException;
	
	List<Soft> getSoftListByWhere(String where) throws BaseException;
	
	int getSoftCountByWhere(String where) throws BaseException;
	
	/**
	 * 根据 type 查询软件排行记录
	 * 
	 * @param type
	 * 				类型
	 * @return List<Soft>
	 * 				软件记录
	 * @throws BaseException
	 */
	List<Soft> getSoftTopListByType(int type) throws BaseException;
	
	List<Soft> getSoftCommendListByWhere(String where) throws BaseException;
	
	List<Soft> getSoftCommendListByQueryItem(QueryItem queryItem) throws BaseException;
	
	/**
	 * 根据 topic_id 查询专题软件记录
	 * 
	 * @param topic_id
	 * 				专题 ID
	 * @return List<Soft>
	 * 				软件记录
	 * @throws BaseException
	 */
	List<Soft> getSoftTopicListByTopicId(String topic_id) throws BaseException;
	
	List<Soft> getSoftTopicListByWhere(String where) throws BaseException;
	
	List<Soft> getSoftTopicListByQueryItem(QueryItem queryItem) throws BaseException;
}