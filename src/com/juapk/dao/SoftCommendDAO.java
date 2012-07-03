package com.juapk.dao;

import java.util.List;

import com.juapk.domain.SoftCommend;
import com.juapk.frame.common.QueryItem;
import com.juapk.frame.exception.BaseException;

/**
 * 项目名称：juapk
 * 类名称：SoftCommendDAO
 * 类描述：推荐软件数据访问对象
 * 创建人：hubin
 * 创建时间：2011.12.25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public interface SoftCommendDAO {
	
	void insertSoftCommend(SoftCommend softCommend) throws BaseException;

	void updateSoftCommend(SoftCommend softCommend) throws BaseException;

	void deleteSoftCommendById(int id) throws BaseException;

	SoftCommend getSoftCommendByWhere(String where) throws BaseException;
	
	List<SoftCommend> getSoftCommendListByQueryItem(QueryItem queryItem) throws BaseException;
	
	List<SoftCommend> getSoftCommendListByWhere(String where) throws BaseException;
	
	/**
	 * 查询满足 where 条件的推荐软件数量
	 * 
	 * @param where
	 *            SQL WHERE 查询条件
	 * @return int 推荐软件数量
	 * @throws BaseException
	 */
	int getSoftCommendCountByWhere(String where) throws BaseException;
	
}