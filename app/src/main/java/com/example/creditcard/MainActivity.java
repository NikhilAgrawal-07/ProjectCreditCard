package com.example.creditcard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static boolean match(String mm)
    {
        if(mm.matches("([0-9]{2}+/+[0-9]{2})"))
        {
            return true;
        }
        else
            return false;
    }
    public void btn(View view){
        EditText cn = findViewById(R.id.cardNumber);
        EditText mmyy = findViewById(R.id.month);
        EditText cvv = findViewById(R.id.CVV);
        EditText first = findViewById(R.id.firstName);
        EditText last = findViewById(R.id.lastName);
        String Cn = cn.getText().toString();
        String MMYY = mmyy.getText().toString();
        String Cvv = cvv.getText().toString();
        String First = first.getText().toString();
        String Last = last.getText().toString();
        if (Cn.equals("") || MMYY.equals("") || Cvv.equals("") || First.equals("") || Last.equals(""))
        {
            Toast.makeText(getApplicationContext(), "Fill The Details", Toast.LENGTH_SHORT).show();
        }
        else {
            if(Cn.length() != 16)
            {
                Toast.makeText(getApplicationContext(), "Invalid Card Number", Toast.LENGTH_SHORT).show();
            }
            if(Cvv.length() != 3)
            {
                Toast.makeText(getApplicationContext(), "Invalid CVV", Toast.LENGTH_SHORT).show();
            }
            if(!match(MMYY))
            {
                Toast.makeText(getApplicationContext(), "See Format(MM//YY)", Toast.LENGTH_SHORT).show();
            }
            if(Cn.length() == 16 && Cvv.length() == 3 && match(MMYY)){
                Toast.makeText(getApplicationContext(), "Payment Successful", Toast.LENGTH_SHORT).show();
            }
        }



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}