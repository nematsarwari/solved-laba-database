package com.solvd.laba.persistence;

import com.solvd.laba.domain.Employees;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

public interface EmployeesDAO{
    Employees getById(int id) throws SQLException;
    List<Employees> getAll()throws SQLException;
    int insert(Employees employee)throws SQLException;
    int update(@Param("employee")Employees employee)throws SQLException;
    int delete(Employees employee)throws SQLException;
}
