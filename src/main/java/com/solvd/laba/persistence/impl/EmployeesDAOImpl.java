package com.solvd.laba.persistence.impl;

import com.solvd.laba.domain.Employees;
import com.solvd.laba.persistence.ConnectionPool;
import com.solvd.laba.persistence.EmployeesDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDAOImpl implements EmployeesDAO {
    @Override
    public Employees getById(int id) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        Employees employee = null;
        String sql = "select employees_id, first_name, last_name, department_id, hospital_id from employees where employees_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            int oid = rs.getInt("employees_id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            int departmentId = rs.getInt("department_id");
            int hospitalId = rs.getInt("hospital_id");

            employee = new Employees(oid, firstName, lastName, departmentId, hospitalId);
        }
        return employee;
    }

    @Override
    public List<Employees> getAll() throws SQLException {
        Connection con = ConnectionPool.getConnection();

        List<Employees> employees = new ArrayList<>();
        try (PreparedStatement statement = con.prepareStatement("SELECT * FROM Employees");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Employees employee = new Employees();
                employee.setEmployees_id(resultSet.getInt("employees_id"));
                employee.setFirst_name(resultSet.getString("first_name"));
                employee.setLast_name(resultSet.getString("last_name"));
                employee.setDepartment_id(resultSet.getInt("department_id"));
                employee.setHospital_id(resultSet.getInt("hospital_id"));

                employees.add(employee);
            }
        } catch (SQLException e) {
            throw e;
        }
        ConnectionPool.closeConnections();
        return employees;
    }

    @Override
    public int insert(Employees employees) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        String sql = "INSERT INTO employees (employees_id, first_name, last_name, department_id, hospital_id) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, employees.getEmployees_id());
        ps.setString(2, employees.getFirst_name());
        ps.setString(3, employees.getLast_name());
        ps.setInt(4, employees.getDepartment_id());
        ps.setInt(5, employees.getHospital_id());

        int result = ps.executeUpdate();

        ps.close();
        ConnectionPool.closeConnections();

        return result;
    }

    @Override
    public int update(Employees employees) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        String sql = "update employees set employees_id=?, first_name=?, last_name=?, department_id=?, hospital_id=? where employees_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, employees.getEmployees_id());
        ps.setString(2, employees.getFirst_name());
        ps.setString(3, employees.getLast_name());
        ps.setInt(4, employees.getDepartment_id());
        ps.setInt(5, employees.getHospital_id());
        ps.setInt(6, employees.getEmployees_id());

        int result = ps.executeUpdate();

        ps.close();
        ConnectionPool.closeConnections();

        return result;
    }

    @Override
    public int delete(Employees employee) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        String sql = "delete from employees where employees_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, employee.getEmployees_id());
        int result = ps.executeUpdate();

        ps.close();
        ConnectionPool.closeConnections();

        return result;
    }
}
