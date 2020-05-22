package com.asiainfo.otm.mapper;

import com.asiainfo.otm.pojo.Student;

public interface StudentMapper {
	// 根据id查询学生信息
	Student selectStudentById(Integer id);
}
