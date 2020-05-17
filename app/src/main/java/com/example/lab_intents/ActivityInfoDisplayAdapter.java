package com.example.lab_intents;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ActivityInfoDisplayAdapter extends RecyclerView.Adapter<ActivityInfoDisplayAdapter.ActivityInfoItem> {

    private List<ResolveInfo> activities;
    private LayoutInflater layoutInflater;


    ActivityInfoDisplayAdapter(List<ResolveInfo> activities, ImplicitActivity implicitActivity) {
        this.activities = activities;
        Context context = implicitActivity.getApplicationContext();
        this.layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public ActivityInfoItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = layoutInflater.inflate(R.layout.acitivity_info_item, null);
        ActivityInfoItem container = new ActivityInfoItem(rootView);
//        container.name = rootView.findViewById(R.id.item_name);
//        container.packageName = rootView.findViewById(R.id.item_package);
        container.activity = rootView.findViewById(R.id.item_activity);
        rootView.setTag(container);
        return container;

    }

    @Override
    public void onBindViewHolder(ActivityInfoItem holder, int position) {
        final ActivityInfo info = activities.get(position).activityInfo;

//        holder.name.setText(info.applicationInfo.name);
//        holder.packageName.setText(info.applicationInfo.packageName);
        holder.activity.setText(info.targetActivity);

    }

    @Override
    public int getItemCount() {
        return activities.size();
    }

    class ActivityInfoItem extends RecyclerView.ViewHolder {
        TextView activity;

        ActivityInfoItem(View itemView) {
            super(itemView);
        }
    }

}

