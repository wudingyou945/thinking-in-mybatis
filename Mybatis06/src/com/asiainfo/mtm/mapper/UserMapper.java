package com.asiainfo.mtm.mapper;

import com.asiainfo.mtm.pojo.User;

public interface UserMapper
{
    User selectUserById(int id);
}