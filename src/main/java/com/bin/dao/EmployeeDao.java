package com.bin.dao;

import com.bin.pojo.Department;
import com.bin.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employeeMap = null;
    @Autowired
    private DepartmentDao departmentDao;
    static {
        employeeMap = new HashMap<Integer, Employee>();
        employeeMap.put(1001,new Employee(1001,"AA","1111@qq.com",1,new Department(101,"教学部")));
        employeeMap.put(1002,new Employee(1002,"BB","1111@qq.com",1,new Department(101,"教学部")));
        employeeMap.put(1003,new Employee(1003,"CC","1111@qq.com",1,new Department(103,"教研部")));
        employeeMap.put(1004,new Employee(1004,"DD","1111@qq.com",1,new Department(101,"教学部")));
        employeeMap.put(1005,new Employee(1005,"EE","1111@qq.com",1,new Department(102,"市场部")));
        employeeMap.put(1006,new Employee(1006,"FF","1111@qq.com",1,new Department(105,"后勤部")));

    }

    //zengjia
    private static Integer initId = 1006;
    public void save(Employee employee){
        if(employee.getId()==null) {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employeeMap.put(employee.getId(),employee);
    }
    //查询全部
    public Collection<Employee> getAll(){
        return employeeMap.values();
    }
    //通过id查
    public Employee getEmployeeById(Integer id){
        return employeeMap.get(id);
    }
    //删除员工
    public void deleteEmployeeById(Integer id){
        employeeMap.remove(id);
    }

}
