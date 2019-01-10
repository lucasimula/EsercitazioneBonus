package com.example.lucas.esercitazionebonus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.Serializable;
import java.util.ArrayList;

public class ActivityBenvenuto extends AppCompatActivity {
    Utente user;
    TextView benvenuto;
    Button indietro;
    ArrayList<Utente> listaUtenti;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benvenuto);

        benvenuto=(TextView)findViewById(R.id.benvenuto);
        indietro=(Button)findViewById(R.id.indietro);

        Intent intent = getIntent();
        Serializable obj = intent.getSerializableExtra(
                MainActivity.UTENTE_EXTRA
        );

        if(obj instanceof Utente) {
            user=(Utente) obj;
        }
        else {
            user = new Utente();
        }

        UtenteFactory utenteFactory=UtenteFactory.getInstance();
        listaUtenti=utenteFactory.getListaUtenti();
        if (user.checkDati(listaUtenti)) {
            benvenuto.setText("Benvenuto, " + user.getUsername());
        }

        else {
            benvenuto.setText("Accesso negato");
        }

        indietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}