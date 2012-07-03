package com.juapk.frame.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/**
 * @ClassName: dom4jXmlParseMgr 
 * @Description: 
 *   		dom4j进行xml文件解析的基础类,需要提供的是与xmlpath相关的信息
 * @author HUBIN
 * @date 2012-4-29 下午9:43:41 
 * @since 1.0
 */
public class dom4jXmlParseMgr {

    /**
     * 全局的Document对象
     */
    public Document document;

//    public static void main(String[] args) {
//        //dom4jXmlParseMgr dpr=new dom4jXmlParseMgr("F:/e30work/b2b/bin/hc360/b2b/netWorker/Hhc360URLXML.xml");
//        //System.out.println(dpr.getElementValue("/commonURLXML/picture_URL/pictureType[1]"));
//        //System.out.println(dpr.getElementAttributeValue("/commonURLXML/page_URL/pageType[1]","firstpageUrl"));
//        //dpr.getMuliElementNode("/commonURLXML/page_URL/pageType");
//        //dpr.getMuliElementNodeValue("/commonURLXML/page_URL/pageType");
//        
//        dom4jXmlParseMgr dpr=new dom4jXmlParseMgr("d:/ExceptionXML.xml");
//        List nodeList=dpr.getMuliElementNode("/Exception/ModeName/ExceptionItem");
//        String tAttributeValue=dpr.getElementAttributeValue((Node)nodeList.get(0),"code");
//        System.out.println("run this is==="+tAttributeValue);
//        //dpr.getMuliElementNodeValue("/Exception/ModeName/ExceptionItem");
//        //dpr.getMuliElementAttribute("/Exception/ModeName/ExceptionItem","code");
//        //dpr.getMuliElementAttributeValue("/Exception/ModeName[1]/ExceptionItem[1]","code");
//    }

