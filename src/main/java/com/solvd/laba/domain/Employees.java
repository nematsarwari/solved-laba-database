package com.solvd.laba.domain;

public class Employees {
    private int employees_id;
    private String first_name;
    private String last_name;
    private int department_id;
    private int hospital_id;


    public Employees() {
    }
    public Employees(int employees_id, String first_name, String last_name, int department_id, int hospital_id) {
        this.employees_id = employees_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.department_id = department_id;
        this.hospital_id = hospital_id;
    }

    public int getEmployees_id() {
        return employees_id;
    }

    public void setEmployees_id(int employees_id) {
        this.employees_id = employees_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getHospital_id() {
        return hospital_id;
    }

    public void setHospital_id(int hospital_id) {
        this.hospital_id = hospital_id;
    }
    @Override
    public String toString() {
        return "Employees{" +
                "employees_id=" + employees_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", department_id=" + department_id +
                ", hospital_id=" + hospital_id +
                '}';
    }
}
