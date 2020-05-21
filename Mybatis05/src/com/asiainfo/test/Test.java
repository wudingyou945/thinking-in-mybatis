package com.asiainfo.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.asiainfo.mapper.LogMapper;
import com.asiainfo.pojo.Log;


public class Test {
	public static void main(String[] args) throws IOException {
		
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
//		SqlSession session = factory.openSession();
//		LogMapper mapper = session.getMapper(LogMapper.class);
//		List<Log> logs = mapper.selByAccinAccout("345", null, 26);
//		for (Log log : logs) {
//			System.out.println(log);
//		}
//		logs = mapper.selByAccinAccout("345", null, 26);
//		for (Log log : logs) {
//			System.out.println(log);
//		}
		SqlSession session1 = factory.openSession();
		SqlSession session2 = factory.openSession();
		LogMapper mapper1 = session1.getMapper(LogMapper.class);
		LogMapper mapper2 = session2.getMapper(LogMapper.class);
		// 第一次发起请求
		List<Log> logs = mapper1.selByAccinAccout("345", null, 26);
		for (Log log : logs) {
			System.out.println(log);
		}
		// 这里执行关闭操作，将sqlsession中的数据写入到二级缓存区域
		session1.close();
		logs = mapper2.selByAccinAccout("345", null, 26);
		for (Log log : logs) {
			System.out.println(log);
		}
		session2.close();
		
//		Log log = new Log();
//		log.setId(1);
//		log.setAccIn("245");
//		log.setAccOut("136");
//		mapper.upd(log);
		
/*		SqlSession session = factory.openSession(ExecutorType.BATCH);
		Scanner input = new Scanner(System.in);
		System.out.println("请输入转账帐号:");
		String accout = input.nextLine();
		System.out.println("请输入收款帐号");
		String accin = input.nextLine();*/
		
//		LogMapper mapper = session.getMapper(LogMapper.class);
//		List<Log> list = mapper.selByAccinAccout(accout, accin);
//		System.out.println(list);
//		Log log = new Log();
//		log.setId(1);
//		log.setAccOut(accout);
//		log.setAccIn(accin);
//		int index = mapper.upd(log);
//		System.out.println(index);
//		Log log = new Log();
//		mapper.selByLog(new Log());
//		mapper.upd(new Log());
		
//		List<Integer> list = new ArrayList<>();
//		for (int i = 0; i < 10000; i++) {
//			list.add(i);
//		}
		
//		mapper.ins(list);
		
//		mapper.selIn(list);
		
//		session.commit();
//		session.close();
		System.out.println("程序执行结束");
	}
}
