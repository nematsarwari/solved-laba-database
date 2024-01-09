package com.solvd.laba.domain;



public class Hospital {
    private int id;
    private String hospital_name;

    public Hospital() {
    }
    public Hospital(int id, String hospital_name) {
        this.id = id;
        this.hospital_name = hospital_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHospital_name() {
        return hospital_name;
    }

    public void setHospital_name(String hospital_name) {
        this.hospital_name = hospital_name;
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "id=" + id +
                ", hospital_name='" + hospital_name + '\'' +
                '}';
    }
}
