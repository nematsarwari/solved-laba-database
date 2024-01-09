package com.solvd.laba.service;

import com.solvd.laba.domain.Salary;
import com.solvd.laba.persistence.SalaryDAO;

import java.sql.SQLException;
import java.util.List;

public class SalaryService {
    private SalaryDAO salaryDAO;

    public SalaryService(SalaryDAO salaryDAO) {
        this.salaryDAO = salaryDAO;
    }

    public Salary getSalaryById(int id) throws SQLException {
            return salaryDAO.getById(id);
    }

    public List<Salary> getAllSalaries() throws SQLException {
            return salaryDAO.getAll();
    }

    public int addSalary(Salary salary) throws SQLException {
            return salaryDAO.insert(salary);
    }

    public int updateSalary(Salary salary) throws SQLException {
            return salaryDAO.update(salary);
    }

    public int deleteSalary(Salary salary) throws SQLException {
            return salaryDAO.delete(salary);
    }
}
