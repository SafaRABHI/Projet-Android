package com.example.packardbell.rechercheproduit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    DatabaseHelper helper = new DatabaseHelper(this);
    ImageButton btlogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /* btlogin = (ImageButton) findViewById(R.id.btlogin); */

        /*btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), rechercheproduit.class);
                startActivityForResult(intent, 0);
                btlogin.setBackgroundColor(0xEF9CB2);
               btlogin.invalidate();

            }


        });*/
    }

        public void onButtonClick (View v)
        {
            if (v.getId() == R.id.btlogin)
            {
                EditText a = (EditText) findViewById(R.id.etName);
                String str = a.getText().toString();
                EditText b = (EditText) findViewById(R.id.etPassword);
                String pass = b.getText().toString();
                String password = helper.searchPass(str);
                if (pass.equals(password))
                {
                    Intent i = new Intent(LoginActivity.this,Display.class);
                    i.putExtra("UserName",str);
                    startActivity(i);

                }
                else
                {
                    Toast tmp = Toast.makeText(LoginActivity.this,"UserName & Password don't match ! ",Toast.LENGTH_SHORT);
                    tmp.show();

                }


            }
            if (v.getId() == R.id.btSignUp)
            {
                Intent i = new Intent(LoginActivity.this,SignUp.class);
                startActivity(i);

            }

        }

    }





