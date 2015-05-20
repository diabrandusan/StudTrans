package com.example.geo.studtrans;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.List;

/**
 * Created by Geo on 12/4/2014.
 */
public class Update extends Activity {

    protected EditText updateEmail;
    protected EditText updateOldPassword;
    protected EditText updateNewPassword;
    protected Button updateB;

    //private ParseObject user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_layout);

        updateEmail = (EditText) findViewById(R.id.txtEmailUpdate);
        updateOldPassword = (EditText) findViewById(R.id.txtOldPassword);
        updateNewPassword = (EditText) findViewById(R.id.txtNewPassword);

        updateB = (Button) findViewById(R.id.buttonUpdate);
        updateB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String email = updateEmail.getText().toString();
                final String oldPass = updateOldPassword.getText().toString();
                final String newPass = updateNewPassword.getText().toString();


                // Create a pointer to an object of class Point with id dlkj83d




                ParseQuery<ParseObject> query = ParseQuery.getQuery("Users");
                query.whereEqualTo("username", Login.usernameLogged);
                query.whereEqualTo("password", oldPass);
                query.findInBackground(new FindCallback<ParseObject>() {
                    public void done(List<ParseObject> users, ParseException e) {
                        if (e == null) {
                            if (users.isEmpty()) {
                                Toast.makeText(Update.this, "Invalid password", Toast.LENGTH_SHORT).show();
                            } else { // login successful
                                if(newPass!=null) {
                                    ParseObject user = users.get(0);
                                    user.put("Email", email);
                                    user.put("password", newPass);
                                    user.saveInBackground();
                                    Toast.makeText(Update.this, "User updated!", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(Update.this, "Invalid password!", Toast.LENGTH_SHORT).show();
                                }

                            }


                        } else {
                            // handle Parse Exception here
                        }
                    }
                });
               /*
                ParseQuery<ParseObject> query = ParseQuery.getQuery("Users");
                query.whereEqualTo("Email", email);
               // query.whereEqualTo("password", oldPass);


                query.getInBackground("Email",new GetCallback<ParseObject>() {
                    public void done(ParseObject user, ParseException e) {
                        if (e == null) {
                            // Now let's update it with some new data. In this case, only cheatMode and score
                            // will get sent to the Parse Cloud. playerName hasn't changed.
                            user.set("password", newPass);
                            user.saveInBackground();

                            Toast.makeText(Update.this, "Update realizat cu succes", Toast.LENGTH_LONG).show();
                            Intent regI = new Intent(Update.this, Home.class);
                            startActivity(regI);
                        }else {
                                Toast.makeText(Update.this, "Error-Datele nu au fost introduse corect", Toast.LENGTH_LONG).show();
                            }

                    }
                });


*/

            }

        });


    }
}


