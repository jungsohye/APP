package com.example.jamjam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recycler_Train_Adapter extends RecyclerView.Adapter<recycler_Train_Adapter.ViewHolder> {
    private Context context;
    private ArrayList<Data> dataList;

    public recycler_Train_Adapter(Context context, ArrayList<Data> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Modetype.setText(dataList.get(position).getMode());
        holder.modescc.setText(dataList.get(position).getScc());
        holder.modetm.setText(dataList.get(position).getEx_time());
        holder.modecs.setText(dataList.get(position).getNow_step());
        holder.Req.setText(dataList.get(position).getReq());
        holder.SetTime.setText(dataList.get(position).getSetTime());
        holder.PerTime.setText(dataList.get(position).getPerTime());
        holder.MscMean.setText(dataList.get(position).getMscMean());
        holder.tnsMean.setText(dataList.get(position).gettnsMean());


        // 날자
        String date = dataList.get(position).getDate_time();
        if (date.length() > 10) {
            date = date.substring(0, 10);
        }
        holder.date_time.setText(date);
    }

    @Override
    public int getItemCount() {
        return this.dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView Modetype;
        protected TextView modescc;
        protected TextView modetm;
        protected TextView modecs;
        protected TextView Req;
        protected TextView SetTime;
        protected TextView PerTime;
        protected TextView MscMean;
        protected TextView tnsMean;
        protected TextView date_time;

        public ViewHolder(View itemView) {
            super(itemView);
            this.Modetype = itemView.findViewById(R.id.Modetype);
            this.modescc = itemView.findViewById(R.id.modescc);
            this.modetm = itemView.findViewById(R.id.modetm);
            this.modecs = itemView.findViewById(R.id.modecs);
            this.Req = itemView.findViewById(R.id.Req);
            this.SetTime = itemView.findViewById(R.id.SetTime);
            this.PerTime = itemView.findViewById(R.id.PerTime);
            this.MscMean = itemView.findViewById(R.id.MscMean);
            this.tnsMean = itemView.findViewById(R.id.tnsMean);
            this.date_time = itemView.findViewById(R.id.date_time);
        }
    }
}