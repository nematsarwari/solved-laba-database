package com.solvd.laba.persistence;

import com.solvd.laba.domain.Department;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

public interface DepartmentDAO {
    Department getById(int id) throws SQLException;
    List<Department> getAll()throws SQLException;
    int insert(Department department)throws SQLException;
    int update(@Param("department")Department department)throws SQLException;
    int delete(Department department)throws SQLException;
}
