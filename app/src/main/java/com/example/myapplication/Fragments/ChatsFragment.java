package com.example.myapplication.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.UserAdapter;
import com.example.myapplication.Model.Chatlist;
import com.example.myapplication.Model.User;
import com.example.myapplication.Notifications.Token;
import com.example.myapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ChatsFragment extends Fragment {

    private RecyclerView recyclerView ;

    private UserAdapter userAdapter;
    private List<User> nUsers;

    FirebaseUser fuser;
    DatabaseReference reference;

    private List<Chatlist> usersList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chats, container, false);


        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        fuser = FirebaseAuth.getInstance().getCurrentUser();

        usersList = new ArrayList<>();
        
        reference = FirebaseDatabase.getInstance().getReference("Chatlist").child(fuser.getUid());
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                usersList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    Chatlist chatlist = snapshot.getValue(Chatlist.class);
                    usersList.add(chatlist);
                }
                chatList();
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
//        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener( new OnSuccessListener<InstanceIdResult>() {
//            @Override
//            public void onSuccess(InstanceIdResult instanceIdResult) {
//                String deviceToken = instanceIdResult.getToken();
//                updateToken(deviceToken);
//                // Do whatever you want with your token now
//                // i.e. store it on SharedPreferences or DB
//                // or directly send it to server
//            }
//        });


        return view;
    }

    private void updateToken(String token){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Token");
        Token token1 = new Token(token);
        reference.child(fuser.getUid()).setValue(token1);
    }

    private void chatList() {
        nUsers = new ArrayList<User>();
        reference = FirebaseDatabase.getInstance().getReference("Users");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                nUsers.clear();
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                    User user = snapshot.getValue(User.class);
                    for(Chatlist chatlist: usersList){
                        if(user.getId().equals(chatlist.getId())){
                            nUsers.add(user);
                        }
                    }
                }
                userAdapter = new UserAdapter(getContext(),nUsers, true);
                recyclerView.setAdapter(userAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}