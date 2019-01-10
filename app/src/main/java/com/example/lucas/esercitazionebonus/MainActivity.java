package com.example.lucas.esercitazionebonus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Utente user=new Utente();
    EditText username, password;
    TextView errore, registrati;
    Button loginButton;

    public static final String UTENTE_EXTRA = "com.example.lucas.esercitazionebonus.Utente";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        loginButton=(Button)findViewById(R.id.loginButton);
        errore=(TextView) findViewById(R.id.errore);
        registrati=(TextView) findViewById(R.id.registrati);

        errore.setVisibility(View.GONE);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkInput()) {
                    updateUser();

                    Intent activityBenvenuto = new Intent(MainActivity.this,
                            ActivityBenvenuto.class);
                    activityBenvenuto.putExtra(UTENTE_EXTRA, user);

                    startActivity(activityBenvenuto);
                }
            }
        });

        registrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void updateUser() {
        user.setUsername(""+username.getText());
        user.setPassword(""+password.getText());
    }

    private boolean checkInput() {
        int errors = 0;

        if(username.getText()==null || username.getText().length()==0) {
            username.setError("Inserire username");
            errors++;
        }
        else
            username.setError(null);

        if(password.getText()==null || password.getText().length()==0) {
            password.setError("Inserire password");
            errors++;
        }
        else
            password.setError(null);

        switch (errors){
            case 0:
                errore.setVisibility(View.GONE);
                errore.setText("");
                break;
            case 1:
                errore.setVisibility(View.VISIBLE);
                errore.setText("Si è verificato un errore");
                break;
            default:
                errore.setVisibility(View.VISIBLE);
                errore.setText("Si sono verificati " + errors + " errori");
                break;
        }

        return errors==0;
    }
}