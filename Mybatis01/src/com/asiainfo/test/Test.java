package com.asiainfo.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.asiainfo.pojo.Flower;

public class Test {
	public static void main(String[] args) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		// 第一种查询方式，返回一个列表
		List<Flower> list = session.selectList("a.b.selAll");
		for (Flower flower : list) {
			System.out.println(flower.toString());
		}
		// 第二种查询返回一条数据
		int num = session.selectOne("a.b.selById", 3);
		System.out.println(num);
		
		// 第三种查询返回一个以返回数据中某列为键的map集
		Map<String, Flower> selectMap = session.selectMap("a.b.selMap", "name");
		System.out.println(selectMap);
//		Flower flower = new Flower();
//		flower.setName("菊花");
//		flower.setPrice(4.6);
//		session.insert("a.b.insert", flower);
		session.close();
	}
}
