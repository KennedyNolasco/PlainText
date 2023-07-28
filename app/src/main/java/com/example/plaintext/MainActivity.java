package com.example.plaintext;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        boolean prefLogin = sharedPreferences.getBoolean("preencherLogin", false);
        CheckBox editcheckBox = findViewById(R.id.checkBox);
        EditText editLogin =  findViewById(R.id.editLogin);
        EditText editPass  =  findViewById(R.id.editPassword);
        Button botao = findViewById(R.id.botão);

        if(prefLogin==true){
            Log.i("BOTAO","BOTAO TA LIGADO");
             editLogin.setText(sharedPreferences.getString("login", ""));
             editPass.setText(sharedPreferences.getString("password", ""));
        }
        botao.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                String prefLogin = sharedPreferences.getString("login", "");
                String prefPass  = sharedPreferences.getString("password", "");

                String editLogin = ((EditText) findViewById(R.id.editLogin)).getText().toString();
                String editPass  = ((EditText) findViewById(R.id.editPassword)).getText().toString();

                if (editLogin.equals(prefLogin) && editPass.equals(prefPass)) {
                    Intent intent = new Intent(MainActivity.this, ListActivity.class);
                    EditText inputLogin = findViewById(R.id.editLogin);
                    intent.putExtra("login", inputLogin.getText().toString());
                    startActivity(intent);
                }
                else
                    Toast.makeText(MainActivity.this, "Login/senha inválidos!", Toast.LENGTH_SHORT).show();
            }
        });
        editcheckBox.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

            }
        });
    }
    public void entrarClicado(View view) {

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.about) {

            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setMessage("PlainText Password Manager v1.0")
                    .setNeutralButton("Ok", null)
                    .show();
            return true;
        }
        else if( item.getItemId()==R.id.configs){
            Intent intent = new Intent(this,PreferencesActivity.class);
            startActivity(intent);
            return true;
        }
        else{
            return super.onOptionsItemSelected(item);

        }

    }



}