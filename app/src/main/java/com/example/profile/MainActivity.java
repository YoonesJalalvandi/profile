
package com.example.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // تعریف ویجت‌ها
    private EditText etFirstName, etLastName, etAge;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // ست کردن لایه‌ی رابط کاربری

        // دریافت رفرنس‌ها به ویجت‌های UI
        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etAge = findViewById(R.id.etAge);
        btnSubmit = findViewById(R.id.btnSubmit);

        // وقتی روی دکمه کلیک شد
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // گرفتن مقدار ورودی‌ها
                String firstName = etFirstName.getText().toString().trim();
                String lastName = etLastName.getText().toString().trim();
                String age = etAge.getText().toString().trim();

                // بررسی اینکه مقدار First Name خالی نباشه
                if (firstName.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter your first name.", Toast.LENGTH_SHORT).show();
                } else {
                    // ساخت Intent برای رفتن به اکتیویتی نمایش اطلاعات
                    Intent intent = new Intent(MainActivity.this, Display.class);
                    intent.putExtra("FIRST_NAME", firstName);
                    intent.putExtra("LAST_NAME", lastName);
                    intent.putExtra("AGE", age);

                    // شروع اکتیویتی جدید
                    startActivity(intent);
                }
            }
        });
    }
}
