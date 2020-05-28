package com.asiainfo;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.asiainfo.mapper.StudentMapper;
import com.asiainfo.pojo.Student;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = sessionFactory.openSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		Student student = studentMapper.selectStudentById(1);
//		Student student = session.selectOne("com.asiainfo.mapper.StudentMapper.selectStudentById", 1);
		System.out.println(student);
		session.commit();
		session.close();
	}

}
