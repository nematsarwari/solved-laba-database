package com.solvd.laba.service;

import com.solvd.laba.domain.Employees;
import com.solvd.laba.persistence.EmployeesDAO;

import java.sql.SQLException;
import java.util.List;

public class EmployeesService {
    private EmployeesDAO employeesDAO;

    public EmployeesService(EmployeesDAO employeesDAO) {
        this.employeesDAO = employeesDAO;
    }

    public Employees getEmployeeById(int id) throws SQLException {
            return employeesDAO.getById(id);
    }

    public List<Employees> getAllEmployees() throws SQLException {
            return employeesDAO.getAll();
    }

    public int addEmployee(Employees employee) throws SQLException {
            return employeesDAO.insert(employee);
    }

    public int updateEmployee(Employees employee) throws SQLException {
            return employeesDAO.update(employee);
    }

    public int deleteEmployee(Employees employee) throws SQLException {
            return employeesDAO.delete(employee);
    }
}
