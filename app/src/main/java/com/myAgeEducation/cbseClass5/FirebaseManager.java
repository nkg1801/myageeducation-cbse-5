package com.myAgeEducation.cbseClass5;

import android.util.Log;

import androidx.annotation.NonNull;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class FirebaseManager {
    public static void updateTestReport(String testReportRoot)
    {
        Firebase ref = new Firebase(testReportRoot);
        String uuid = UUID.randomUUID().toString();
        final Firebase childRef = ref.child(Util.getCurrentDate()).child(uuid);
        childRef.setValue(Util.getCurrentTime() + "/" + Util.Subject + "/"+ Util.UserUid);
    }

    static void updateGetMoreClicked(String appTitle)
    {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        String uuid = UUID.randomUUID().toString();
        String path = "/getmore-clicked/cbse-5/" + appTitle + "/" + uuid + "/";
        DatabaseReference databaseReference = firebaseDatabase.getReference(path);
        databaseReference.setValue(uuid);
    }

    /*static void updateAdButtonClicked()
    {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        String uuid = UUID.randomUUID().toString();
        String temp = Util.AdDetail.getLink();
        temp = temp.replace(".", "");
        temp = temp.replace("/", "");
        temp = temp.replace(".", "");
        temp = temp.replace("https", "");
        temp = temp.replace("http", "");
        temp = temp.replace(":", "");
        String path = "/chapters-ads-clicked/" + Util.SyllabusAndGrade + "/" + temp + "/" + uuid + "/";
        DatabaseReference databaseReference = firebaseDatabase.getReference(path);
        databaseReference.setValue(Util.getCurrentDateTime());
    }*/

    static void readAds(final FirebaseCallback firebaseCallback)
    {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference(Util.SubjectRoot + "/ads");
        databaseReference.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot snapshot) {
                try{
                    Util.AdDetail = snapshot.getValue(Ads.class);
                    firebaseCallback.onCallback("1");
                }
                catch(Exception e)
                {
                    firebaseCallback.onCallback("0");
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError firebaseError) {
                Log.d("Exception: ", firebaseError.getMessage());
                firebaseCallback.onCallback("0");
            }
        });
    }
}
