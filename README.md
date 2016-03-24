# Cloud Data FireBase Android
At Firebase we take security very seriously and are committed to ensuring that you can build applications that are secure.

If you think you have found a security vulnerability, please send an email to security@google.com with as much information as you can provide (including code examples) about the vulnerability, potential exploits, and any other information that will help us understand the issue. If you are researching a vulnerability, we encourage you to set up a test Firebase app to illustrate the issue, rather than using a customer's real Firebase app, where possible.

Please only use the security email account for exploits and vulnerabilities. All support requests and general inquiries sent to it will be ignored.

We do not provide acknowledgments on our site for reports, although we'll send you swag and our gratitude for reports that demonstrate a new, unreported issue.

# Add Dependci

    compile 'com.firebase:firebase-client-android:2.3.1'

# Declared Object in class Application
@Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }

# Save Data One Item
    final Firebase ref = new Firebase("https://necis-firebase.firebaseio.com/android");
    Pojo Item Firebase alanRef = ref.child("data");
    Item alan = new Item("Android Kejar", "Android kejar Kejaran main kejar kejaran");
    alanRef.setValue(alan);

# Save MultiData HashMap
    Firebase firebase = ref.child("data").child(title);
    Map<String, String> data = new HashMap<String, String>();
    data.put("title", title);
    data.put("content", content);
    firebase.setValue(data);
# Get Callback Process
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
    
# Retrieving Data from Value
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
# Retrieving Data from Child
        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Item post = dataSnapshot.getValue(Item.class);
                Log.e("title child", post.getTitle());
                Log.e("Content child", post.getContent());
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
http://necistudio.com/

https://www.firebase.com/docs/android/guide

