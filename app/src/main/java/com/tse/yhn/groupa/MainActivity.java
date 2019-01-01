package com.tse.yhn.groupa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NameItemListener{

    private Button buttonNext;
    private RecyclerView recyclerView;
    private ListNameAdapter listNameAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listNameAdapter=new ListNameAdapter(this);

//        textViewName = findViewById(R.id.activity_main_textview_name);
        buttonNext = findViewById(R.id.btnNext);
        buttonNext.setOnClickListener(this);
        recyclerView = findViewById(R.id.recyclerViewName);

        // init list ---------------------------

        final LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(listNameAdapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        List nameList = DataManager.getInstance().getNameList();
        listNameAdapter.updateData(nameList);
    }


      /*  @Override
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
    }*/

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnNext:
                Intent intent = new Intent(this, FormActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onClickItem(String name) {
        Toast.makeText(this,name,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClickCross(String name) {
        Toast.makeText(this,"Clic sur l'image de " + name,Toast.LENGTH_LONG).show();
    }
}
