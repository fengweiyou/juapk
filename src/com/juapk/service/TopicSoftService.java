package com.juapk.service;

import java.util.List;

import com.juapk.domain.TopicSoft;
import com.juapk.frame.common.QueryItem;
import com.juapk.frame.exception.BaseException;

/**
 * 项目名称：juapk
 * 类名称：TopicSoftService
 * 类描述：专题软件数据访问服务 
 * 创建人：hubin
 * 创建时间：2012.02.26
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public interface TopicSoftService {
	
	void insertTopicSoftSoft(TopicSoft topicSoft) throws BaseException;

	void updateTopicSoft(TopicSoft topicSoft) throws BaseException;

	void deleteTopicSoftById(int id) throws BaseException;

	TopicSoft getTopicSoftByWhere(String where) throws BaseException;
	
	List<TopicSoft> getTopicSoftListByQueryItem(QueryItem queryItem) throws BaseException;
	
	List<TopicSoft> getTopicSoftListByWhere(String where) throws BaseException;
	
	int getTopicSoftCountByWhere(String where) throws BaseException;
	
}