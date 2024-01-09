package com.solvd.laba.persistence.myBatisMapperImpl;

import com.solvd.laba.domain.Patients;
import com.solvd.laba.persistence.PatientsDAO;
import com.solvd.laba.persistence.persistenceConfig;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.List;

public class PatientMapperImpl implements PatientsDAO {
    @Override
    public Patients getById(int id) throws SQLException {
        try (SqlSession sqlSession = persistenceConfig.getSessionFactory().openSession(true);){
            PatientsDAO patientsDAO = sqlSession.getMapper(PatientsDAO.class);
            Patients patient = patientsDAO.getById(id);
            return patient;
        }
    }

    @Override
    public int insert(Patients patient) throws SQLException {
        try (SqlSession sqlSession = persistenceConfig.getSessionFactory().openSession(true);){
            PatientsDAO patientsDAO = sqlSession.getMapper(PatientsDAO.class);
            int result = patientsDAO.insert(patient);
            return result;
        }
    }

    @Override
    public int update(Patients patient) throws SQLException {
        try (SqlSession sqlSession = persistenceConfig.getSessionFactory().openSession(true);){
            PatientsDAO patientsDAO = sqlSession.getMapper(PatientsDAO.class);
            int result = patientsDAO.update(patient);
            return result;
        }
    }

    @Override
    public int delete(Patients patient) throws SQLException {
        try (SqlSession sqlSession = persistenceConfig.getSessionFactory().openSession(true);){
            PatientsDAO patientsDAO = sqlSession.getMapper(PatientsDAO.class);
            int result = patientsDAO.delete(patient);
            return result;
        }
    }

    @Override
    public List<Patients> getAll() throws SQLException {
        return null;
    }
}
