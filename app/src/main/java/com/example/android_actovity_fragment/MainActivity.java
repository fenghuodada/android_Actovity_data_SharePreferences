package com.example.android_actovity_fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username,userpwd;
    private TextView readname,readpwd;
    private Button save,delete,read;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.Mainacticity_username);
        userpwd=findViewById(R.id.Mainacticity_userpwd);
        readname=findViewById(R.id.Mainacticity_readUsername);
        readpwd=findViewById(R.id.Mainacticity_readPwd);
        save=findViewById(R.id.Mainacticity_save);
        delete=findViewById(R.id.Mainacticity_delete);
        read=findViewById(R.id.Mainacticity_read);
        //实例化sharepreferences
        sharedPreferences=getSharedPreferences("data",MODE_PRIVATE);
        editor=sharedPreferences.edit();
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("suername",username.getText().toString());
                editor.putString("userpwd",userpwd.getText().toString());
                editor.commit();
                Toast.makeText(MainActivity.this,"保存成功",Toast.LENGTH_SHORT).show();
            }
        });
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String stringname=sharedPreferences.getString("suername","");
                String stringpwd=sharedPreferences.getString("userpwd","");
                readname.setText(stringname);
                readpwd.setText(stringpwd);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.clear();
                editor.commit();
                readname.setText("未读取用户名");
                readpwd.setText("未读取密码");
                Toast.makeText(MainActivity.this,"删除操作完成",Toast.LENGTH_SHORT).show();
            }
        });

    }

}