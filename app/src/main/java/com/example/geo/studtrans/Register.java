package com.example.geo.studtrans;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.text.ParseException;
import java.util.List;

/**
 * Created by Geo on 12/4/2014.
 */




public class Register extends Activity {

    protected EditText regUsername;
    protected EditText regEmail;
    protected EditText regPassword;
    protected  Button registerB;

    public static String userNameAtLogin;

    private ParseObject user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);


        regEmail=(EditText)findViewById(R.id.txtFemail);
        regUsername=(EditText)findViewById(R.id.txtFusername);
        regPassword=(EditText)findViewById(R.id.txtFpassword);

        registerB=(Button)findViewById(R.id.buttonSignUp);
        registerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 final String username=regUsername.getText().toString();
                 final String email=regEmail.getText().toString();
                 final String password=regPassword.getText().toString();


                ParseQuery<ParseObject> query= ParseQuery.getQuery("Users");
                query.whereEqualTo("username",username);

                query.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> users, com.parse.ParseException e) {
                        if (e == null){

                            if (users.isEmpty() && (extractDB(email,username)== true)){
                                ParseObject user = new ParseObject("Users");
                                        user.put("username",username);
                                        user.put("password",password);
                                        user.put("Email",email);
                                        user.saveInBackground();


                                userNameAtLogin=username;
                                Toast.makeText(Register.this,"Succed",Toast.LENGTH_LONG).show();
                                Intent regI= new Intent(Register.this, Login.class);
                                startActivity(regI);
                            }
                            else {
                                Toast.makeText(Register.this,"Error-Va rog sa introduceti datele cerute",Toast.LENGTH_LONG).show();
                            }
                        }
                        else {

                        }
                    }
                });


/*

                ParseUser user = new ParseUser();
                user.setUsername(username);
                user.setPassword(password);
                user.setEmail(email);

                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(com.parse.ParseException e) {
                        if (e==null)
                        {
                            Toast.makeText(Register.this,"Succes! Welcome",Toast.LENGTH_LONG).show();
                            Intent regI= new Intent(Register.this, Login.class);
                            startActivity(regI);
                        }
                        else
                        {
                            Toast.makeText(Register.this,"Error",Toast.LENGTH_LONG).show();
                        }
                        }

                });

*/

            }
        });



    }


    public boolean extractDB(String email, String username) {

        final int[] var = new int[1];

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Users");
        query.whereEqualTo("Email", email);
        query.whereEqualTo("username", username);
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> users, com.parse.ParseException e) {
                if (e == null) {
                    // your logic here

                    if (users.isEmpty() ) {
                       // Toast.makeText(Register.this, "Va rog sa introduceti datele cerute ", Toast.LENGTH_SHORT).show();
                        var[0] =1;


                    } else { // login successful
                       // user = users.get(0);
                        var[0] =2;


                    }


                } else {
                    // handle Parse Exception here
                }
            }
        });

        if (var[0]==1)
        {
            return false;
        } else
        {
            return true;
        }

    }
/*

    @Override
    protected void onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

    }
    */
}
