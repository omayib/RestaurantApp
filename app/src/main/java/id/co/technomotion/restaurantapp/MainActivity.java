package id.co.technomotion.restaurantapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


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

                processLogin();

            }
        });


    }

    private void processLogin() {
        String email=editTextEmail.getText().toString();
        String password=editTextPassword.getText().toString();

        if(email.isEmpty()){
            Toast.makeText(this,"email wajib diisi",Toast.LENGTH_SHORT).show();
            return;
        }

        if(password.isEmpty()){
            Toast.makeText(this,"password wajib diisi",Toast.LENGTH_SHORT).show();
            return;
        }

        if(email.equalsIgnoreCase("aku@email.com")
                && password.equalsIgnoreCase("1234")){
            Toast.makeText(this,"LOGIN BERHASIL",Toast.LENGTH_SHORT).show();

        }

        LoginAsync loginAsync=new LoginAsync(){
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);

                Toast.makeText(MainActivity.this,"LOGIN BERHASIL",Toast.LENGTH_SHORT).show();

            }
        };
        loginAsync.execute(email,password);

    }


}
