package com.example.geo.studtrans;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Geo on 1/11/2015.
 */
public class MyAccount extends Activity {

    public EditText loginPassword;
    public EditText loginEmail;
    public EditText loginUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_account_layout);

        loginPassword = ((EditText) findViewById(R.id.editText6));
        loginPassword.setText(Login.usernameLogged);


        loginUsername = ((EditText) findViewById(R.id.editText5));
        loginUsername.setText(Register.userNameAtLogin);


        loginEmail = ((EditText) findViewById(R.id.editText4));
        loginEmail.setText(Login.passwordLogin);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_myaccount,menu);
        return true;
    }




    @Override
    public boolean onMenuItemSelected(int panel, MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.updateAccount:
                Toast.makeText(MyAccount.this, "Update Account", Toast.LENGTH_LONG).show();
                Intent aa=new Intent(MyAccount.this,Update.class);
                startActivity(aa);
                break;

        }

        return true;
    }

}
