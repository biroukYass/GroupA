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
    private EditText editTextName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        buttononsave = findViewById(R.id.activity_form_button);
        editTextName = findViewById(R.id.activity_form_edtedtext);
         buttononsave.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 save();
             }
         });
    }
    private void save(){
        String name = editTextName.getText().toString();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("name",name);
        setResult(RESULT_OK, resultIntent);
        finish();

    }
}
