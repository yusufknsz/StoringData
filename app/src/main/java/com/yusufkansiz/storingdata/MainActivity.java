package com.yusufkansiz.storingdata;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText2);
        textView = findViewById(R.id.textView1);


        sharedPreferences = this.getSharedPreferences("com.yusufkansiz.storingdata", Context.MODE_PRIVATE);

        int storedAge = sharedPreferences.getInt("storedAge",0);

        if (storedAge== 0){
            textView.setText("Your age:");

        }else{
            textView.setText("Your age:"+storedAge);
        }



    }
    public void save(View view){

        if ( !editText.getText().toString().matches("")){
            int userAge = Integer.parseInt(editText.getText().toString());
            textView.setText(" Your Age:"+ userAge );

            sharedPreferences.edit().putInt("storedAge",userAge).apply();
        }


    }

    public void delete (View view){

        int storedData = sharedPreferences.getInt("storedAge",0);

        if (storedData != 0){
            sharedPreferences.edit().remove("storedAge").apply();
            textView.setText("Your Age: ");


        }


    }




}