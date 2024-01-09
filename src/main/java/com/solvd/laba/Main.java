package com.solvd.laba;

import com.solvd.laba.domain.Hospital;
import com.solvd.laba.domain.Salary;
import com.solvd.laba.persistence.HospitalDAO;
import com.solvd.laba.persistence.SalaryDAO;
import com.solvd.laba.persistence.impl.SalaryDAOImpl;
import com.solvd.laba.persistence.myBatisMapperImpl.HospitalMapperImpl;
import com.solvd.laba.persistence.myBatisMapperImpl.SalaryMapperImpl;
import com.solvd.laba.service.SalaryService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
//
//        EmployeesDAO employeeDAO = new EmployeesDAOImpl();
//        Employees employee = employeeDAO.getById(1);
//        System.out.println(employee);
//
//        HospitalDAO hospitalDAO = new HospitalDAOImpl();
//        Hospital hospital = hospitalDAO.getById(1);
//        System.out.println(hospital);
//
//        DepartmentDAO departmentDAO = new DepartmentDAOImpl();
//        Department department = departmentDAO.getById(1);
//        System.out.println(department);
//
//        PatientsDAO patientsDAO = new PatientDAOImpl();
//        Patients patient = patientsDAO.getById(1);
//        System.out.println(patient);
//
//        SalaryDAO salaryDAO = new SalaryDAOImpl();
//        Salary salary = salaryDAO.getById(1);
//        System.out.println(salary);

        // insert

//        EmployeesDAO employeeDAO = new EmployeesDAOImpl();
//        Employees employee6 = new Employees(6, "something", "something", 2, 1);
//        int result = employeeDAO.insert(employee6);
//        System.out.println(result);

//        PatientsDAO patientsDAO = new PatientDAOImpl();
//        Patients patient2 = new Patients(2, "someone", "someone", 1);
//        System.out.println(patientsDAO.insert(patient2));

//        HospitalDAO hospitalDAO = new HospitalDAOImpl();
//        Hospital hospital2 = new Hospital(2, "something");
//        System.out.println(hospitalDAO.insert(hospital2));

//        DepartmentDAO departmentDAO = new DepartmentDAOImpl();
//        Department department = new Department(3, "cleaner");
//        System.out.println(departmentDAO.insert(department));

//        SalaryDAO salaryDAO = new SalaryDAOImpl();
//        Salary salary1 = new Salary(6, 40000.0);
//        System.out.println(salaryDAO.insert(salary1));

        // update
//        EmployeesDAO employeeDAO = new EmployeesDAOImpl();
//        Employees employee2 = new Employees(4, "emma", "Williams", 2,	1);
//         employeeDAO.update(employee2);
//


        // delete
//        EmployeesDAO employeeDAO = new EmployeesDAOImpl();
//        Employees employee6 = employeeDAO.getById(6);
//        System.out.println(employee6);
//
//        System.out.println(employeeDAO.delete(employee6));

//        PatientsDAO patientsDAO = new PatientDAOImpl();
//        Patients patient = patientsDAO.getById(4);
//        System.out.println(patient);
//
//        System.out.println(patientsDAO.delete(patient));

//        SalaryDAO salaryDAO = new SalaryDAOImpl();
//        List<Salary> salaries = salaryDAO.getAll();
//        System.out.println(salaries);

//        HospitalDAO hospitalDAO = new HospitalDAOImpl();
//        List<Hospital> hospitals = hospitalDAO.getAll();
//        System.out.println(hospitals);

//        SalaryDAO salaryDAO = new SalaryDAOImpl();
//        SalaryService salaryService = new SalaryService(salaryDAO);
//
//        // Test getById
//        Salary salaryById = salaryService.getSalaryById(1);
//        System.out.println("Salary by ID: " + salaryById);

//        try (InputStream is = Resources.getResourceAsStream("mybatis-config.xml")){
//            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
//                    .build(is);
//            SqlSession sqlSession = sessionFactory.openSession(true);
//            HospitalDAO hospitalDAO = sqlSession.getMapper(HospitalDAO.class);
//
//            Hospital hospital = hospitalDAO.getById(2);
//            System.out.println(hospital);
//
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        HospitalMapperImpl hospitalMapper = new HospitalMapperImpl();
        System.out.println(hospitalMapper.getById(1));

        SalaryMapperImpl salaryMapper = new SalaryMapperImpl();
        System.out.println(salaryMapper.getById(4));


    }
}




