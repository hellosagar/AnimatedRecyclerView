package com.sagar.awosmedarktheme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    Context mcontext;
    String[] arrayName;
    boolean isDark;

    public Adapter(Context mcontext, String[] arrayName,boolean isDark) {
        this.mcontext = mcontext;
        this.arrayName = arrayName;
        this.isDark=isDark;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.image.setAnimation(AnimationUtils.loadAnimation(mcontext,R.anim.fade_transition_anim));
        holder.constraintLayout.setAnimation(AnimationUtils.loadAnimation(mcontext,R.anim.fade_scale_anim));

        holder.title.setText(arrayName[position]);

    }

    @Override
    public int getItemCount() {
        return arrayName.length;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {


        public TextView title;
        public ImageView image;
        public ConstraintLayout constraintLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.titleTextView);
            image=itemView.findViewById(R.id.imageView);
            constraintLayout = itemView.findViewById(R.id.constraintLayout);

            if(isDark){
                setDarkTheme();
            }else{
                setLightTheme();
            }
        }

        public void setDarkTheme(){

                constraintLayout.setBackgroundResource(R.drawable.dark_card_bg);
        }

        public void setLightTheme(){

            constraintLayout.setBackgroundResource(R.drawable.card_bg);
        }
    }


}