    /**
     * 构造函数,以提供xml文件路径的方式调用本类
     *
     */
    public dom4jXmlParseMgr(String xmlFile){
        try {
			init(new FileInputStream(new File(xmlFile)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }
    
    public dom4jXmlParseMgr(InputStream is) {
    	init(is);
    }
    
    /**
     * 构造函数 以提供Document文档的方式调用本类
     *
     */
    public dom4jXmlParseMgr(Document _document){
        document=_document;
    }
    
    /**
     *  
     * Methods Descrip:初始化函数
     * @param xmlFile:xml文件路径
     *
     */
    private void init(InputStream is) {
        try {
            SAXReader saxReader = new SAXReader();
            document = saxReader.read(is);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     *  
     * Methods Descrip:根据输入xmlpath路径得到该节点的值
     * <pre>例如 xml文件如下:
     *  <?xml version="1.0" encoding="UTF-8"?>
	 *   <commonURLXML>
	 *     <picture_URL>
	 *      <pictureType typeid="0" typedescr="商机图片" serverName="imgserver">busin</pictureType>
	 *      <pictureType typeid="1" typedescr="产品图片" serverName="imgserver">product</pictureType>
	 *     <picture_URL>
	 *   <commonURLXML>  
     * </pre>           
     * @param xmlpath:指定节点的xmlpath路径 如:/commonURLXML/picture_URL/pictureType[1]
     * @return String:节点值 如busin
     */
    public String getElementValue(String xmlpath){
    	//System.out.println("run this is===="+xmlpath);
        Node node = document.selectSingleNode(xmlpath);
        //String res = node.getText();
        //System.out.println("run this is res===="+res);
        return (node == null) ? null : node.getText();
    }
    
    /**
     *  
     * Methods Descrip:根据xmlPath路径得到该路径下的所有节点
     * <pre>
     * 例如 xml文件如下:
     * <?xml version="1.0" encoding="UTF-8"?>
     *  <commonURLXML>
     *   <picture_URL>
     *    <pictureType typeid="0" typedescr="商机图片" serverName="imgserver">busin</pictureType>
     *    <pictureType typeid="1" typedescr="产品图片" serverName="imgserver">product</pictureType>
     *  <picture_URL>
     * <commonURLXML>  
     * </pre>           
     * @param xmlpath:指定节点的xmlpath路径 如:/commonURLXML/picture_URL/pictureType
     * @return List:节点对象组 NodeList
     *
     */
    public List getMuliElementNode(String xmlpath){
        List NodeList=new ArrayList();
        NodeList=document.selectNodes(xmlpath);
       return NodeList; 
    }
    
    /**
     *  
     * Methods Descrip:根据xmlPath路径得到该路径下的所有节点的值
     * <pre>
     * 例如 xml文件如下:
     *  <?xml version="1.0" encoding="UTF-8"?>
     *   <commonURLXML>
     *    <picture_URL>
     *      <pictureType typeid="0" typedescr="商机图片" serverName="imgserver">busin</pictureType>
     *      <pictureType typeid="1" typedescr="产品图片" serverName="imgserver">product</pictureType>
     *    <picture_URL>
     *   <commonURLXML>
     * </pre>             
     * @param xmlpath:指定节点的xmlpath路径 如:/commonURLXML/picture_URL/pictureType
     * @return List:节点对象组 NodeList
     *
     */
    public List getMuliElementNodeValue(String xmlpath){
        List NodeValueList=new ArrayList();
        List NodeList=getMuliElementNode( xmlpath);
        for(int i=0;i<NodeList.size();i++){
            Node node=(Node)NodeList.get(i);
            String value=node.getText();
            NodeValueList.add(value);
        }
        return NodeValueList;
    }
    
    
   /**
    *  
    * Methods Descrip:根据输入xmlpath路径得到该节点指定属性名称的属性值
    * <pre>
    * 例如 xml文件如下:
     * <?xml version="1.0" encoding="UTF-8"?>
     *  <commonURLXML>
     *    <picture_URL>
     *     <pictureType typeid="0" typedescr="商机图片" serverName="imgserver">busin</pictureType>
     *     <pictureType typeid="1" typedescr="产品图片" serverName="imgserver">product</pictureType>
     *    <picture_URL>
     *  <commonURLXML>  
     *</pre>
    * @param xmlpath:指定节点的xmlpath路径 如:/commonURLXML/picture_URL/pictureType[1]
    * @param attribueName:指定的属性名称 如:typeid
    * @return String:属性值 如 0
    *
    */
    public String getElementAttributeValue(String xmlpath,String attribueName){
        Attribute attribute  =(Attribute) document.selectSingleNode(xmlpath+"/@"+attribueName);
        String res=null;
        if(attribute!=null)
        	res=attribute.getValue();

        return res;
    }
    
    /**
     *  
     * Methods Descrip:根据传入的节点对象,取得该对象的指定属性名称的属性值
     * @param node:带有属性的节点对象
     * @param attribueName:指定的司性名称
     * @return String:属性值
     *
     */
    public String getElementAttributeValue(Node node,String attribueName){
        Attribute attribute  =(Attribute)node.selectSingleNode("@"+attribueName);
        String res=null;
        if(attribute!=null)
        	res=attribute.getValue();
        return res;
    }
    
    /**
     *  
     * Methods Descrip:根据输入xmlpath路径得到该路径下所有节点指定属性名称的属性节点
    * 例如 xml文件如下:
     * <?xml version="1.0" encoding="UTF-8"?>
     *  <commonURLXML>
     *   <picture_URL>
     *    <pictureType typeid="0" typedescr="商机图片" serverName="imgserver">busin</pictureType>
     *    <pictureType typeid="1" typedescr="产品图片" serverName="imgserver">product</pictureType>
     *   <picture_URL>
     *  <commonURLXML>  
    * @param xmlpath:指定节点的xmlpath路径 如:/commonURLXML/picture_URL/pictureType
    * @param attribueName:指定的属性名称 如:typeid
    * @return List:属性节点 如 AttributeList
     *
     */
    public List getMuliElementAttribute(String xmlpath,String attribueName){
       List  AttributeList=document.selectNodes(xmlpath+"/@"+attribueName);
       return AttributeList;
    }
 
    /**
     *  
     * Methods Descrip:根据输入xmlpath路径得到该路径下所有节点指定属性名称的属性节点的值
    * <pre>例如 xml文件如下:
     *  <?xml version="1.0" encoding="UTF-8"?>
     *   <commonURLXML>
     *    <picture_URL>
     *     <pictureType typeid="0" typedescr="商机图片" serverName="imgserver">busin</pictureType>
     *     <pictureType typeid="1" typedescr="产品图片" serverName="imgserver">product</pictureType>
     *    <picture_URL>
     *   <commonURLXML> 
     * </pre> 
    * @param xmlpath:指定节点的xmlpath路径 如:/commonURLXML/picture_URL/pictureType
    * @param attribueName:指定的属性名称 如:typeid
    * @return List:属性节点 如 AttributeListValue
     *
     */
    public List getMuliElementAttributeValue(String xmlpath,String attribueName){
        List  AttributeList=getMuliElementAttribute(xmlpath,attribueName);
        List  AttributeListValue=new ArrayList();
        for(int i=0;i<AttributeList.size();i++){
            Attribute attribute  =(Attribute)AttributeList.get(i);
            String res=attribute.getValue();
            AttributeListValue.add(res);
        }
        return AttributeListValue;
     }
    
    public int getIntValue(String xmlPath) {
    	return Convert.getInt(this.getElementValue(xmlPath), 0);
    }
    
    public long getLongValue(String xmlPath) {
    	return Convert.getLong(this.getElementValue(xmlPath), 0);
    }
    
    public String getStringValue(String xmlPath) {
    	return this.getElementValue(xmlPath);
    }
    
}