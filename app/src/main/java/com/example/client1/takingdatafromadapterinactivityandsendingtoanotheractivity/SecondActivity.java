package com.example.client1.takingdatafromadapterinactivityandsendingtoanotheractivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by client1 on 1/6/2018.
 */

public class SecondActivity extends AppCompatActivity
{
    TextView f,l;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        f=(TextView)findViewById(R.id.fn);
        l=(TextView)findViewById(R.id.ln);

        Model data=getIntent().getExtras().getParcelable("data");
        f.setText(data.firstName);
        l.setText(data.lastName);
    }
}
