package com.myAgeEducation.cbseClass5;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.Query;
import com.firebase.client.ValueEventListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class WinnerList extends Activity {
    ListView _listView;
    private BaseAdapter _listAdapter;
    ArrayList<PojoWinnerDetails> _Pojo_winnerDetails = new ArrayList<>();
    ProgressDialog ringProgressDialog;

    ObjectAnimator animation;
    Timer timer = new Timer();
    ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.winner_list);
        _listView = findViewById(android.R.id.list);
        ringProgressDialog = new ProgressDialog(WinnerList.this);

        progressBar = findViewById(R.id.progressBar);
        animateProgressBar();
        addTimer();
        downloadWinnerDetails();
        addBannerAd();
    }

    private void addBannerAd()
    {
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);
    }

    private void animateProgressBar() {

        animation = ObjectAnimator.ofInt(progressBar, "progress", 0, 500); // see this max value coming back here, we animate towards that value
        animation.setDuration(2000); // in milliseconds
        animation.setInterpolator(new DecelerateInterpolator());
        animation.start();
    }

    public void addTimer()
    {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        progressBar.clearAnimation();
                        animateProgressBar();
                    }
                });
            }
        }, 0, 2000);
    }

    private void populateAdapter() {
        ArrayList<String> winnerBase64Photo = new ArrayList<>();
        ArrayList<String> contestName = new ArrayList<>();
        ArrayList<String> winnerName = new ArrayList<>();
        ArrayList<String> winnerCity = new ArrayList<>();

        for(PojoWinnerDetails winner : _Pojo_winnerDetails)
        {
            winnerBase64Photo.add(winner.getWinnerBase64Photo());
            contestName.add(winner.getContestName());
            winnerName.add(winner.getWinnerName());
            winnerCity.add(winner.getWinnerCity());
        }

        _listAdapter = new ListViewAdapterForWinnersList(WinnerList.this, winnerBase64Photo, contestName, winnerName, winnerCity);
        _listView.setAdapter(_listAdapter);
    }

    private void displayErrorText(String errorText)
    {
        TextView textView = findViewById(R.id.textViewWaiting);
        textView.setText(errorText);
        textView.setTextColor(Color.RED);
        textView.setVisibility(View.VISIBLE);
    }

    public void downloadWinnerDetails()
    {
        Firebase.goOnline();
        _Pojo_winnerDetails.clear();
        Firebase ref = new Firebase(Util.WinnerListRoot);
        Query queryRef = ref.orderByChild("contestName").limitToLast(24); // get the top 24 winners
        queryRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                try {
                    Firebase.goOffline();
                    timer.cancel();
                    progressBar.setVisibility(View.INVISIBLE);
                    //dismissProgressDialog();
                    ArrayList<PojoWinnerDetails> temp = new ArrayList<>();

                    if(snapshot == null)
                    {
                        //displayErrorText("Failed to retrieve data from the server");
                        displayErrorText("Failed to retrieve data from the server \nor \nno past winners");
                        return;
                    }

                    for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                        try {
                            PojoWinnerDetails pojoWinnerDetails = postSnapshot.getValue(PojoWinnerDetails.class);
                            temp.add(pojoWinnerDetails);
                        } catch (Exception e) {
                            Log.d("CBSE_ERROR", e.getMessage());
                        }
                    }

                    // reverse the winners so that the latest comes to top
                    for(int index = temp.size() - 1; index >= 0; index--)
                    {
                        _Pojo_winnerDetails.add(temp.get(index));
                    }

                    if (_Pojo_winnerDetails.size() > 0) {
                        findViewById(R.id.textViewWaiting).setVisibility(View.GONE);
                        populateAdapter();
                    }
                    else
                    {
                        displayErrorText("Failed to retrieve data from the server \nor \nno past winners");
                        return;
                    }
                }
                catch(Exception e)
                {
                    Firebase.goOffline();
                    progressBar.setVisibility(View.INVISIBLE);
                    displayErrorText("Failed to retrieve data from the server");
                }
        }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                Firebase.goOffline();
                progressBar.setVisibility(View.INVISIBLE);
                displayErrorText("Failed to retrieve data from the server");
                Log.d("Exception: ", firebaseError.getMessage());
            }
        });
    }

    public void onClickButtonOk(View view)
    {
        finish();
    }
}
