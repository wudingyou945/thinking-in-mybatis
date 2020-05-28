package com.asiainfo.mapper;

import org.apache.ibatis.annotations.Select;

import com.asiainfo.pojo.Student;

public interface StudentMapper {
	/*@Select("select id,name,sex,age from student where id=#{id}")*/
	public Student selectStudentById(Integer id);
}
