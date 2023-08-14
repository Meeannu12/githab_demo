package com.example.api_intigration.Model;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.api_intigration.Example;
import com.example.api_intigration.R;

import java.util.List;

public class RecyclerView_Adapter extends RecyclerView.Adapter<RecyclerView_Adapter.ViewHolder> {
    Context context;
    private List<Example> listdata;
    public RecyclerView_Adapter(Context context, List<Example> listdata) {
        this.context = context;
        this.listdata = listdata;
        Log.d("data", String.valueOf(listdata.size()));
    }
    @NonNull
    @Override
    public RecyclerView_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view =layoutInflater.inflate(R.layout.design,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView_Adapter.ViewHolder holder, int position) {
        final Example data=listdata.get(position);
        holder.id.setText(String.valueOf(data.getId()));
        holder.data.setText(data.getDate());
        holder.data_gmt.setText(data.getDateGmt());
        holder.modified.setText(data.getModified());
        holder.slug.setText(data.getSlug());
        holder.link.setText(data.getLink());
    }

    @Override
    public int getItemCount() {
//        Log.d("hell", String.valueOf(listdata.size()));
//        return listdata.size();
        if (listdata != null) {
            Log.d("annu", String.valueOf(listdata.size()));
            return listdata.size(); // Return the size of your data list

        } else {
            System.out.println("HELLO world");
            return 0; // Return 0 if the data list is null
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id, data, data_gmt, modified, slug, link;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

             id=itemView.findViewById(R.id.id);
             data=itemView.findViewById(R.id.data);
             data_gmt=itemView.findViewById(R.id.data_gmt);
             modified=itemView.findViewById(R.id.modified);
             slug=itemView.findViewById(R.id.slug);
             link=itemView.findViewById(R.id.link);
        }
    }
}
