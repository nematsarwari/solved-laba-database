package com.solvd.laba.persistence.impl;

import com.solvd.laba.domain.Hospital;
import com.solvd.laba.persistence.ConnectionPool;
import com.solvd.laba.persistence.HospitalDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class HospitalDAOImpl implements HospitalDAO {
    @Override
    public Hospital getById(int id) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        Hospital hospital = null;
        String sql = "select id, hospital_name from hospital where id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            int oid = rs.getInt("id");
            String hospitalName = rs.getString("hospital_name");


            hospital = new Hospital(oid, hospitalName);
        }
        return hospital;
    }

    @Override
    public List<Hospital> getAll() throws SQLException {
        Connection con = ConnectionPool.getConnection();

        List<Hospital> hospitals = new ArrayList<>();
        try (PreparedStatement statement = con.prepareStatement("SELECT * FROM Hospital");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Hospital hospital = new Hospital();
                hospital.setId(resultSet.getInt("id"));
                hospital.setHospital_name(resultSet.getString("hospital_name"));
                hospitals.add(hospital);
            }
        } catch (SQLException e) {
            throw e;
        }
        ConnectionPool.closeConnections();
        return hospitals;
    }

    @Override
    public int insert(Hospital hospital) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        String sql = "insert into hospital(id, hospital_name) values (?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, hospital.getId());;
        ps.setString(2, hospital.getHospital_name());

        int result = ps.executeUpdate();

        ps.close();
        ConnectionPool.closeConnections();
        return result;
    }

    @Override
    public int update(Hospital hospital) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        String sql = "update hospital set id=?, hospital_name=? where id = ?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, hospital.getId());
        ps.setString(2, hospital.getHospital_name());
        ps.setInt(3, hospital.getId());

        int result = ps.executeUpdate();

        ps.close();
        ConnectionPool.closeConnections();

        return result;
    }

    @Override
    public int delete(Hospital hospital) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        String sql = "delete from Hospital where id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, hospital.getId());
        int result = ps.executeUpdate();

        ps.close();
        ConnectionPool.closeConnections();

        return result;
    }
}
