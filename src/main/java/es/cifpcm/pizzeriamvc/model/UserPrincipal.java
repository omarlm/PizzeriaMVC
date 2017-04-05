/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.cifpcm.pizzeriamvc.model;

/**
 *
 * @author omarl
 */
public class UserPrincipal {
    
    private Integer idCliente;
    private String login;
    private String password;
    private String nomGrupo;

    public UserPrincipal() {
    }

    public UserPrincipal(Integer idCliente, String login, String password, String nomGrupo) {
        this.idCliente = idCliente;
        this.login = login;
        this.password = password;
        this.nomGrupo = nomGrupo;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNomGrupo() {
        return nomGrupo;
    }

    public void setNomGrupo(String nomGrupo) {
        this.nomGrupo = nomGrupo;
    }
    
    
}
