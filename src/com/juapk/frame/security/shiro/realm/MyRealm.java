package com.juapk.frame.security.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;

import com.juapk.domain.User;
import com.juapk.frame.exception.BaseException;
import com.juapk.frame.helper.ApplicationContextHelper;
import com.juapk.service.UserService;
import com.juapk.service.impl.UserServiceImpl;

/**
 * 项目名称：juapk
 * 类名称：MyRealm
 * 类描述 Realm是专用于安全框架的DAO
 * Shiro的认证过程最终会交由Realm执行，这时会调用Realm的getAuthenticationInfo(token)方法。 
 * 该方法主要执行以下操作: 
 * 1、检查提交的进行认证的令牌信息 
 * 2、根据令牌信息从数据源(通常为数据库)中获取用户信息 
 * 3、对用户信息进行匹配验证。 
 * 4、验证通过将返回一个封装了用户信息的AuthenticationInfo实例。 
 * 5、验证失败则抛出AuthenticationException异常信息。 
 * MyRealm：继承AuthorizingRealm ，并重写认证授权方法 。
 * 创建人：hubin
 * 创建时间：2012-02-02
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
public class MyRealm extends AuthorizingRealm{
	
	/**
	 * 认证回调函数,登录时调用.
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		if (token.getUsername() != null) {
			User user = getUserByName(token.getUsername());
			return new SimpleAuthenticationInfo(user.getUser_name(), user.getPassword(), getName());
		} else {
			return null;
		}
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String loginName = (String) principals.fromRealm(getName()).iterator().next();
		User user = getUserByName(loginName);
		if (user != null) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//			info.addRoles(user.getRoleNameList());
//			for (Role role : user.getRoleList()) {
//				info.addStringPermissions(role.getPermissionNameList());
//			}
			return info;
		} else {
			return null;
		}
	}

	/**
	 * 更新用户授权信息缓存.
	 */
	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(principal, getName());
		clearCachedAuthorizationInfo(principals);
	}

	/**
	 * 清除所有用户授权信息缓存.
	 */
	public void clearAllCachedAuthorizationInfo() {
		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
		if (cache != null) {
			for (Object key : cache.keys()) {
				cache.remove(key);
			}
		}
	}
	
	/**
	 * 根据用户名获取用户信息
	 * @param userName
	 * @return
	 */
	private User getUserByName(String userName){
		User user = null;
		try {
			UserService userService = (UserService) ApplicationContextHelper.getBean(UserServiceImpl.class);
			user = userService.getUserByUserName(userName);
		} catch (BaseException e) {
			e.printStackTrace();
		}
		return user;
	}

}
