package com.example.demo.service.impl;

import com.example.demo.entity.Dept;
import com.example.demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service("impl1")
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @CachePut(cacheNames = "dept",key = "#result.id")
    @Override
    public Dept addDept(Dept dept) {
        deptMapper.addDept(dept);

        return dept;
    }

    @CacheEvict(cacheNames = "dept")
    @Override
    public Integer deleteById(Integer id) {
        Integer result=deptMapper.deleteById(id);
        return result;
    }
    @CachePut(cacheNames = "dept",key = "#result.id")
    @Override
    public Dept updateDeptById(Dept dept) {
        deptMapper.updateDeptById(dept);
        return dept;
    }

    @Cacheable(cacheNames = "dept",key = "#id")
    @Override
    public Dept findAllDept(Integer id) {
        return deptMapper.findAllDept(id);
    }

}
