package com.solvd.laba.persistence;

import com.solvd.laba.domain.Hospital;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;

public interface HospitalDAO {
    Hospital getById(int id) throws SQLException;
    List<Hospital> getAll()throws SQLException;
    int insert(Hospital hospital)throws SQLException;
    int update(@Param("hospital") Hospital hospital)throws SQLException;
    int delete(Hospital hospital)throws SQLException;
}
