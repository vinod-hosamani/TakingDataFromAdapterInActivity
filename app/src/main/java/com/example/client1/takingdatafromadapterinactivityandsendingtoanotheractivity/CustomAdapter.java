package com.example.client1.takingdatafromadapterinactivityandsendingtoanotheractivity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by vinod on 10/12/17.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private static List<Model> list;

    public CustomAdapter(List<Model> list) {
        this.list = list;
    }

    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomAdapter.ViewHolder holder, final int position) {
        final Model model = list.get(position);
        holder.textView1.setText(model.firstName);
        holder.textView2.setText(model.lastName);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1;
        TextView textView2;
        RelativeLayout relativeLayout;
        Button button;

        public ViewHolder(View itemView) {
            super(itemView);
            textView1 = (TextView) itemView.findViewById(R.id.text1);
            textView2 = (TextView) itemView.findViewById(R.id.text2);
            relativeLayout = (RelativeLayout) itemView.findViewById(R.id.relativeLayout);
            button = (Button) itemView.findViewById(R.id.button);
        }
    }

    public List<Model> getModelList() {
        return list;
    }

    public Model getModelClass(int pos) {
        return list.get(pos);
    }

}
