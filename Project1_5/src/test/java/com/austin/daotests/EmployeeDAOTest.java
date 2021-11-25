package com.austin.daotests;


import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.austin.projectOne.dao.EmployeeDAO;
import com.austin.projectOne.model.Employee;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeDAOTest
{

    private static EmployeeDAO edao = EmployeeDAO.getEdao();
    @Test
    @Order(1)
    void createEmployee()
    {
        Employee e = new Employee(0,
                "jdbcForTheWin@email.com",
                "password",
                "hibernate");

        Employee result = edao.save(e);

        Assertions.assertNotEquals(0, result.getEid());
    }

    @Test
    @Order(2)
    void getEmployeeById()
    {
        List<Employee> slaughter = edao.findAll();
        Employee updateMe = slaughter.get(slaughter.size()-1);
        Employee result = edao.findById(updateMe.getEid());

        Assertions.assertEquals("password", result.getPassword());
    }

    @Test
    @Order(3)
    void getAllEmployees()
    {
        List<Employee> result = edao.findAll();

        Assertions.assertNotEquals(0, result.size());
    }

    @Test
    @Order(4)
    void updateEmployee()
    {
        List<Employee> slaughter = edao.findAll();
        Employee updateMe = slaughter.get(slaughter.size()-1);
        updateMe.setEmail("MyNewEmail@email.com");
        Employee result = edao.save(updateMe);

        Assertions.assertEquals("MyNewEmail@email.com",result.getEmail());
    }

    @Test
    @Order(5)
    void deleteEmployee()
    {
        List<Employee> slaughter = edao.findAll();
        Employee employee = slaughter.get(0);
//        Employee employee = edao.save(e);
        boolean result = edao.delete(employee.getEid());

        Assertions.assertEquals(true, result);

    }
}