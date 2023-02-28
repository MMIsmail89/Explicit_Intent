package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.explicitintent.databinding.Activity2Binding;
import com.example.explicitintent.databinding.Activity3Binding;

public class Activity3 extends AppCompatActivity {

    Activity3Binding binding;
    public final static String SURNAME_KEY = "surname";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = Activity3Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.activity3BtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.activity3EtSurname.getText().toString().isEmpty()){
                    Toast.makeText(Activity3.this, getString(R.string.Please_enter_all_fields) , Toast.LENGTH_SHORT).show();
                }
                else {
                    String surname = binding.activity3EtSurname.getText().toString().trim();
                    Intent intent = new Intent();
                    intent.putExtra(SURNAME_KEY, surname);
                    setResult(RESULT_OK, intent);
                    Activity3.this.finish();
                }
            }
        });

        binding.activity3BtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                Activity3.this.finish();
            }
        });

    }
}