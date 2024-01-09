package com.solvd.laba.domain;

public class Salary {
    private int employe_id;
    private double salary;

    public Salary() {
    }
    public Salary(int employe_id, double salary) {
        this.employe_id = employe_id;
        this.salary = salary;
    }

    public int getEmploye_id() {
        return employe_id;
    }

    public void setEmploye_id(int employe_id) {
        this.employe_id = employe_id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "employe_id=" + employe_id +
                ", salary=" + salary +
                '}';
    }
}
