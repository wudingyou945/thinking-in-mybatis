package com.asiainfo.service;

import java.io.IOException;

import com.asiainfo.pojo.PageInfo;

public interface PeopleService {
	/**
	 * 分页显示
	 * @param pageSize
	 * @param pageNumber
	 * @return
	 */
	PageInfo showPage(int pageSize,int pageNumber) throws IOException;
}
