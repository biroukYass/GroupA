package com.tse.yhn.groupa;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView textViewName;
    private Button buttonNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewName = findViewById(R.id.activity_main_textview_name);
        buttonNext = findViewById(R.id.activity_main_button_next);
        buttonNext.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1){
            if (resultCode == RESULT_OK && data.getExtras() != null){
                Log.d("", "");
                String name = data.getStringExtra("name");
                textViewName.setText(name);
            }else{

            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.activity_main_button_next:
                Intent intent = new Intent(this, FormActivity.class);
                startActivityForResult(intent, 1);
                break;
        }
    }
}
