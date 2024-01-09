package com.solvd.laba.domain;

public class Department {
    private int depatment_id;
    private String department_name;
    public Department() {
    }
    public Department(int depatment_id, String department_name) {
        this.depatment_id = depatment_id;
        this.department_name = department_name;
    }

    public int getDepatment_id() {
        return depatment_id;
    }

    public void setDepatment_id(int depatment_id) {
        this.depatment_id = depatment_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "depatment_id=" + depatment_id +
                ", department_name='" + department_name + '\'' +
                '}';
    }
}
