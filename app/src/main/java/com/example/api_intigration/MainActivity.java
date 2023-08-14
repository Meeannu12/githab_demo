package com.example.api_intigration;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;

import com.example.api_intigration.Model.RecyclerView_Adapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    API_Interface api_interface;
    RecyclerView recyclerView;
    RecyclerView_Adapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        api_interface = RetrofitClass.getRetrofit().create(API_Interface.class);
        recyclerView = findViewById(R.id.RecyclerView);
        Context context = MainActivity.this;

        api_interface.getModel().enqueue(new Callback<List<Example>>() {
            @Override
            public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {
                if (response.isSuccessful()) {
                    List<Example> data = response.body();
                    if (data != null) {
                        data.addAll(data);
                        Log.d("hel", String.valueOf(data.size()));
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
                        recyclerViewAdapter = new RecyclerView_Adapter (MainActivity.this, data);
                        Log.d("teg", String.valueOf(data.size()));
                        recyclerView.setLayoutManager(linearLayoutManager);
                        recyclerView.setAdapter(recyclerViewAdapter);
                    }

                    Toast.makeText(context, "response", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Example>> call, Throwable t) {
                Toast.makeText(context, "Content Faild", Toast.LENGTH_SHORT).show();

            }
        });
    }
}