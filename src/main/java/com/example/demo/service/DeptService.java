package com.example.demo.service;

import com.example.demo.entity.Dept;

public interface DeptService {
    Dept addDept(Dept dept);
    Integer deleteById(Integer id);
    Dept updateDeptById(Dept dept);
    Dept findAllDept(Integer id);
}
