package com.solvd.laba.persistence.myBatisMapperImpl;

import com.solvd.laba.domain.Employees;
import com.solvd.laba.persistence.EmployeesDAO;
import com.solvd.laba.persistence.persistenceConfig;
import org.apache.ibatis.session.SqlSession;
import java.sql.SQLException;
import java.util.List;

public class EmployeesMapperImpl implements EmployeesDAO {
    @Override
    public Employees getById(int id) throws SQLException {
        try (SqlSession sqlSession = persistenceConfig.getSessionFactory().openSession(true);){
            EmployeesDAO employeesDAO = sqlSession.getMapper(EmployeesDAO.class);
            Employees employee = employeesDAO.getById(id);
            return employee;
        }
    }

    @Override
    public int insert(Employees employee) throws SQLException {
        try (SqlSession sqlSession = persistenceConfig.getSessionFactory().openSession(true);){
            EmployeesDAO employeesDAO = sqlSession.getMapper(EmployeesDAO.class);
            int result = employeesDAO.insert(employee);
            return result;
        }
    }

    @Override
    public int update(Employees employee) throws SQLException {
        try (SqlSession sqlSession = persistenceConfig.getSessionFactory().openSession(true);){
            EmployeesDAO employeesDAO = sqlSession.getMapper(EmployeesDAO.class);
            int result = employeesDAO.update(employee);
            return result;
        }
    }

    @Override
    public int delete(Employees employee) throws SQLException {
        try (SqlSession sqlSession = persistenceConfig.getSessionFactory().openSession(true);){
            EmployeesDAO employeesDAO = sqlSession.getMapper(EmployeesDAO.class);
            int result = employeesDAO.delete(employee);
            return result;
        }
    }

    @Override
    public List<Employees> getAll() throws SQLException {
        return null;
    }
}
