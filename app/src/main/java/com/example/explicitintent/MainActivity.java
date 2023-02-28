package com.example.explicitintent;

import static com.example.explicitintent.R.*;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.explicitintent.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    public final static String NAME_KEY = "name";
    final int activity3_REQ_Code = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.mainBtnActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(binding.mainEtName.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, getString(string.Please_enter_all_fields) , Toast.LENGTH_SHORT).show();
                }
                else {
                    String name = binding.mainEtName.getText().toString().trim();
                    Intent intent = new Intent(MainActivity.this,
                            Activity2.class);
                    intent.putExtra(NAME_KEY, name);
                    startActivity(intent);
                }
            }
        });

        binding.mainBtnActivity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,
                        Activity3.class);

                startActivityForResult(intent, activity3_REQ_Code);
            }
        });

        binding.mainBtnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                startActivity(intent);
            }
        });
        binding.mainBtnCallFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+201029547116"));
                startActivity(intent);
            }
        });
        binding.mainBtnOpenWEB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse
                        ("https://www.google.com/"));
                startActivity(intent);
            }
        });
        binding.mainBtnOpenMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse
                        ("geo:0,0?q=السوق, محمد بدوى, ثان المنيا"));
                startActivity(intent);
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == activity3_REQ_Code){
            if(resultCode == RESULT_OK){
                binding.mainTvResultFromActivity3.setText(data.getStringExtra(Activity3.SURNAME_KEY));
            }
            if (resultCode == RESULT_CANCELED) {
                binding.mainTvResultFromActivity3.setText("No data received!");
            }

        }
            
    }


}