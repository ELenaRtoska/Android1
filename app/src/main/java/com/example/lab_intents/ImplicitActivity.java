package com.example.lab_intents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class ImplicitActivity extends AppCompatActivity {

    private String TAG;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit);
        String TAG = "ImplicitActivity";
        List<ResolveInfo> activities = listAllActivities(this);


        mRecyclerView = (RecyclerView) findViewById(R.id.activities_container);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new ActivityInfoDisplayAdapter(activities, this);
        mRecyclerView.setAdapter(mAdapter);
    }


    private List<ResolveInfo> listAllActivities(Context context) {

        PackageManager pm = context.getPackageManager();
        Intent mainIntent = new Intent(Intent.ACTION_MAIN);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        return pm.queryIntentActivities(mainIntent, 0);
    }
}