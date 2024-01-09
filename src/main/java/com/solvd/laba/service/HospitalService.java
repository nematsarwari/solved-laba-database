package com.solvd.laba.service;

import com.solvd.laba.domain.Hospital;
import com.solvd.laba.persistence.HospitalDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class HospitalService {
    private HospitalDAO hospitalDAO;

    public HospitalService(HospitalDAO hospitalDAO) {
        this.hospitalDAO = hospitalDAO;
    }

    public Hospital getHospitalById(int id) throws SQLException {
            return hospitalDAO.getById(id);
    }

    public List<Hospital> getAllHospitals() throws SQLException {
            return hospitalDAO.getAll();
    }

    public int addHospital(Hospital hospital) throws SQLException {
            return hospitalDAO.insert(hospital);
    }

    public int updateHospital(Hospital hospital) throws SQLException {
            return hospitalDAO.update(hospital);
    }

    public int deleteHospital(Hospital hospital) throws SQLException {
            return hospitalDAO.delete(hospital);
    }
}
