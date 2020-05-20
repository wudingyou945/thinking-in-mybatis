package com.asiainfo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.asiainfo.pojo.Log;

public interface LogMapper {
	
	List<Log> selByAccinAccout(@Param("accout") String accout, @Param("accin") String accin, @Param("money") double money);
	
	int upd(Log log);
	
	List<Log> selByLog(Log log);
	
	List<Log> selIn(List<Integer> list);
	
	
	int ins(List<Integer> list);
}
