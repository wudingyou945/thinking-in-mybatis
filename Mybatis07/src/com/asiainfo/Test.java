package com.asiainfo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.asiainfo.pojo.People;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = sessionFactory.openSession();
		// 查询的代码
		List<People> selectList = session.selectList("a.b.selectAll");
		for (People people : selectList) {
			System.out.println(people);
		}
		// 新增的代码
//		People people = new People();
//		people.setName("马六");
//		people.setAge(29);
//		session.insert("a.b.insert", people);

		// 修改的代码
//		People people = new People();
//		people.setId(4);
//		people.setName("小名");
//		people.setAge(28);
//		session.update("a.b.updateById", people);
		
		// 删除的代码
//		session.delete("a.b.deleteById", 4);
		
//		Map map = session.selectOne("a.b.selectMap", 3);
//		System.out.println(map);
		session.commit();
		session.close();
	}

}
