package com.example.ganchenq.aptdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.BindView;
import com.example.OnClick;
import com.example.inject.inject.ViewInject;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button button;

    @OnClick(R.id.button)
    void onClick() {
        Toast.makeText(this, "click button", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewInject.inject(this);
    }
}
