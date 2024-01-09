package com.solvd.laba.persistence;

import com.solvd.laba.domain.Patients;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

public interface PatientsDAO {
    Patients getById(int id) throws SQLException;
    List<Patients> getAll()throws SQLException;
    int insert(Patients patient)throws SQLException;
    int update(@Param("patient")Patients patient)throws SQLException;
    int delete(Patients patient)throws SQLException;
}
