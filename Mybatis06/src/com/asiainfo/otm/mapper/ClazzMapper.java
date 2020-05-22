package com.asiainfo.otm.mapper;

import com.asiainfo.otm.pojo.Clazz;

public interface ClazzMapper {
	// 根据id查询班级信息
	Clazz selectClazzById(Integer id);
}
