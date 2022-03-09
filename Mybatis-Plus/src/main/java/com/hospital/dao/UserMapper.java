package com.hospital.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hospital.entity.hospital_user;
import org.springframework.stereotype.Repository;
//BaseMapper 中有一些方法，能完成基本的CRUD

@Repository
public interface UserMapper extends BaseMapper<hospital_user> {

}
