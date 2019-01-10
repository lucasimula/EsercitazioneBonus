package com.example.lucas.esercitazionebonus;

import java.io.Serializable;
import java.util.ArrayList;

public class Utente implements Serializable {
    private String username;
    private String password;

    public Utente() {
        this.username="";
        this.password="";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkDati(ArrayList<Utente> listaUtenti) {
        for (Utente user : listaUtenti)
            if (this.getUsername().equals(user.getUsername()) && this.getPassword().equals(user.getPassword()))
                return true;

        return false;
    }
}