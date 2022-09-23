package com.training.mvvmretro.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.training.mvvmretro.R;
import com.training.mvvmretro.model.DetailModel;

import java.util.List;

public class DetailListAdapter extends RecyclerView.Adapter<DetailListAdapter.MyViewHolder> {

    private Context context;
    private List<DetailModel> detailList;

    public DetailListAdapter(Context context,List<DetailModel> detailList){
        this.context = context;
        this.detailList = detailList;

    }

    public void setDetailList(List<DetailModel> detailList){
        this.detailList = detailList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DetailListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailListAdapter.MyViewHolder holder, int position) {

        holder.id.setText(this.detailList.get(position).getId().toString());
        holder.name.setText(this.detailList.get(position).getName().toString());
        holder.phone.setText(this.detailList.get(position).getPhone().toString());
        holder.website.setText(this.detailList.get(position).getWebsite().toString());
        holder.company.setText(this.detailList.get(position).getCompany().getName().toString());
        holder.city.setText(this.detailList.get(position).getAddress().getCity().toString());
    }

    @Override
    public int getItemCount() {
        if (this.detailList != null){
            return this.detailList.size();
        }
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView id;
        TextView name;
        TextView website;
        TextView phone;
        TextView company;
        TextView city;
        public MyViewHolder(View itemView){
            super(itemView);

            id = (TextView)itemView.findViewById(R.id.Id);
            name = (TextView)itemView.findViewById(R.id.Name);
            website = (TextView)itemView.findViewById(R.id.Website);
            phone = (TextView)itemView.findViewById(R.id.phone);
            company = (TextView)itemView.findViewById(R.id.Company);
            city = (TextView)itemView.findViewById(R.id.city);

        }
    }
}
