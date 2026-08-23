package com.myAgeEducation.cbseClass5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ContestFirstPage extends Activity {
    Timer _timer = new Timer();
    TextView textView;
    ImageView imageView;
    List<String> Lines;
    int index = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contest_first_page);
        FirebaseApp.initializeApp(this);
        textView = findViewById(R.id.textViewContestFlash);
        imageView = findViewById(R.id.imageViewContestFlash);
        //Lines = Arrays.asList(getResources().getStringArray(R.array.contest_flash));
        addBannerAd();
        Util.getServerTime();
        GetContestFlashText();
        //addTimer();
    }

    public void addTimer()
    {
        _timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String text = Lines.get(index++);

                        // if there is a image in the flash, set the image, otherwise text
                        if(text.startsWith("image:"))
                        {
                            String imageName = text.split(":")[1];
                            textView.setVisibility(View.INVISIBLE);
                            imageView.setVisibility(View.VISIBLE);
                            int resourceIdentifier = getResources().getIdentifier(imageName, "drawable",getPackageName());
                            if(resourceIdentifier != 0)
                            {
                                imageView.setImageResource(resourceIdentifier);
                            }
                        }
                        else {
                            textView.setVisibility(View.VISIBLE);
                            imageView.setVisibility(View.INVISIBLE);
                            textView.setText(text);
                        }
                        if(index >= Lines.size())
                        {
                            index = 0;
                        }
                    }
                });
            }
        }, 0, 3000);
    }

    private void addBannerAd()
    {
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);
    }

    public void onClickContestRules(View view)
    {
        Intent intentContest = new Intent(ContestFirstPage.this, ContestRules.class);
        startActivity(intentContest);
    }

    public void onClickStartContest(View view)
    {
        Intent intentContest = new Intent(ContestFirstPage.this, ContestSubjectList.class);
        startActivity(intentContest);
        finish();
    }

    public void onClickPrizesForWinners(View view)
    {
        Intent intentContest = new Intent(ContestFirstPage.this, PrizeList.class);
        startActivity(intentContest);
    }

    public void onClickWinnersOfPastContests(View view)
    {
        Intent intent = new Intent(ContestFirstPage.this, WinnerList.class);
        startActivity(intent);
    }

    public void onClickContestRegistration(View view)
    {
        Intent intent = new Intent(ContestFirstPage.this, NewUpdateRegistration.class);
        startActivity(intent);
    }

    public void GetContestFlashText()
    {
        Firebase.goOnline();
        Firebase ref = new Firebase(Util.ContestRoot + "/misc/contest_flash");
        ref.addListenerForSingleValueEvent(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot snapshot) {

                Firebase.goOffline();
                if(snapshot.getValue() == null)
                {
                    Log.d("CBSE_3", "No flash text");
                    return;
                }
                else
                {
                    String flash_text = snapshot.getValue().toString();
                    Log.d("CBSE_3", flash_text);
                    String[] temp = flash_text.split(";;");
                    Lines = new ArrayList<String>(Arrays.asList(temp));
                    addTimer();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Firebase.goOffline();
                Log.d("CBSE_Exception: ", firebaseError.getMessage());
            }
        });
    }
}
