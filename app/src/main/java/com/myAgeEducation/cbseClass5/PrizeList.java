package com.myAgeEducation.cbseClass5;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
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

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class PrizeList extends Activity {
    ListView _listView;
    private BaseAdapter _listAdapter;
    ObjectAnimator animation;
    Timer timer = new Timer();
    ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prize_list);
        _listView = findViewById(android.R.id.list);
        progressBar = findViewById(R.id.progressBar);
        animateProgressBar();
        addTimer();
        if(Util.Pojo_prizeDetails.size() == 0) {
            downloadPrizeDetailsEx();
        }
        else
        {
            findViewById(R.id.textViewPrizeHeading).setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.INVISIBLE);
            populateAdapterEx();
        }
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

    private void populateAdapterEx() {
        ArrayList<String> prizeImage = new ArrayList<>();
        ArrayList<String> prizeDescription = new ArrayList<>();

        for(PojoPrizeDetails prize : Util.Pojo_prizeDetails)
        {
            prizeImage.add(prize.getImage());
            prizeDescription.add(prize.getDescription());// + "\nValue of the prize: " + prize.getPrice());
        }

        _listAdapter = new ListViewAdapterForContestPrizeList(PrizeList.this, prizeImage, prizeDescription, false);
        _listView.setAdapter(_listAdapter);
    }

    private void displayErrorText(String errorText)
    {
        TextView textView = findViewById(R.id.textViewWaiting);
        textView.setText(errorText);
        textView.setTextColor(Color.RED);
        textView.setVisibility(View.VISIBLE);
    }

    public void downloadPrizeDetailsEx()
    {
        Util.Pojo_prizeDetails.clear();

        Util.getServerTime(new FirebaseCallback() {
            @Override
            public void onCallback(String value) {
                Firebase.goOnline();
                String prizeListRoot = Util.PrizeListRoot + Util.ServerTimeInMonth;// + value + "/contest_details/prizes";
                Firebase ref = new Firebase(prizeListRoot);
                ref.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot snapshot) {
                        try {
                            timer.cancel();
                            progressBar.setVisibility(View.INVISIBLE);
                            Firebase.goOffline();
                            if(snapshot == null)
                            {
                                displayErrorText("Contest for the month: " + Util.ServerTimeInMonth + " not yet started");
                                return;
                            }
                            Util.Pojo_prizeDetails.clear();
                            for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                try {
                                    PojoPrizeDetails pojoPrizeDetails = postSnapshot.getValue(PojoPrizeDetails.class);
                                    Util.Pojo_prizeDetails.add(pojoPrizeDetails);
                                } catch (Exception e) {
                                    Log.d("CBSE_ERROR", e.getMessage());
                                }
                            }

                            if (Util.Pojo_prizeDetails.size() > 0) {
                                findViewById(R.id.textViewWaiting).setVisibility(View.GONE);
                                findViewById(R.id.textViewPrizeHeading).setVisibility(View.VISIBLE);
                                populateAdapterEx();
                            } else {
                                displayErrorText("No prize details found at the server");
                                return;
                            }
                        }
                        catch(Exception e)
                        {
                            Firebase.goOffline();
                            progressBar.setVisibility(View.GONE);
                            displayErrorText("Failed to retrieve data from the server");
                        }
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {
                        Firebase.goOffline();
                        progressBar.setVisibility(View.INVISIBLE);
                        displayErrorText("Failed to get data from the server. Please try again after sometime");
                        Log.d("Exception: ", firebaseError.getMessage());
                    }
                });
            }
        });
    }

    public void onClickButtonOk(View view)
    {
        finish();
    }
}
