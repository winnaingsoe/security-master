package com.pneumo.securitymaster.controller;

import com.pneumo.securitymaster.dao.EmployeeDao;
import com.pneumo.securitymaster.ds.Employee;
import com.pneumo.securitymaster.security.annotation.employees.EmployeePagView;
import com.pneumo.securitymaster.security.annotation.employees.EmployeesCreate;
import com.pneumo.securitymaster.security.annotation.employees.EmployeesDelete;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @EmployeePagView
    @GetMapping("/employees")
    public ModelAndView findAllEmployee() {
        return new ModelAndView("employees", "employees", employeeDao.findAll());
    }

    @EmployeesCreate
    @GetMapping("/employee-form")
    public String employeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee-form";
    }

    @EmployeesCreate
    @PostMapping("/employee-form")
    public String saveEmployee(@Valid Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return "employee-form";
        }
        employeeDao.save(employee);
        return "redirect:/employee/employees";
    }

    @EmployeesDelete
    @GetMapping("/employees/delete")
    public String deleteEmployee(@RequestParam("id") int id) {
        if (employeeDao.existsById(id)) {
            employeeDao.deleteById(id);
            return "redirect:/employee/employees";
        } else {
            throw new EntityNotFoundException(id + "Not Found!");
        }
    }

}
