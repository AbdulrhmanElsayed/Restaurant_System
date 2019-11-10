package com.example.foodorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class TableNumber extends AppCompatActivity {

    EditText tbl_name;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_number);
        tbl_name = findViewById(R.id.tbl_num);
        btn = findViewById(R.id.btnSave);

        if(skip()){
            startActivity(new Intent(this,MainActivity.class));
            finish();
        }
    }

    public void next(View view) {
        String txt = tbl_name.getText().toString();
        if(txt.equals("")){
            Toast.makeText(this, "You Must Entre Table Name", Toast.LENGTH_SHORT).show();
        }
        else{
            boolean isSave = save(Integer.valueOf(txt));
            if(isSave)
                skipPage();
            startActivity(new Intent(this,MainActivity.class));
            finish();
        }
    }

    public boolean save(int num){
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("intro", MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("tblNum",num);
        edit.commit();
        return true;
    }
    public boolean skipPage(){
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("skip", MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean("isOPen",true);
        edit.commit();
        return true;
    }
    public boolean skip(){
        SharedPreferences pref = getApplicationContext().getSharedPreferences("skip",MODE_PRIVATE);
        Boolean isOpen = pref.getBoolean("isOPen",false);
        return  isOpen;
    }
}
