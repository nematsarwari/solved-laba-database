package com.solvd.laba.persistence.impl;

import com.solvd.laba.domain.Patients;
import com.solvd.laba.persistence.ConnectionPool;
import com.solvd.laba.persistence.PatientsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientDAOImpl implements PatientsDAO {
    @Override
    public Patients getById(int id) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        Patients patient = null;
        String sql = "select patient_id, first_name, last_name, hospitalID from Patients where patient_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            int oid = rs.getInt("patient_id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            int hospitalId = rs.getInt("hospitalID");

            patient = new Patients(oid, firstName, lastName, hospitalId);
        }
        return patient;
    }

    @Override
    public List<Patients> getAll() throws SQLException {
        Connection con = ConnectionPool.getConnection();

        List<Patients> patients = new ArrayList<>();
        try (PreparedStatement statement = con.prepareStatement("SELECT * FROM Patients");
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Patients patient = new Patients();
                patient.setPatient_id(resultSet.getInt("patient_id"));
                patient.setFirst_name(resultSet.getString("first_name"));
                patient.setLast_name(resultSet.getString("last_name"));
                patient.setHospitalID(resultSet.getInt("hospitalID"));

                patients.add(patient);
            }
        } catch (SQLException e) {
            throw e;
        }
        ConnectionPool.closeConnections();
        return patients;
    }

    @Override
    public int insert(Patients patient) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        String sql = "insert into patients(patient_id, first_name, last_name, hospitalID) values (?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, patient.getPatient_id());;
        ps.setString(2, patient.getFirst_name());
        ps.setString(3, patient.getLast_name());
        ps.setInt(4, patient.getHospitalID());

        int result = ps.executeUpdate();

        ps.close();
        ConnectionPool.closeConnections();
        return result;
    }

    @Override
    public int update(Patients patient) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        String sql = "update Patients set patient_id=?, first_name=?, last_name=?, hospitalID=? where patient_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, patient.getPatient_id());
        ps.setString(2, patient.getFirst_name());
        ps.setString(3, patient.getLast_name());
        ps.setInt(4, patient.getHospitalID());
        ps.setInt(5, patient.getPatient_id());

        int result = ps.executeUpdate();

        ps.close();
        ConnectionPool.closeConnections();

        return result;
    }

    @Override
    public int delete(Patients patient) throws SQLException {
        Connection con = ConnectionPool.getConnection();
        String sql = "delete from Patients where patient_id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, patient.getPatient_id());
        int result = ps.executeUpdate();

        ps.close();
        ConnectionPool.closeConnections();

        return result;
    }
}
