package com.ds.novlag.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.ds.novlag.controller.DetailActivity;
import com.ds.novlag.controller.LoginActivity;
import com.ds.novlag.data.MyListData;
import com.ds.novlag.R;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder>{

    private MyListData[] listdata;

    // RecyclerView recyclerView;
    public MyListAdapter(MyListData[] listdata) {
        this.listdata = listdata;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final MyListData myListData = listdata[position];
        holder.imgLang.setImageResource(listdata[position].getImgId());
        holder.txtTitre.setText(listdata[position].getTitre());
        holder.txtDesc.setText(listdata[position].getDescription());

        final String langTitre = listdata[position].getTitre();
        final String langDesc = listdata[position].getDescription();
        final int langImg = listdata[position].getImgId();


        holder.btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext() , DetailActivity.class);
                intent.putExtra("langTitre", langTitre);
                intent.putExtra("langDesc", langDesc);
                intent.putExtra("langImg", langImg);
                v.getContext().startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgLang;
        public TextView txtTitre;
        public TextView txtDesc;

        public Button btnDetail;
        public ViewHolder(View itemView) {
            super(itemView);
            this.imgLang = (ImageView) itemView.findViewById(R.id.img_lang);
            this.txtTitre = (TextView) itemView.findViewById(R.id.txt_titre);
            this.txtDesc = (TextView) itemView.findViewById(R.id.txt_desc_lang);

            this.btnDetail = (Button) itemView.findViewById(R.id.btn_detail);
        }
    }
}
