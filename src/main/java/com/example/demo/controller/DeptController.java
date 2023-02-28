package com.example.demo.controller;



import com.example.demo.entity.Dept;
import com.example.demo.entity.RespBean;
import com.example.demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    @Qualifier("impl1") //取得bean，指定bean名称为impl1
    private DeptService deptService;

    @GetMapping("/{id}")
    public Object findAll(@PathVariable Integer id){
        Dept allDept = deptService.findAllDept(id);
        return allDept;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public RespBean deleteDept(@PathVariable Integer id){
        try {
            deptService.deleteById(id);
            return RespBean.DELETE_SUCCESS;//删除成功
        } catch (Exception e) {
            e.printStackTrace();
            return RespBean.DELETE_ERROR;//删除失败
        }
    }

    /**
     * 添加
     * @param dept
     * @return
     */
    @PostMapping("/")
    public RespBean addDept(@RequestBody Dept dept){
        try {
            deptService.addDept(dept);
            return RespBean.ADD_SUCCESS;//添加成功
        } catch (Exception e) {
            e.printStackTrace();
            return RespBean.ADD_ERROR;//添加失败
        }
    }

    /**
     * 更新
     * @param dept
     * @return
     */
    @PutMapping("/")
    public RespBean updateDept(@RequestBody Dept dept){
        try {
            deptService.updateDeptById(dept);
            return RespBean.UPDATE_SUCCESS;//添加成功
        } catch (Exception e) {
            e.printStackTrace();
            return RespBean.UPDATE_ERROR;//添加失败
        }

    }


}
