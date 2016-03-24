package com.necis.firebasesample.ui;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.necis.firebasesample.R;
import com.necis.firebasesample.item.Item;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jarcode on 2016-03-24.
 */
public class DialogSave extends DialogFragment {
    EditText editTitle, editContent;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_save, container, false);
        getDialog().setTitle("Save Data");

        Button btnSubmit = (Button) view.findViewById(R.id.btnSubmit);
        editTitle = (EditText) view.findViewById(R.id.editTitle);
        editContent = (EditText) view.findViewById(R.id.editContent);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    final Firebase ref = new Firebase("https://necis-firebase.firebaseio.com/android");
                    //Pojo Item

//                    Firebase alanRef = ref.child("data");
//                    Item alan = new Item("Android Kejar", "Android kejar Kejaran main kejar kejaran");
//                    alanRef.setValue(alan);

                    String title = editTitle.getText().toString();
                    String content = editContent.getText().toString();
                    //HashMap Structur
                    Firebase firebase = ref.child("data").child(title);
                    Map<String, String> data = new HashMap<String, String>();
                    data.put("title", title);
                    data.put("content", content);

                    firebase.setValue(data, new Firebase.CompletionListener() {
                        @Override
                        public void onComplete(FirebaseError firebaseError, Firebase firebase) {
                            if (firebaseError != null) {
                                Log.e("error", firebaseError.getMessage());
                            } else {
                                Toast.makeText(getActivity(), "Save Data Success", Toast.LENGTH_SHORT).show();
                                dismiss();
                            }
                        }
                    });
                } catch (Exception e) {
                    dismiss();
                }
            }
        });

        return view;
    }
}
