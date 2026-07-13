package com.Files.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Employee {

    @Id
    private int Eid;

    private String Ename;

    private String Ecity;

    private int Eage;

    @Transient
    private  String Eaddress;
    
    public String getEaddress() {
        return Eaddress;
    }

    public void setEaddress(String eaddress) {
        Eaddress = eaddress;
    }


    public Employee(){
        System.out.println("Zero param constructor for hibernate");
    }

    public int getEid() {
        return Eid;
    }

    public void setEid(int eid) {
        Eid = eid;
    }

    public String getEname() {
        return Ename;
    }

    public void setEname(String ename) {
        Ename = ename;
    }

    public String getEcity() {
        return Ecity;
    }

    public void setEcity(String ecity) {
        Ecity = ecity;
    }

    public int getEage() {
        return Eage;
    }

    public void setEage(int eage) {
        Eage = eage;
    }
}
