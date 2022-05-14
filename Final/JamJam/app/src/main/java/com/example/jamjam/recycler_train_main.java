package com.example.jamjam;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class recycler_train_main extends AppCompatActivity {
    static RequestQueue requestQueue;

    RecyclerView recyclerView2;
    recycler_Train_Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_train_main);

        recyclerView2 = findViewById(R.id.recyclerView2);
        recyclerView2.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        makeRequest();

    }

    private void makeRequest() {

        String url = "http://114.71.220.74:2018/get/training";
        //JsonStreamParser
        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                response -> {
                    Log.d("GSON", "응답 -> " + response);

                    processResponse(response);

                },
                error -> Log.d("GSON", "에러 -> " + error.getMessage())
        ) {
            @Override
            protected Map<String, String> getParams() {

                return new HashMap<>();
            }
        };

        request.setShouldCache(false);
        requestQueue.add(request);
        Log.d("GSON", "요청 보냄.");
    }


    @SuppressLint("NotifyDataSetChanged")
    private void processResponse(String response) {
        Log.d("jamjam", "response:" + response);

        Gson gson = new Gson();
        DataInfo dataInfo = gson.fromJson(response, DataInfo.class);

        adapter = new recycler_Train_Adapter(getApplicationContext(), dataInfo.getTotal());
        recyclerView2.setAdapter(adapter);
    }
}
