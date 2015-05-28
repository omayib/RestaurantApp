package id.co.technomotion.restaurantapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

    Button btnLogin;
    EditText editTextEmail,editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail= (EditText) findViewById(R.id.editText_email);
        editTextPassword= (EditText) findViewById(R.id.editText_pasword);
        btnLogin= (Button) findViewById(R.id.button_login);

        // code berikut ini dijalankan ketika button di click
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }


}
