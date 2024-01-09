package com.solvd.laba.persistence.impl;

import com.solvd.laba.domain.Department;
import com.solvd.laba.persistence.ConnectionPool;
import com.solvd.laba.persistence.DepartmentDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {
    @Override
    public Department getById(int id) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        Department department = null;
        String sql = "select department_id, department_name from department where department_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            int oid = rs.getInt("department_id");
            String departmentName = rs.getString("department_name");


            department = new Department(oid, departmentName);
        }
        return department;
    }

    @Override
    public List<Department> getAll() throws SQLException {
        Connection con = ConnectionPool.getConnection();

        List<Department> departments = new ArrayList<>();
        try (PreparedStatement statement = con.prepareStatement("SELECT * FROM Department");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Department department = new Department();
                department.setDepatment_id(resultSet.getInt("id"));
                department.setDepartment_name(resultSet.getString("hospital_name"));
                departments.add(department);
            }
        } catch (SQLException e) {
            throw e;
        }
        ConnectionPool.closeConnections();
        return departments;
    }

    @Override
    public int insert(Department department) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        String sql = "insert into department(department_id, department_name) values (?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, department.getDepatment_id());;
        ps.setString(2, department.getDepartment_name());

        int result = ps.executeUpdate();

        ps.close();
        ConnectionPool.closeConnections();
        return result;
    }

    @Override
    public int update(Department department) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        String sql = "update Department set department_id=?, department_name=? where department_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, department.getDepatment_id());
        ps.setString(2, department.getDepartment_name());
        ps.setInt(3, department.getDepatment_id());

        int result = ps.executeUpdate();

        ps.close();
        ConnectionPool.closeConnections();

        return result;
    }

    @Override
    public int delete(Department department) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        String sql = "delete from Department where department_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, department.getDepatment_id());
        int result = ps.executeUpdate();

        ps.close();
        ConnectionPool.closeConnections();

        return result;
    }
}
