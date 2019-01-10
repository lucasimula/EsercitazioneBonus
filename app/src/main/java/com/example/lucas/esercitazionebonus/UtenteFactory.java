package com.example.lucas.esercitazionebonus;

import java.util.ArrayList;

public class UtenteFactory {
    private static UtenteFactory instance;
    private ArrayList<Utente> listaUtenti=new ArrayList<>();

    private UtenteFactory() {
        Utente utente1=new Utente();
        utente1.setUsername("super");
        utente1.setPassword("mario");

        Utente utente2=new Utente();
        utente2.setUsername("halo");
        utente2.setPassword("reach");

        Utente utente3=new Utente();
        utente3.setUsername("billy");
        utente3.setPassword("ballo");

        listaUtenti.add(utente1);
        listaUtenti.add(utente2);
        listaUtenti.add(utente3);
    }

    public static UtenteFactory getInstance() {
        if (instance==null)
            instance=new UtenteFactory();

        return instance;
    }

    public ArrayList<Utente> getListaUtenti() {
        return listaUtenti;
    }
}