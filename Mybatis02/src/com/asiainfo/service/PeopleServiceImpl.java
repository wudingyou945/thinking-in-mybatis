package com.asiainfo.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.asiainfo.pojo.PageInfo;

public class PeopleServiceImpl implements PeopleService {

	@Override
	public PageInfo showPage(int pageSize, int pageNumber) throws IOException {
		// TODO Auto-generated method stub
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		PageInfo pageInfo = new PageInfo(pageNumber, pageSize);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageStart", pageInfo.getPageStart());
		map.put("pageSize", pageSize);
		List<PageInfo> list = session.selectList("com.asiainfo.mapper.PeopleMapper.selByPage", map);
		pageInfo.setList(list);
		// 记录总条数
		long total = session.selectOne("com.asiainfo.mapper.PeopleMapper.selCount");
		pageInfo.setTotal(total);
		return pageInfo;
	}

}
