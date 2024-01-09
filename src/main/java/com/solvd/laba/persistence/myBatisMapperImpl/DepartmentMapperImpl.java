package com.solvd.laba.persistence.myBatisMapperImpl;

import com.solvd.laba.domain.Department;
import com.solvd.laba.persistence.DepartmentDAO;
import com.solvd.laba.persistence.persistenceConfig;
import org.apache.ibatis.session.SqlSession;
import java.sql.SQLException;
import java.util.List;

public class DepartmentMapperImpl implements DepartmentDAO {
    @Override
    public Department getById(int id) throws SQLException {
        try (SqlSession sqlSession = persistenceConfig.getSessionFactory().openSession(true);){
            DepartmentDAO departmentDAO = sqlSession.getMapper(DepartmentDAO.class);
            Department department = departmentDAO.getById(id);
            return department;
        }
    }


    @Override
    public int insert(Department department) throws SQLException {
        try (SqlSession sqlSession = persistenceConfig.getSessionFactory().openSession(true);){
            DepartmentDAO departmentDAO = sqlSession.getMapper(DepartmentDAO.class);
            int result = departmentDAO.insert(department);
            return result;
        }
    }

    @Override
    public int update(Department department) throws SQLException {
        try (SqlSession sqlSession = persistenceConfig.getSessionFactory().openSession(true);){
            DepartmentDAO departmentDAO = sqlSession.getMapper(DepartmentDAO.class);
            int result = departmentDAO.update(department);
            return result;
        }
    }

    @Override
    public int delete(Department department) throws SQLException {
        try (SqlSession sqlSession = persistenceConfig.getSessionFactory().openSession(true);){
            DepartmentDAO departmentDAO = sqlSession.getMapper(DepartmentDAO.class);
            int result = departmentDAO.delete(department);
            return result;
        }
    }

    @Override
    public List<Department> getAll() throws SQLException {
        return null;
    }
}
