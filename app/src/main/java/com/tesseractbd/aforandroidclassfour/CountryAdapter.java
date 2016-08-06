package com.tesseractbd.aforandroidclassfour;

import android.content.Context;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by hhson on 8/6/2016.
 */
public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder>{

    private List<String> countryList;
    private Context context;

    public CountryAdapter(List<String> countryList, Context context) {
        this.countryList = countryList;
        this.context = context;
    }


    @Override
    public CountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.list_item_country, parent, false);

        CountryViewHolder holder = new CountryViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(final CountryViewHolder holder, int position) {
        holder.tvName.setText(countryList.get(position));
        if(position%2==0) {
            new Handler().post(new Runnable() {
                @Override
                public void run() {
                    holder.ivFlag.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.flag));
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    class CountryViewHolder extends RecyclerView.ViewHolder{

        public ImageView ivFlag;
        public TextView tvName;

        public CountryViewHolder(View itemView) {
            super(itemView);
            ivFlag = (ImageView) itemView.findViewById(R.id.iv_flag);
            tvName = (TextView) itemView.findViewById(R.id.tv_country_name);
        }
    }
}
