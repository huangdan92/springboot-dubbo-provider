package com.example.demo.mapper;

import com.example.demo.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptMapper {
    Integer addDept(Dept dept);
    Integer deleteById(Integer id);
    Integer updateDeptById(Dept dept);
    Dept findAllDept(Integer id);
}