package com.myAgeEducation.cbseClass5;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.myAgeEducation.cbsecommon.AdData;
import com.myAgeEducation.cbsecommon.Question;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Random;

public class Util
{
    static String Android_id = "";
    static Ads AdDetail;
	static ArrayList<Question> allQuestions = new ArrayList<>();
	static ArrayList<Question> filteredQuestions = new ArrayList<>();
	static ArrayList<Question> revisionQuestions = new ArrayList<>();

    public static String UserUid = "";
    static String ClassName = "class-5";
    static String SyllabusAndGrade = "cbse-5";
    static final String SCHOOL_NAME = "CBSE";

    static String forLogD = "";
    static AdData adData;
    static String UserNamePrefix = "cbse5";
    public static String TestName = "cbse5";
    static String AppUriInPlayStore = "market://details?id=com.myAgeEducation.cbseClass5";
    static boolean isFullPageAdDisplayed = false;

    /// Firebase related
    static String DefaultDatabaseLocation = "";
    static String FirebaseRoot = "";
    static String Firebase_DatabaseLocationSetting = "settings/database_location";
    static String DatabaseLocation = DefaultDatabaseLocation;
    static String TestReportRoot = "testReport/cbse/" + ClassName;
    static String UserRoot = "users/" + SCHOOL_NAME.toLowerCase() + "/" + ClassName;
    //static String SubjectRoot = "schools/" + SCHOOL_NAME.toLowerCase() + "/" + ClassName;
    static String SubjectRoot = "";

    ///================ Contest related============================================
    static String ContestRoot = "contest";
    static String ContestClassRoot = "contest/" + SyllabusAndGrade;
    static String ContestUserRoot = "contest/users";
    static String PrizeListRoot = "contest/prizes/";
    static String WinnerListRoot = "contest/winners";
    static int TestTimeOut = 15; // timeout in minute
    static boolean IsUserSignedIn = false;
    static boolean IsContestTest = false;
    static String ContestChapters;
    static int QuestionCountForContest = 25;
    static LinkedHashMap SubjectTestAttemptDetailsMaps = new LinkedHashMap();
    static boolean IsMockTest = false;
    static int CurrentDate = 0;
    static Date ServerDate;
    static String ReasonForMockTest;
    static ArrayList<PojoPrizeDetails> Pojo_prizeDetails = new ArrayList<>();
    static String ContestRules;
    //================== contest related data ends here===============================

    public static String AdDataRoot = SubjectRoot + "/extras/ads/activeAd";

    // banner ad for cbse-class-4
    //ca-app-pub-4837855590190532/7832704609

    static final String PACKAGE_NAME = "com.myAgeEducation.cbseClass5";

    static final String GRADE = "5";
    public static String Subject = "";
    static boolean isFreeApp = true;
    static boolean isReleaseVersion = true;
    static final String AdMobInterstitialAdUnitId = "ca-app-pub-4837855590190532/1241146602"; //cbse class-5
    static final String AdMobInterstitialAdUnitDummyId = "ca-app-pub-3940256099942544/1033173712";
    static final String ADMOB_APP_ID = "ca-app-pub-4837855590190532~7287680206"; //class5

    static final String PlayStoreLink = "https://play.google.com/store/apps/details?id=com.myAgeEducation.cbseClass" + GRADE;
    static final String ShareLinkTitle = "Link for " + SCHOOL_NAME + "-" + GRADE + " app download";
    static Double ServerTime;
    static String ServerTimeInMonth = "";

    static int getRandomQuestionSet()
    {
        Random random = new Random();
        return random.nextInt(9) + 11;
    }

    static String getCurrentDateTime()
    {
        Date date = new Date();
        SimpleDateFormat monthFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm a");
        return monthFormat.format(date);
    }

    static String getCurrentTime()
    {
        Date date = new Date();
        SimpleDateFormat monthFormat = new SimpleDateFormat("hh:mm a");
        return monthFormat.format(date);
    }

    static String getCurrentDate()
    {
        Date date = new Date();
        SimpleDateFormat monthFormat = new SimpleDateFormat("dd-MM-yyyy");
        return monthFormat.format(date);
    }

    static void displayAlert(String message, String title, Context context)
    {
        if(!((Activity)context).isFinishing()) {
            AlertDialog.Builder alert = new AlertDialog.Builder(context);
            alert.setMessage(message);
            alert.setTitle(title);
            alert.setPositiveButton("OK", null);
            alert.setCancelable(true);
            alert.create().show();
        }
    }

    static Bitmap LoadBitmapFromBase64Encoding(String imageData)
    {
        imageData = imageData.replace("data:image/png;base64,",""); // introduced in Release 1.19
        byte[] decodedString = Base64.decode(imageData, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
    }

    static void getServerTime()
    {
        Firebase.goOnline();
        Log.d("Server_Time", "Getting Server Time");
        DatabaseReference offsetRef = FirebaseDatabase.getInstance().getReference(".info/serverTimeOffset");
        offsetRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                //Firebase.goOffline();
                double offset = snapshot.getValue(Double.class);
                Double time = System.currentTimeMillis() + offset;


                long temp = (new Double(time)).longValue();
                Date resultDate = new Date(temp);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(resultDate);
                CurrentDate = calendar.get(Calendar.DATE);

                SimpleDateFormat sdf = new SimpleDateFormat("MMM-yyyy");
                Util.ServerTimeInMonth = sdf.format(resultDate);

                //SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                ServerDate = resultDate;
            }

            @Override
            public void onCancelled(DatabaseError error) {
                //Firebase.goOffline();
            }
        });
    }

    static void getServerTime(final FirebaseCallback firebaseCallback)
    {
        Firebase.goOnline();
        Log.d("Server_Time", "Getting Server Time");
        DatabaseReference offsetRef = FirebaseDatabase.getInstance().getReference(".info/serverTimeOffset");
        offsetRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                //Firebase.goOffline();
                double offset = snapshot.getValue(Double.class);
                Double time = System.currentTimeMillis() + offset;

                SimpleDateFormat sdf = new SimpleDateFormat("MMM-yyyy");
                long temp = (new Double(time)).longValue();
                Date resultDate = new Date(temp);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(resultDate);
                CurrentDate = calendar.get(Calendar.DATE);
                Util.ServerTimeInMonth = sdf.format(resultDate);
                firebaseCallback.onCallback(Util.ServerTimeInMonth);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                //Firebase.goOffline();
            }
        });
    }

    static ArrayList<Question> filterQuestions(ArrayList<Integer> chapters)
    {
        ArrayList<Question> filteredQuestions = new ArrayList<Question>();

        for(int i = 0; i < Util.allQuestions.size(); i++)
        {
            Question question = Util.allQuestions.get(i);
            int chapter = question.getChapter();

            if(chapters.contains(chapter))
            {
                filteredQuestions.add(question);
            }
        }

        return filteredQuestions;
    }
}
