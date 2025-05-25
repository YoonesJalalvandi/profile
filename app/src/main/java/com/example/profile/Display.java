package com.example.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Display extends AppCompatActivity {

    // ویجت‌ها
    private TextView tvDisplayInfo;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display); // ست کردن لایه رابط کاربری

        // گرفتن رفرنس ویجت‌ها
        tvDisplayInfo = findViewById(R.id.tvDisplayInfo);
        btnBack = findViewById(R.id.btnBack);

        // دریافت Intent و اطلاعات منتقل‌شده
        Intent intent = getIntent();
        String firstName = intent.getStringExtra("FIRST_NAME");
        String lastName = intent.getStringExtra("LAST_NAME");
        String age = intent.getStringExtra("AGE");

        // نمایش اطلاعات در TextView
        String displayText = "Name: " + firstName + " " + lastName + "\nAge: " + age;
        tvDisplayInfo.setText(displayText);

        // دکمه بازگشت برای پایان اکتیویتی
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // بستن صفحه و بازگشت به اکتیویتی قبلی
            }
        });
    }
}
