package com.solvd.laba.persistence.impl;

import com.solvd.laba.domain.Salary;
import com.solvd.laba.persistence.ConnectionPool;
import com.solvd.laba.persistence.SalaryDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalaryDAOImpl implements SalaryDAO {
    @Override
    public Salary getById(int id) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        Salary salary = null;
        String sql = "select employee_id, salary from salary where employee_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            int oid = rs.getInt("employee_id");
            int salaryAmount = rs.getInt("salary");


            salary = new Salary(oid, salaryAmount);
        }
        ConnectionPool.closeConnections();
        return salary;
    }

    @Override
    public List<Salary> getAll() throws SQLException {
        Connection con = ConnectionPool.getConnection();

        List<Salary> salaries = new ArrayList<>();
        try (PreparedStatement statement = con.prepareStatement("SELECT * FROM Salary");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Salary salary = new Salary();
                salary.setEmploye_id(resultSet.getInt("employee_id"));
                salary.setSalary(resultSet.getDouble("salary"));
                salaries.add(salary);
            }
        } catch (SQLException e) {
            throw e;
        }
        ConnectionPool.closeConnections();
        return salaries;
    }

    @Override
    public int insert(Salary salary) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        String sql = "insert into salary(employee_id, salary) values (?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, salary.getEmploye_id());;
        ps.setDouble(2, salary.getSalary());

        int result = ps.executeUpdate();

        ps.close();
        ConnectionPool.closeConnections();
        return result;
    }

    @Override
    public int update(Salary salary) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        String sql = "update salary set employee_id=?, salary=? where employee_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, salary.getEmploye_id());
        ps.setDouble(2, salary.getSalary());
        ps.setInt(3, salary.getEmploye_id());

        int result = ps.executeUpdate();

        ps.close();
        ConnectionPool.closeConnections();

        return result;
    }

    @Override
    public int delete(Salary salary) throws SQLException {

        Connection con = ConnectionPool.getConnection();
        String sql = "delete from Salary where employee_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, salary.getEmploye_id());
        int result = ps.executeUpdate();

        ps.close();
        ConnectionPool.closeConnections();

        return result;
    }
}
