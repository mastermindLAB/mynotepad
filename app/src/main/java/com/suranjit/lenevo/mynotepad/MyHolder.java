package com.suranjit.lenevo.mynotepad;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by su on 10/12/2016.
 */
public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView img;
    TextView nameTxt,posTxt;
    ItemClickListener itemClickListener;


    public MyHolder(View itemView) {
        super(itemView);

        //ASSIGN
        img= (ImageView) itemView.findViewById(R.id.studentImage);
        nameTxt= (TextView) itemView.findViewById(R.id.nameTxt);
        posTxt= (TextView) itemView.findViewById(R.id.posTxt);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v,getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener ic)
    {
        this.itemClickListener=ic;
    }
}
