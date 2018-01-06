package com.example.client1.takingdatafromadapterinactivityandsendingtoanotheractivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Model> modelList;
    Button b, b2;
    CustomAdapter customAdapter;
    TextView f, l;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        f = (TextView) findViewById(R.id.fn);
        l = (TextView) findViewById(R.id.ln);

        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final List<Model> ll = prepareData();
        customAdapter = new CustomAdapter(ll);
        recyclerView.setAdapter(customAdapter);

        b = (Button) findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Model> model = customAdapter.getModelList();
                List<Model> al = new ArrayList<>();
                al.addAll(model);
                if (al.get(0).firstName.contains("dave")) {
                    f.setText("dave");
                }
                if (al.get(0).lastName.contains("batista")) {
                    l.setText("batista");
                } else {
                    l.setText("no");
                    f.setText("no");
                }
            }
        });

        b2 = (Button) findViewById(R.id.buttonsec);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Model model = customAdapter.getModelClass(1);
                f.setText(model.firstName);
                l.setText(model.lastName);

              /*  Intent intent=new Intent(getApplication(),SecondActivity.class);
                Bundle bundle=new Bundle();
                Model model=customAdapter.getModelClass(1);
                bundle.putParcelable("data", model);
                intent.putExtras(bundle);
                startActivity(intent);*/

            }
        });

    }

    public List<Model> prepareData() {
        modelList = new ArrayList<>();

        Model list;

        list = new Model();
        list.firstName = "dave";
        list.lastName = "batista";
        modelList.add(list);

        list = new Model();
        list.firstName = "rock";
        list.lastName = "edge";
        modelList.add(list);

        return modelList;

    }

}

