package com.biz4up.bizsalad.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.biz4up.bizsalad.admin.AdminVO2;

@Repository
@Mapper
public interface TestMapper {
	
	List<AdminVO2> selectTest();

}
