package kk.projects.imageview.adapter;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import kk.projects.imageview.R;
import kk.projects.imageview.model.image_model;

public class image_adapter extends RecyclerView.Adapter<image_adapter.ViewHolder> {

    private Context mContext;


    private List<image_model.ResponseItem> listdataList;


    // RecyclerView recyclerView;
    public image_adapter(Context mContext, List<image_model.ResponseItem> listdata) {
        this.listdataList = listdata;

        this.mContext = mContext;

    }

    @Override
    public image_adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.image_visit, parent, false);
        image_adapter.ViewHolder viewHolder = new image_adapter.ViewHolder(listItem);
        return viewHolder;


    }


    @Override
    public void onBindViewHolder(image_adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {



       /* Glide.with(mContext)
                .load(listdataList.get(position).getUrls().get(position).getSmall())
                .into(holder.pdtImg)
                .error(R.drawable.pls);*/

        Glide.with(mContext)
                .load(listdataList.get(position).getUrls().getSmall())
                .override(300, 200)
                .placeholder(R.drawable.pls)
                .error(R.drawable.pls)
                .into(holder.pdtImg);
        holder.pdtname.setText(listdataList.get(position).getAlt_description());

        holder.pdtImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                final Dialog dialog = new Dialog(mContext);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.gallery_full_img);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                ImageView close_img = (ImageView) dialog.findViewById(R.id.close_img);
                ImageView pdtImg = (ImageView) dialog.findViewById(R.id.pdtImg);


                Glide.with(mContext).load(listdataList.get(position).getUrls().getSmall()).placeholder(R.drawable.pls).error(R.drawable.pls).into(pdtImg);


                close_img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });


                dialog.show();


            }
        });


    }


    @Override
    public int getItemCount() {
        return listdataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        public ImageView pdtImg;
        public TextView pdtname;

        public ViewHolder(View itemView) {
            super(itemView);

            this.pdtImg = itemView.findViewById(R.id.pdtImg);
            this.pdtname = itemView.findViewById(R.id.pdtname);


        }


    }

    //..also create a method which will hide the dialog when some work is done


}