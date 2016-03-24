package com.necis.firebasesample.adapter;

/**
 * Created by Jarcode on 2016-03-24.
 */

import android.app.Activity;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.necis.firebasesample.MainActivity;
import com.necis.firebasesample.R;
import com.necis.firebasesample.item.Item;

import org.w3c.dom.Text;

import java.util.List;

public class Item_Adapter extends RecyclerView.Adapter<Item_Adapter.Holder_Item> {
    List<Item> feedItemList;
    private MainActivity mContext;

    public Item_Adapter(MainActivity context, List<Item> feedItemList) {
        this.feedItemList = feedItemList;
        this.mContext = context;
    }


    @Override
    public Holder_Item onCreateViewHolder(final ViewGroup viewGroup, final int i) {
        View header = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_data, viewGroup, false);
        final Holder_Item mh = new Holder_Item(header);
        return mh;
    }

    @Override
    public void onBindViewHolder(final Holder_Item feedListRowHolder, final int i) {
        feedListRowHolder.txtTitle.setText(feedItemList.get(i).getTitle());
        feedListRowHolder.txtContent.setText(feedItemList.get(i).getContent());
        feedListRowHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mContext.setUpdate();
            }
        });
    }

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public void removeAt(int position) {
        feedItemList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, feedItemList.size());
    }

    class Holder_Item extends RecyclerView.ViewHolder {
        public TextView txtTitle, txtContent;
        public CardView cardView;

        public Holder_Item(View itemView) {
            super(itemView);
            this.txtTitle = (TextView) itemView.findViewById(R.id.txttitle);
            this.txtContent = (TextView) itemView.findViewById(R.id.txtcontent);
            this.cardView = (CardView) itemView.findViewById(R.id.cardview);
        }
    }
}

