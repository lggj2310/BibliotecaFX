/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bibliotecafx;

/**
 *
 * @author informatica
 */
public class Usuario {
    private String user;
    private String password;

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public Usuario(String user, String password) {
        this.user = user;
        this.password = password;
    }

}
