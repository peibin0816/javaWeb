package com.bin.controller;

import com.bin.dao.DepartmentDao;
import com.bin.dao.EmployeeDao;
import com.bin.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EnployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;
    @RequestMapping("/emps/all")
    public String getEmployees(Model model){
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps",all);
        return "list";
    }

    @GetMapping("/addedge")
    public String addrediecty(Model model) {
        model.addAttribute("departments", departmentDao.getDepartment());
        return "add";
    }

    @GetMapping("/updatedge/{id}")
    public String updaterediecty(@PathVariable Integer id,Model model) {
        Employee employeeById = employeeDao.getEmployeeById(id);
        model.addAttribute("employeeById", employeeById);
        model.addAttribute("departments", departmentDao.getDepartment());
        return "update";
    }

    @PostMapping("/emps/add")
    public String addemps(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps/all";
    }

    @PostMapping("/emps/update")
    public String updateemps(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps/all";
    }

    @GetMapping("/emps/delete/{id}")
    public String deleteEmps(@PathVariable Integer id) {
        employeeDao.deleteEmployeeById(id);
        return "redirect:/emps/all";
    }
}
