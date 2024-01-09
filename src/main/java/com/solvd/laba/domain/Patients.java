package com.solvd.laba.domain;

public class Patients {
    private int patient_id;
    private String first_name;
    private String last_name;
    private int hospitalID;
    public Patients() {
    }
    public Patients(int patient_id, String first_name, String last_name, int hospitalID) {
        this.patient_id = patient_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.hospitalID = hospitalID;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
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

    public int getHospitalID() {
        return hospitalID;
    }

    public void setHospitalID(int hospitalID) {
        this.hospitalID = hospitalID;
    }

    @Override
    public String toString() {
        return "Patients{" +
                "patient_id=" + patient_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", hospitalID=" + hospitalID +
                '}';
    }
}
