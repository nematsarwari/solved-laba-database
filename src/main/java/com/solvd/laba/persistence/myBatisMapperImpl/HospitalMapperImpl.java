package com.solvd.laba.persistence.myBatisMapperImpl;

import com.solvd.laba.domain.Hospital;
import com.solvd.laba.persistence.HospitalDAO;
import com.solvd.laba.persistence.persistenceConfig;
import org.apache.ibatis.session.SqlSession;
import java.sql.SQLException;
import java.util.List;

public class HospitalMapperImpl implements HospitalDAO {
    @Override
    public Hospital getById(int id) throws SQLException {
        try (SqlSession sqlSession = persistenceConfig.getSessionFactory().openSession(true);){
            HospitalDAO hospitalDAO = sqlSession.getMapper(HospitalDAO.class);
            Hospital hospital = hospitalDAO.getById(id);
            return hospital;
        }
    }

    @Override
    public int insert(Hospital hospital) throws SQLException {
        try (SqlSession sqlSession = persistenceConfig.getSessionFactory().openSession(true);){
            HospitalDAO hospitalDAO = sqlSession.getMapper(HospitalDAO.class);
            int result = hospitalDAO.insert(hospital);
            return result;
        }
    }

    @Override
    public int update(Hospital hospital) throws SQLException {
        try (SqlSession sqlSession = persistenceConfig.getSessionFactory().openSession(true);){
            HospitalDAO hospitalDAO = sqlSession.getMapper(HospitalDAO.class);
            int result = hospitalDAO.update(hospital);
            return result;
        }
    }

    @Override
    public int delete(Hospital hospital) throws SQLException {
        try (SqlSession sqlSession = persistenceConfig.getSessionFactory().openSession(true);){
            HospitalDAO hospitalDAO = sqlSession.getMapper(HospitalDAO.class);
            int result = hospitalDAO.delete(hospital);
            return result;
        }
    }

    @Override
    public List<Hospital> getAll() throws SQLException {
        return null;
    }
}
