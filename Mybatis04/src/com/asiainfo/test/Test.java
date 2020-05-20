package com.asiainfo.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.asiainfo.mapper.AccountMapper;
import com.asiainfo.pojo.Account;

public class Test {
	public static void main(String[] args) throws IOException {
		
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		AccountMapper accountMapper = session.getMapper(AccountMapper.class);
		List<Account> selAll = accountMapper.selAll();
		for (Account account : selAll) {
			System.out.println(account);
		}
		session.close();
		System.out.println("程序执行结束");
	}
}
