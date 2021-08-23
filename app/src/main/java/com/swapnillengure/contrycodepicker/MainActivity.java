package com.swapnillengure.contrycodepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.swapnillengure.contrycodepickerlibrary.CountryClickListener;
import com.swapnillengure.contrycodepickerlibrary.CountryCodePicker;

public class MainActivity extends AppCompatActivity {

    TextView phone_code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phone_code = (TextView) findViewById(R.id.phone_code);
        CountryClickListener countryClickListener = new CountryClickListener() {
            @Override
            public void onItemClick(String name, String code) {
                phone_code.setText("+"+code);
            }
        };
        findViewById(R.id.phone_layout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call countrycodepicker Class A
                CountryCodePicker.PickerInit(MainActivity.this, countryClickListener);
            }
        });
    }
}