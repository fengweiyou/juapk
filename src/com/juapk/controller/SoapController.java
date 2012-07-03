package com.juapk.controller;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.springframework.stereotype.Controller;

/**
 * 项目名称：juapk
 * 类名称：SoapController
 * 类描述：WebService JSON Controller
 * 创建人：Administrator
 * 创建时间：2012-5-2 下午10:31:53 
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version v1.0
 */
@Controller
@SOAPBinding(style = SOAPBinding.Style.RPC)
@WebService (name="HelloService", targetNamespace="http://album.jsonplugin.com/json/")
public class SoapController extends BaseController{

    @WebMethod (operationName = "sayHello")
    public @WebResult(name="message") String sayHello(
                    @WebParam(name="name") String name){
            return "Hello "+name;
    }
    
}