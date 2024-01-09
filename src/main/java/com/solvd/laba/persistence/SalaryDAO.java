package com.solvd.laba.persistence;

import com.solvd.laba.domain.Salary;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

public interface SalaryDAO{
    Salary getById(int id) throws SQLException;
    List<Salary> getAll()throws SQLException;
    int insert(Salary salary)throws SQLException;
    int update(@Param("salary")Salary salary)throws SQLException;
    int delete(Salary salary)throws SQLException;
}
