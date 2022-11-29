package com.example.FOODCHEAP;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import android.util.*;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.*;

public class register extends AppCompatActivity {

    private static final String TAG = "Register";
    private EditText register_ID, register_PW, register_UserName;
    private Button register;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        firebaseAuth = FirebaseAuth.getInstance();

        register_UserName = (EditText) findViewById(R.id.register_username);//
        register_ID = (EditText) findViewById(R.id.register_id);
        register_PW = (EditText) findViewById(R.id.register_pw);

        register = findViewById(R.id.register);//회원가입 버튼
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//회원가입 버튼이 눌렸을 경우

                        if (!register.getText().toString().equals("") && !register_PW.getText().toString().equals("")) {
                            // 이메일과 비밀번호가 공백이 아닌 경우
                            if(register_PW.getText().toString().length()>=6){//패스워드가 6자리 이상인경우, 정상적인 패스워드인 경우
                                createUser(register_ID.getText().toString(),
                                        register_PW.getText().toString(),
                                        register_UserName.getText().toString());
                            }
                            else{//정상적인 패스워드가 아닌경우
                                Toast.makeText(register.this, "비밀번호는 6자리 이상으로 설정해주세요.", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            // 이메일과 비밀번호가 공백인 경우
                            Toast.makeText(register.this, "계정과 비밀번호를 입력하세요.", Toast.LENGTH_LONG).show();
                        }
            }
        });

    }


    private void createUser(String email, String password, String name) {//사용자 데이터베이스 설정
        String id = email;
        String pw = password;
        firebaseAuth.createUserWithEmailAndPassword(id, pw)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("email", email);
                        if (task.isSuccessful()) {
                            // 회원가입 성공시
                            Log.d(TAG, task.getException().getMessage());
                            Toast.makeText(register.this, "이미 존재하는 계정입니다.", Toast.LENGTH_SHORT).show();
                        } else {
                            // 계정이 중복된 경우
                            Toast.makeText(register.this, "회원가입 성공", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }});
    }
}
