package com.necis.firebasesample;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.necis.firebasesample.adapter.Item_Adapter;
import com.necis.firebasesample.item.Item;
import com.necis.firebasesample.ui.DialogSave;
import com.necis.firebasesample.ui.DialogUpdate;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getFragmentManager();
                DialogSave dialogFragment = new DialogSave();
                dialogFragment.show(fm, "Save Data");
            }
        });
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final List<Item> feedItemList = new ArrayList<>();
        final Item_Adapter adapterList = new Item_Adapter(this, feedItemList);
        recyclerView.setAdapter(adapterList);
        //fromvalue
        Firebase ref = new Firebase("https://necis-firebase.firebaseio.com/android/data");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                feedItemList.clear();
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    Item post = postSnapshot.getValue(Item.class);
                    Log.e("title", post.getTitle());
                    Log.e("Content", post.getContent());
                    feedItemList.add(post);
                }
                adapterList.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Log.e("error", firebaseError.getMessage());
            }
        });

        //fromchild
//        ref.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                Item post = dataSnapshot.getValue(Item.class);
//                Log.e("title child", post.getTitle());
//                Log.e("Content child", post.getContent());
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//
//            }
//        });

    }

    public void setUpdate() {
        FragmentManager fm = getFragmentManager();
        DialogUpdate dialogFragment = new DialogUpdate();
        dialogFragment.show(fm, "Save Data");
    }
}
