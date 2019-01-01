package com.tse.yhn.groupa;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormActivity extends AppCompatActivity {

    private Button buttononsave;
    private EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        buttononsave = findViewById(R.id.activity_form_button);
        editText = findViewById(R.id.activity_form_edtedtext);
         buttononsave.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 save();
             }
         });
    }
    private void save(){
        Intent resultIntent = new Intent();
        DataManager.getInstance().addName(editText.getText().toString());

        finish();

    }
}
