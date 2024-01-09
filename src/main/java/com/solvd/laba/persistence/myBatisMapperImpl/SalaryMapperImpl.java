package com.solvd.laba.persistence.myBatisMapperImpl;

import com.solvd.laba.domain.Salary;
import com.solvd.laba.persistence.SalaryDAO;
import com.solvd.laba.persistence.persistenceConfig;
import org.apache.ibatis.session.SqlSession;
import java.sql.SQLException;
import java.util.List;

public class SalaryMapperImpl implements SalaryDAO {
    @Override
    public Salary getById(int id) throws SQLException {
        try (SqlSession sqlSession = persistenceConfig.getSessionFactory().openSession(true);){
            SalaryDAO salaryDAO = sqlSession.getMapper(SalaryDAO.class);
            Salary salary = salaryDAO.getById(id);
            return salary;
        }
    }

    @Override
    public int insert(Salary salary) throws SQLException {
        try (SqlSession sqlSession = persistenceConfig.getSessionFactory().openSession(true);){
            SalaryDAO salaryDAO = sqlSession.getMapper(SalaryDAO.class);
            int result = salaryDAO.insert(salary);
            return result;
        }
    }

    @Override
    public int update(Salary salary) throws SQLException {
        try (SqlSession sqlSession = persistenceConfig.getSessionFactory().openSession(true);){
            SalaryDAO salaryDAO = sqlSession.getMapper(SalaryDAO.class);
            int result = salaryDAO.update(salary);
            return result;
        }
    }

    @Override
    public int delete(Salary salary) throws SQLException {
        try (SqlSession sqlSession = persistenceConfig.getSessionFactory().openSession(true);){
            SalaryDAO salaryDAO = sqlSession.getMapper(SalaryDAO.class);
            int result = salaryDAO.delete(salary);
            return result;
        }
    }

    @Override
    public List<Salary> getAll() throws SQLException {
        return null;
    }
}
