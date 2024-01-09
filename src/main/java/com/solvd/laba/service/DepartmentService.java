package com.solvd.laba.service;

import com.solvd.laba.domain.Department;
import com.solvd.laba.persistence.DepartmentDAO;

import java.sql.SQLException;
import java.util.List;

public class DepartmentService {
    private DepartmentDAO departmentDAO;

    public DepartmentService(DepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    public Department getDepartmentById(int id) throws SQLException {
            return departmentDAO.getById(id);
    }

    public List<Department> getAllDepartments() throws SQLException {
            return departmentDAO.getAll();
    }

    public int addDepartment(Department department) throws SQLException {
            return departmentDAO.insert(department);
    }

    public int updateDepartment(Department department) throws SQLException {
            return departmentDAO.update(department);
    }

    public int deleteDepartment(Department department) throws SQLException {
            return departmentDAO.delete(department);

    }
}
