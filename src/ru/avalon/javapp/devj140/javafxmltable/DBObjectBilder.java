/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.avalon.javapp.devj140.javafxmltable;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.avalon.javapp.devj140.javafxmltable.models.Domains;
import ru.avalon.javapp.devj140.javafxmltable.models.Person;

/**
 *
 * @author VOsipenkov
 */
public class DBObjectBilder {
    private Properties loginData = new Properties();
    private String url;
    private String userName;
    private String password;

    public DBObjectBilder(String url, String userName, String password) {
        this.url = url;
        this.userName = userName;
        this.password = password;
    }

    public DBObjectBilder() {        
        File propertyFile = new File("loginData.prop");
        try {
            loginData.load(new FileReader(propertyFile));        
        } catch (IOException ex) {
            Logger.getLogger(DBObjectBilder.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.url = loginData.getProperty("db.url");      
        this.userName = loginData.getProperty("db.user");
        this.password = loginData.getProperty("db.password");
    }
    
    
    public List<Person> getPerson(){
        List<Person> persons = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(url, userName, password);
                Statement stm = conn.createStatement()){
            try(ResultSet rs = stm.executeQuery("select p.*, (select count(*) from DOMAINS where PERSONID = p.ID) as DOMAINSCOUNT from PERSON p")){
                while (rs.next()) {                    
                    int id = rs.getInt(1);
                    String jobTitle = rs.getString(2);
                    String firstNameLastName = rs.getString(3);    
                    String phone = rs.getString(4);
                    String email = rs.getString(5);
                    int domainsCount = rs.getInt(6);
                    persons.add(new Person(id, jobTitle, firstNameLastName, phone, email, domainsCount));
                }
            }
        } catch (SQLException e) {
        }
        return persons;
    }
    
    public List<Domains> getDomainsByPersonId(int personId){
        List<Domains> domains = new ArrayList<>();        
        try(Connection conn = DriverManager.getConnection(url, userName, password);
                Statement stm = conn.createStatement()){
            try(ResultSet rs = stm.executeQuery("select * from DOMAINS where PERSONID =" + personId)){
                while(rs.next()) {
                    int id = rs.getInt(1);
                    String webName = rs.getString(2);
                    String domainName = rs.getString(3);
                    String ip = rs.getString(4);
                    Timestamp dateReg = rs.getTimestamp(5);
                    String countryReg = rs.getString(6);
                    domains.add(new Domains(id, webName, domainName, ip, dateReg, countryReg, personId));
                }
            }
        }catch (SQLException e){
        }
        return domains;
    }
    
    public boolean dbLoginCheck(String loginName, String loginPassword){
        try(Connection conn = DriverManager.getConnection(url, userName, password);
                Statement stm = conn.createStatement()){            
            try(ResultSet rs = stm.executeQuery("select * from USERS where NAME = '" + loginName + "' and PASSWORD = '" + loginPassword + "'")){  
                if (rs.next()) {                    
                    return true;
                }
            }                        
        } catch (SQLException ex) {  
            System.out.println(ex.getMessage());
        }            
        return false;
    }
}
