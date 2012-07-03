package com.juapk.frame.util;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试 XMLUtils 工具类
 * @author HUBIN
 * @version 1.0
 * @since 2012.01.31
 */
public class XMLUtilsTest {
	private static Words words;
	private static WordsType type;
	private static WordsType type1, type2;
	
	public static void main(String[] args) {
		try {
			setUp();
			testAdd();
//			testDelete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void setUp() throws Exception {
		type = new WordsType();
		type.setName("person name");
		type1 = new WordsType();
		type1.setName("Greek letters");
		type2 = new WordsType();
		type2.setName("test");
		
		List<WordsType> types = new ArrayList<WordsType> ();
		types.add(type);
		types.add(type1);
		types.add(type2);
		
		words = new Words();
		words.setName("upslion");
		words.setType(types);
		words.setContent("alalalala");
	}

	public static void tearDown() throws Exception {
	}

	public static void testAdd() throws Exception{
		XMLUtils util = new XMLUtils();
		util.create("XML",null);
		util.add(words);
		util.save("xml/TestXMLUtils.xml");
		util.close();
	}

	public static void testDelete() throws Exception{
		XMLUtils util = new XMLUtils();
		util.open("xml/TestXMLUtils.xml");
		util.delete("//WordsType[@name='Greek letters']");
		util.save();
		util.close();
	}

	public static void testFindNodes() throws Exception{
		XMLUtils util = new XMLUtils();
		util.open("xml/TestXMLUtils.xml");
		util.close();
	}

	public static void testFindNodesValue() throws Exception{
		XMLUtils util = new XMLUtils();
		util.open("xml/TestXMLUtils.xml");
		util.close();
	}

	public static void testUpdateString() throws Exception{
		XMLUtils util = new XMLUtils();
		util.open("xml/TestXMLUtils.xml");
		util.update("//WordsType[@name='test']/@name", "tested");
		util.save();
		util.close();
	}
	
	public static void testGetObjects() throws Exception{
		XMLUtils util = new XMLUtils();
		util.open("xml/TestXMLUtils.xml");
		List<Object> os = util.getObjects(new Words());
		util.close();
	}

}
// 单词
class Words{
	private String name;
	private List<WordsType> type;
	private String content;
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<WordsType> getType() {
		return type;
	}
	public void setType(List<WordsType> type) {
		this.type = type;
	}
}
// 单词类型
class WordsType{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}