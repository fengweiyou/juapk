package com.juapk.frame.ibatis;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.engine.impl.SqlMapClientImpl;
import com.ibatis.sqlmap.engine.mapping.sql.stat.StaticSql;
import com.ibatis.sqlmap.engine.mapping.statement.MappedStatement;
import com.juapk.frame.common.QueryItem;
import com.juapk.frame.exception.BaseException;

/**
 * 项目名称：juapk
 * 类名称：IBatisGenericDao
 * 类描述：IBatis DAO 的泛型基类. 继承于Spring的SqlMapClientDaoSupport,
 * 		提供分页函数和若干便捷查询方法，并对返回值作了泛型类型转换.
 * 创建人：hubin
 * 创建时间：2012.01.17
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class IBatisGenericDao extends SqlMapClientDaoSupport {

	public static final String POSTFIX_INSERT = ".insert";

	public static final String POSTFIX_UPDATE = ".update";

	public static final String POSTFIX_DELETE = ".delete";

	public static final String POSTFIX_DELETE_PRIAMARYKEY = ".deleteByPrimaryKey";

	public static final String POSTFIX_SELECT = ".select";

	public static final String POSTFIX_SELECTMAP = ".selectByMap";

	public static final String POSTFIX_SELECTSQL = ".selectBySql";

	/**
	 * 根据ID获取对象
	 * 
	 * @throws BaseException
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> entityClass, Serializable id)
			throws BaseException, SQLException {
		T o = (T) getSqlMapClient().queryForObject(
				entityClass.getName() + POSTFIX_SELECT, id);
		if (o == null)
			throw new BaseException("未找到实体: " + id);
		return o;
	}

	/**
	 * 获取全部对象
	 * 
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> getAll(Class<T> entityClass) throws SQLException {
		return getSqlMapClient().queryForList(
				entityClass.getName() + POSTFIX_SELECT);
	}

	/**
	 * 新增对象
	 * 
	 * @throws SQLException
	 */
	public void insert(Object o) throws SQLException {
		getSqlMapClient().insert(o.getClass().getName() + POSTFIX_INSERT, o);
	}

	/**
	 * 保存对象
	 * 
	 * @throws SQLException
	 */
	public int update(Object o) throws SQLException {
		return getSqlMapClient().update(
				o.getClass().getName() + POSTFIX_UPDATE, o);
	}

	/**
	 * 删除对象
	 * 
	 * @throws SQLException
	 */
	public int remove(Object o) throws SQLException {
		return getSqlMapClient().delete(
				o.getClass().getName() + POSTFIX_DELETE, o);
	}

	/**
	 * 根据ID删除对象
	 * 
	 * @throws SQLException
	 */
	public <T> int removeById(Class<T> entityClass, Serializable id)
			throws SQLException {
		return getSqlMapClient().delete(
				entityClass.getName() + POSTFIX_DELETE_PRIAMARYKEY, id);
	}

	/**
	 * map查询.
	 * 
	 * @param map
	 *            包含各种属性的查询
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> find(Class<T> entityClass, Map<String, Object> map)
			throws SQLException {
		if (map == null) {
			return this.getSqlMapClient().queryForList(
					entityClass.getName() + POSTFIX_SELECT);
		} else {
			map.put("findBy", "True");
			return this.getSqlMapClient().queryForList(
					entityClass.getName() + POSTFIX_SELECTMAP, map);
		}
	}

	/**
	 * sql 查询.
	 * 
	 * @param sql
	 *            直接sql的语句(需要防止注入式攻击)
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> find(Class<T> entityClass, String sql)
			throws SQLException {
		if (StringUtils.isEmpty(sql)) {
			return this.getSqlMapClient().queryForList(
					entityClass.getName() + POSTFIX_SELECT);
		} else {
			return this.getSqlMapClient().queryForList(
					entityClass.getName() + POSTFIX_SELECTSQL, sql);
		}
	}

	/**
	 * 根据属性名和属性值查询对象.
	 * 
	 * @return 符合条件的对象列表
	 * @throws SQLException
	 */
	public <T> List<T> findBy(Class<T> entityClass, String name, Object value)
			throws SQLException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(name, value);
		return find(entityClass, map);
	}

	/**
	 * 根据属性名和属性值查询对象.
	 * 
	 * @return 符合条件的唯一对象
	 */
	@SuppressWarnings("unchecked")
	public <T> T findUniqueBy(Class<T> entityClass, String name, Object value) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			PropertyUtils.getProperty(entityClass.newInstance(), name);
			map.put(name, value);
			map.put("findUniqueBy", "True");
			return (T) getSqlMapClient().queryForObject(
					entityClass.getName() + POSTFIX_SELECTMAP, map);
		} catch (Exception e) {
			logger.error("Error when propertie on entity," + e.getMessage(), e
					.getCause());
			return null;
		}
	}

	/**
	 * 根据属性名和属性值以Like AnyWhere方式查询对象.
	 * 
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> findByLike(Class<T> entityClass, String name,
			String value) throws SQLException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(name, value);
		map.put("findLikeBy", "True");
		return getSqlMapClient().queryForList(entityClass.getName() + POSTFIX_SELECTMAP, map);
	}

	/**
	 * 查询 sqlId 满足 where 条件的记录
	 * @param <T>
	 * @param entityClass
	 * @param sqlId
	 * 			IBATIS 映射 SQLID
	 * @param where
	 * 			SQL WHERE 查询条件
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> findByWhere(Class<T> entityClass, String sqlId,
			String where) throws SQLException {
		return getSqlMapClient().queryForList(entityClass.getName() + "." + sqlId, where);
	}

	/**
	 * 判断对象某些属性的值在数据库中不存在重复
	 * 
	 * @param tableName
	 *            数据表名字
	 * @param names
	 *            在POJO里不能重复的属性列表,以逗号分割 如"name,loginid,password" <br>
	 *            FIXME how about in different schema?
	 */
	public boolean isNotUnique(Object entity, String tableName, String names) {
		try {
			String primarykey;
			Connection con = getSqlMapClient().getCurrentConnection();
			ResultSet dbMetaData = con.getMetaData().getPrimaryKeys(
					con.getCatalog(), null, tableName);
			dbMetaData.next();
			if (dbMetaData.getRow() > 0) {
				primarykey = dbMetaData.getString(4);
				if (names.indexOf(primarykey) > -1)
					return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			return false;
		}
		return false;
	}

	/**
	 * 根据 where 条件查询、满足条件记录数量.
	 * 
	 * @param <T>
	 * @param entityClass
	 * @param sqlId
	 *          IBATIS 映射 SQLID
	 * @param where
	 * 			SQL WHERE 查询条件（需要防止注入式攻击）
	 * @return int 满足 WHERE 条件的记录数量
	 * @throws SQLException
	 */
	public <T> int getCountByWhere(Class<T> entityClass, String sqlId,
			String where) throws SQLException {
		if (StringUtils.isEmpty(where)) {
			return (Integer) this.getSqlMapClient().queryForObject(
					entityClass.getName() + "." + sqlId);
		} else {
			return (Integer) this.getSqlMapClient().queryForObject(
					entityClass.getName() + "." + sqlId, where);
		}
	}

	/**
	 * 查询 sqlId 满足 queryItem 条件的记录
	 * 
	 * @param <T>
	 * @param entityClass
	 *            返回实体类
	 * @param sqlId
	 *            IBATIS 映射 SQLID
	 * @param queryItem
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> getListByQueryItem(Class<T> entityClass, String sqlId,
			QueryItem queryItem) throws SQLException {
		return getSqlMapClient().queryForList(entityClass.getName() + "." + sqlId, queryItem);
	}
	
	public String getMappedSQL(String sqlName) {
		String sql = null;
		SqlMapClientImpl sqlmap = (SqlMapClientImpl) getSqlMapClient();
		MappedStatement stmt = sqlmap.getMappedStatement(sqlName);
		StaticSql staticSql = (StaticSql) stmt.getSql();
		sql = staticSql.getSql(null, null);
		return sql;
	}

	/**
	 * 获得 SQL 映射 MappedID
	 * @param <T>
	 * @param entityClass
	 * @param sqlId
	 * 			SQL MappedID
	 * @return
	 */
	public <T> String getMappedSQLID(Class<T> entityClass, String sqlId){
		return entityClass.getName() + "." + sqlId;
	}
	
}