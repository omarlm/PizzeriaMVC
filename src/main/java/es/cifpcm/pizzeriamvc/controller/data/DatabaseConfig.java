/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.pizzeriamvc.controller.data;

/**
 *
 * @author omarl
 */
public class DatabaseConfig {
    private static final int DEFAULT_DB_PAGESIZE = 20;
    
    private String driverClassName;
    private String databaseUrl;
    private String databaseUser;
    private String databasePassword;
    private Integer databasePageSize;

    public DatabaseConfig() {
    }

    public DatabaseConfig(String driverClassName, String databaseUrl, String databaseUser, String databasePassword, Integer databasePageSize) {
        this.driverClassName = driverClassName;
        this.databaseUrl = databaseUrl;
        this.databaseUser = databaseUser;
        this.databasePassword = databasePassword;
        this.databasePageSize = databasePageSize;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public void setDatabaseUrl(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    public String getDatabaseUser() {
        return databaseUser;
    }

    public void setDatabaseUser(String databaseUser) {
        this.databaseUser = databaseUser;
    }

    public String getDatabasePassword() {
        return databasePassword;
    }

    public void setDatabasePassword(String databasePassword) {
        this.databasePassword = databasePassword;
    }

    public Integer getDatabasePageSize() {
        return databasePageSize;
    }

    public void setDatabasePageSize(Integer databasePageSize) {
        this.databasePageSize = databasePageSize;
    }
}
