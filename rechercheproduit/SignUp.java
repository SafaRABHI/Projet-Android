package com.example.packardbell.rechercheproduit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
     public  void onSignUpClick (View v)
     {
         if (v.getId() == R.id.Bsignupbutton){

             EditText name = (EditText)findViewById(R.id.TFname);
             EditText email = (EditText)findViewById(R.id.TFemail);
             EditText uname = (EditText)findViewById(R.id.TFuname);
             EditText pass1 = (EditText)findViewById(R.id.TFpass1);
             EditText pass2 = (EditText)findViewById(R.id.TFpass2);

             String namestr = name.getText().toString();
             String emailstr = email.getText().toString();
             String unamestr = uname.getText().toString();
             String pass1str = pass1.getText().toString();
             String pass2str = pass2.getText().toString();

             if (! pass1str.equals(pass2str))
             {
                 Toast pass = Toast.makeText(SignUp.this,"Passwords don't match ! ",Toast.LENGTH_SHORT);
                 pass.show();
             }
             else
             {
                 Contact C = new Contact();
                 C.setName(namestr);
                 C.setEmail(emailstr);
                 C.setUname(unamestr);
                 C.setPass(pass1str);
                 helper.insertContact(C);
             }


         }

     }

}
