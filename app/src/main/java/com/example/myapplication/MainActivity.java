package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;

public class MainActivity extends Activity {
    TextView txtUser;
    ProfilePictureView imagenUsuario;
    Button btnCerrarSecio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUser =findViewById(R.id.tvUsuario);
        btnCerrarSecio=findViewById(R.id.btnCerrarSecion);

        if  (AccessToken.getCurrentAccessToken()==null) {
            irPantallaLogin();
            Log.i("Enviar a login","success");
        }else {

        }


        btnCerrarSecio.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logOut();
                irPantallaLogin();
            }
        });


    }

    private void irPantallaLogin() {
        Intent intent=new Intent(MainActivity.this, LoginActivity.class);
        finish();
        startActivity(intent);
    }
}
