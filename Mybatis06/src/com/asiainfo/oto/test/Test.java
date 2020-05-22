package com.asiainfo.oto.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.asiainfo.oto.mapper.PersonMapper;
import com.asiainfo.oto.pojo.Person;

public class Test {
	public static void main(String[] args) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		PersonMapper mapper = session.getMapper(PersonMapper.class);
		Person person = mapper.selectPersonById(1);
		System.out.println(person.toString());
		session.commit();
		session.close();
	}
}
