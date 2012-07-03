package com.juapk.frame.ibatis;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.orm.ObjectRetrievalFailureException;

import com.juapk.frame.common.QueryItem;
import com.juapk.frame.exception.BaseException;
import com.juapk.frame.util.GenericsUtils;

/**
 * 项目名称：juapk
 * 类名称：IBatisEntityDao
 * 类描述：
 * <p>负责为单个Entity 提供CRUD操作的IBatis DAO基类.<p/>
 *  子类只要在类定义时指定所管理Entity的Class, 即拥有对单个Entity对象的CRUD操作.
 * <pre>
 * public class UserManagerIbatis extends IBatisEntityDao&lt;User&gt; { }
 * </pre>
 * 创建人：hubin
 * 创建时间：2012.01.17
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class IBatisEntityDao<T> extends IBatisGenericDao {

	/**
	 * DAO所管理的Entity类型.
	 */
	protected Class<T> entityClass;

	protected String primaryKeyName;

	/**
	 * 在构造函数中将泛型T.class赋给entityClass.
	 */
	@SuppressWarnings("unchecked")
	public IBatisEntityDao() {
		entityClass = (Class<T>) GenericsUtils.getSuperClassGenricType(getClass());
	}

	/**
	 * 根据属性的名值对查询对象
	 * 
	 * @param map
	 * @return List<T>
	 * @throws SQLException
	 */
	public List<T> find(Map<String, Object> map) throws SQLException {
		return find(getEntityClass(), map);
	}
	
	/**
	 * sql 查询.
	 * 
	 * @param sql
	 *            直接sql的语句(需要防止注入式攻击)
	 * @throws SQLException
	 */
	public List<T> find(String sql) throws SQLException {
		return find(getEntityClass(), sql);
	}

	/**
	 * 根据属性名和属性值查询对象.
	 * 
	 * @param name
	 *            ,value
	 * @return List<T> 符合条件的对象列表
	 * @throws SQLException
	 */
	public List<T> findBy(String name, Object value) throws SQLException {
		return findBy(getEntityClass(), name, value);
	}
	
	/**
	 * 根据属性名和属性值以Like AnyWhere方式查询对象.
	 * 
	 * @param name
	 *            ,value
	 * @throws SQLException
	 */
	public List<T> findByLike(String name, String value) throws SQLException {
		return findByLike(getEntityClass(), name, value);
	}

	/**
	 * 查询 sqlId 满足 where 条件的记录
	 * @param sqlId
	 *            IBATIS 映射 SQLID
	 * @param where
	 *            SQL WHERE 查询条件
	 * @return
	 * @throws SQLException
	 */
	public List<T> findByWhere(String sqlId, String where) throws SQLException {
		return findByWhere(getEntityClass(), sqlId, where);
	}

	/**
	 * 根据属性名和属性值查询单个对象.
	 * 
	 * @param name
	 *            ,value
	 * @return 符合条件的唯一对象
	 */
	public T findUniqueBy(String name, Object value) {
		return findUniqueBy(getEntityClass(), name, value);
	}

	/**
	 * 根据属性的名值对查询唯一对象
	 * 
	 * @param name
	 *            ,value
	 * @return T
	 * @throws SQLException
	 */
	public T findUniqueByMap(Map<String, Object> map) throws SQLException {
		List<T> list = find(getEntityClass(), map);
		if (list == null || list.size() <= 0) {
			return null;
		}
		return list.get(0);
	}
	
	/**
	 * 查询 sqlId 满足 where 条件的唯一记录
	 * @param sqlId
	 *            IBATIS 映射 SQLID
	 * @param where
	 *            SQL WHERE 查询条件
	 * @return
	 * @throws SQLException
	 */
	public T findUniqueByWhere(String sqlId, String where) throws SQLException {
		List<T> list = findByWhere(getEntityClass(), sqlId, where);
		if (list == null || list.size() <= 0) {
			return null;
		}
		return list.get(0);
	}

	/**
	 * 根据ID获取对象.
	 * 
	 * @param id
	 * @throws BaseException
	 * @throws SQLException
	 */
	public T get(Serializable id) throws BaseException, SQLException {
		return get(getEntityClass(), id);
	}

	/**
	 * 获取全部对象.
	 * 
	 * @return List<T>
	 * @throws SQLException
	 */
	public List<T> getAll() throws SQLException {
		return getAll(getEntityClass());
	}

	/**
	 * 取得entityClass.
	 * <p/>
	 * JDK1.4不支持泛型的子类可以抛开Class<T> entityClass,重载此函数达到相同效果。
	 */
	protected Class<T> getEntityClass() {
		return entityClass;
	}

	public String getPrimaryKeyName() {
		if (StringUtils.isEmpty(primaryKeyName)){
			primaryKeyName = "id";
		}
		return primaryKeyName;
	}

	protected Object getPrimaryKeyValue(Object o) throws NoSuchMethodException,
			IllegalAccessException, InvocationTargetException,
			InstantiationException {
		return PropertyUtils.getProperty(entityClass.newInstance(),
				getPrimaryKeyName());
	}

	/**
	 * 根据 where 条件查询、满足条件记录数量.
	 * 
	 * @param sqlId
	 *            IBATIS 映射 SQLID
	 * @param where
	 *            SQL WHERE 查询条件
	 * @return int 满足 WHERE 条件的记录数量
	 * @throws SQLException
	 */
	public int getCountByWhere(String sqlId, String where) throws SQLException {
		return getCountByWhere(getEntityClass(), sqlId, where);
	}

	/**
	 * 查询 sqlId 满足 queryItem 条件的记录
	 * 
	 * @param sqlId
	 *            IBATIS 映射 SQLID
	 * @param queryItem
	 * @return
	 * @throws SQLException
	 */
	public List<T> getListByQueryItem(String sqlId, QueryItem queryItem)
			throws SQLException {
		return getListByQueryItem(getEntityClass(), sqlId, queryItem);
	}

	/**
	 * 根据ID移除对象.
	 * 
	 * @param id
	 * @throws SQLException
	 */
	public int removeById(Serializable id) throws SQLException {
		return removeById(getEntityClass(), id);
	}

	/**
	 * 保存对象. 为了实现IEntityDao 内部使用了insert和upate 2个方法.
	 * 
	 * @param o
	 * @throws SQLException
	 */
	public void saveOrUpdate(Object o) throws SQLException {
		Object primaryKey;
		try {
			primaryKey = getPrimaryKeyValue(o);
		} catch (Exception e) {
			throw new ObjectRetrievalFailureException(entityClass, e);
		}
		if (primaryKey == null) {
			insert(o);
		} else {
			update(o);
		}
	}

	public void setPrimaryKeyName(String primaryKeyName) {
		this.primaryKeyName = primaryKeyName;
	}
	
	public String getIdName(Class<?> clazz) {
		return "id";
	}
	
	/**
	 * 获得 SQL 映射 MappedID
	 * @param sqlId
	 * 			SQL MappedID
	 * @return
	 */
	public String getMappedSQLID(String sqlId){
		return getMappedSQLID(getEntityClass(),sqlId);
	}

}