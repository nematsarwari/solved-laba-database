package com.solvd.laba.service;

import com.solvd.laba.domain.Patients;
import com.solvd.laba.persistence.PatientsDAO;

import java.sql.SQLException;
import java.util.List;

public class PatientService {
    private PatientsDAO patientsDAO;

    public PatientService(PatientsDAO patientsDAO) {
        this.patientsDAO = patientsDAO;
    }

    public Patients getPatientById(int id) throws SQLException {
            return patientsDAO.getById(id);
    }

    public List<Patients> getAllPatients() throws SQLException {
            return patientsDAO.getAll();
    }

    public int addPatient(Patients patient) throws SQLException {
            return patientsDAO.insert(patient);
    }

    public int updatePatient(Patients patient) throws SQLException {
            return patientsDAO.update(patient);
    }

    public int deletePatient(Patients patient) throws SQLException {
            return patientsDAO.delete(patient);
    }

}
