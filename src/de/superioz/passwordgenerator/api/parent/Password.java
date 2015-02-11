package de.superioz.passwordgenerator.api.parent;

/**
 * Class created on 08.02.2015
 */
public class Password {

    private String password;

    public Password(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
