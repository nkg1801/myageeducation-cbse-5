package com.myAgeEducation.cbseClass5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.app.Activity;
import android.content.Intent;
import android.widget.ListView;
import android.widget.ShareActionProvider;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.myAgeEducation.cbseClass5.computers.ComputerQuestionGenerator;
import com.myAgeEducation.cbseClass5.science.ScienceQuestionGenerator;
import com.myAgeEducation.cbsecommon.Question;

public class SubjectList extends Activity
{
    private ShareActionProvider mShareActionProvider;
    private static final int SUBJECT_INDEX = 0;
    private static final int QUESTION_SET_INDEX = 1;
	int _randomQuestionSet;
    DatabaseHelper _databaseHelper;
    int _cloudVersion = 0;
    private ArrayList<String> _downloadLinks = new ArrayList<>();
    private ArrayList<String> _pendingDownloads = new ArrayList<>();
    private ArrayList<Question> _questionList = new ArrayList<>();
    ListView _listView;
    ProgressDialog ringProgressDialog;
    private SharedPreferences _sharedPreferences;
    private boolean isAddToLocalDatabaseCompleted = true;
    private Runnable runnable;
    private Handler handler = new Handler();
    private boolean runnableStarted = false;

	final int SCIENCE = 0;
    final int MATHS = 1;
    final int COMPUTERS = 2;
    final int GK = 3;
    //final int PLAY_QUIZ = 4;
    final int HCF_LCM_CALCULATOR = 4;
    final int SCORE = 5;
    final int SHARE_APP_LINK = 6;
    final int APP_RATING = 7;
    final int GETMORE = 8;
    final int EXIT = 9;

    @Override
	public void onCreate(Bundle savedInstanceState)
	{
	    try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.subject_list);
            FirebaseApp.initializeApp(this);
            _listView = findViewById(android.R.id.list);
            _sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            ringProgressDialog = new ProgressDialog(SubjectList.this);

            try {
                // this is the first time the database is opened.
                openDatabase();
            } catch (Exception e) {
                Util.displayAlert("Error-SUB-001: " + e.getMessage(), "ERROR-SUB-001", SubjectList.this);
            }

            _listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    switch (position) {
                        case SCIENCE:
                            Util.Subject = "science";
                            break;

                        case MATHS:
                            Util.Subject = "maths";
                            break;

                        case COMPUTERS:
                            Util.Subject = "computers";
                            break;

                        case GK:
                            Util.Subject = "gk";
                            break;

                        case SCORE:
                            Util.Subject = "";
                            Intent subPage = new Intent();
                            subPage.setClassName(Util.PACKAGE_NAME, Util.PACKAGE_NAME + ".ScoreHistory");
                            startActivity(subPage);
                            break;

                        case SHARE_APP_LINK:
                            Util.Subject = "";
                            shareAppLink();
                            break;

                        case APP_RATING:
                            Util.Subject = "";
                            openPlayStoreForRating();
                            break;

                        case HCF_LCM_CALCULATOR:
                            startHcfCalculatorActivity();
                            break;

                        case GETMORE:
                            Util.Subject = "";
                            Intent intentGetMore = new Intent(SubjectList.this, GetMore.class);
                            startActivity(intentGetMore);
                            break;

                        case EXIT:
                            Util.Subject = "";
                            finish();
                            break;

                        default:
                            break;
                    }

                    if (!Util.Subject.isEmpty())
                    {
                        Util.allQuestions.clear();
                        if(Util.Subject.equalsIgnoreCase("maths"))
                        {
                            Intent intent = new Intent();
                            intent.setClassName(Util.PACKAGE_NAME, Util.PACKAGE_NAME + ".QuestionLoaderActivity");
                            startActivity(intent);
                        }
                        else if(Util.Subject.equalsIgnoreCase("science") || Util.Subject.equalsIgnoreCase("computers"))
                        {
                            openChapters("set1");
                        }
                        else {
                            GetDatabaseLocation();
                        }
                    }
                }
            });

            MobileAds.initialize(this); // admob app id for cbse-5 is now in AndroidManifest.xml

            populateAdapter();

            addBannerAd();
            findViewById(R.id.adView).setVisibility(View.VISIBLE);

            if (Util.AdDetail == null) {
                FirebaseManager.readAds(value -> {
                });
            }
        }
	    catch(Exception e)
        {
            Util.displayAlert(e.getMessage(), "Error", this);
        }
	}

    @Override
    public void onStop()
    {
        if(runnableStarted) {
            handler.removeCallbacks(runnable);
        }
        super.onStop();
    }

    private void startHcfCalculatorActivity()
    {
        Util.Subject = "";
        Intent intentGetMore = new Intent(SubjectList.this, HcfCalculatorActivity.class);
        startActivity(intentGetMore);
    }

    private void saveLastCloudVersion(int cloudVersion)
    {
        SharedPreferences.Editor prefEdit = _sharedPreferences.edit();
        prefEdit.putInt("CloudVersion", cloudVersion);
        prefEdit.apply();
    }

	private void addBannerAd()
	{
		AdView mAdView = findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder()
				.build();
		mAdView.loadAd(adRequest);
	}

	private void openDatabase()
	{
		_databaseHelper = new DatabaseHelper(getApplicationContext());
		try
		{
			_databaseHelper.createDataBase();
		}
		catch(IOException e)
        {
            Log.d("CBSE_ERROR_OPENDATABASE", Objects.requireNonNull(e.getMessage()));
        }

		_databaseHelper.openDataBase();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.activity_main, menu);
		return true;
	}

    // Call to update the share intent
    private void setShareIntent(Intent shareIntent) {
        if (mShareActionProvider != null) {
            mShareActionProvider.setShareIntent(shareIntent);
        }
    }

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		int id = item.getItemId();
		if (id == R.id.menu_settings) {
			openSettingsPage();
			return true;
		} else {
			return super.onOptionsItemSelected(item);
		}
	}
	
	public void openSettingsPage()
	{
		Intent subPage = new Intent();
		subPage.setClassName(Util.PACKAGE_NAME, Util.PACKAGE_NAME + ".SettingsActivity");
		startActivity(subPage);
	}

    private void addScienceQuestions()
    {
        Util.allQuestions.clear();
        for(int i = 0; i< ScienceQuestionGenerator.SCIENCE_CHAPTER_NAMES.size();i++)
        {
            List<Question> scienceQuestions = ScienceQuestionGenerator.getQuestions(i+1);
            Util.allQuestions.addAll(scienceQuestions);
        }
    }

    private void addComputerQuestions()
    {
        Util.allQuestions.clear();
        for(int i = 0; i< ComputerQuestionGenerator.COMPUTER_CHAPTER_NAMES.size(); i++)
        {
            List<Question> computerQuestions = ComputerQuestionGenerator.getQuestions(i+1);
            Util.allQuestions.addAll(computerQuestions);
        }
    }

	public void openChapters(String questionSet)
	{
        if(Util.Subject.equalsIgnoreCase("science"))
        {
            addScienceQuestions();
        }
        else if(Util.Subject.equalsIgnoreCase("computers"))
        {
            addComputerQuestions();
        }

		Intent chapterIntent = new Intent();
		chapterIntent.setClassName(Util.PACKAGE_NAME, Util.PACKAGE_NAME + ".Chapters");
		chapterIntent.putExtra("question_set", questionSet);
		startActivity(chapterIntent);
	}
	
	private int getRandomQuestionSet()
	{
		Random random = new Random();
		return random.nextInt(9) + 11;
	}

	public void onClickOpenPlayStore(View view)
	{
        openPlayStore();
	}

    private void openPlayStore()
    {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=com.myAgeEducation.cbseClass5Paid"));
            startActivity(intent);
        }
        catch(Exception e)
        {
            Util.displayAlert("Cannot open play store. Open play store manually and search for CBSE Class 5", "Error", SubjectList.this);
        }
    }

    private void shareAppLink()
    {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = Util.PlayStoreLink;
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, Util.ShareLinkTitle);
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
        setShareIntent(sharingIntent);
    }

    private void openPlayStoreForRating()
    {
        try {
            //saveIfAdClicked();
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(Util.AppUriInPlayStore));
            startActivity(intent);
        }
        catch(Exception e)
        {
            Util.displayAlert("Cannot open play store. Open play store manually and search for CBSE Class 5", "Error", SubjectList.this);
        }
    }

    private void DownloadQuestionsOnlyIfAllowed()
    {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference("questionDatabaseVersion/cbse/settings/disableDownload");
        //Firebase ref = new Firebase("schools/question_database_version/cbse/settings/disableDownload");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int temp = snapshot.getValue(Integer.class);
                int isDownloadDisabled = 0;
                try
                {
                    isDownloadDisabled = temp;
                    Log.d("CBSE_isDownloadDisabled", String.valueOf(isDownloadDisabled));
                }

                catch(Exception e)
                {
                    Log.d("CBSE_Exception", Objects.requireNonNull(e.getMessage()));
                }

                if(isDownloadDisabled == 1) // download is disabled
                {
                    ArrayList<Integer> downloadedSets = _databaseHelper.getDownloadedQuestionSets(Util.Subject);
                    int downloadedSetsSize = downloadedSets.size();

                    // :-( no sets available, must download
                    if(downloadedSetsSize == 0)
                    {
                        downloadQuestions(_downloadLinks.get(0));
                    }
                    else // some downloads are available, will use the downloaded sets
                    {
                        Log.d("CBSE_downloaddisabled", "Download disabled, using local database, size is:" + String.valueOf(downloadedSetsSize));
                        Random random = new Random();
                        _randomQuestionSet = random.nextInt(downloadedSets.size());
                        _randomQuestionSet = downloadedSets.get(_randomQuestionSet);

                        runnable = () -> {
                            runnableStarted = true;
                            readQuestionsFromLocalDatabase();
                            runnableStarted = false;
                        };
                        new Thread(runnable).start();
                    }
                }
                else
                {
                    downloadQuestions(_downloadLinks.get(0));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError firebaseError) {
                Log.d("Exception: ", firebaseError.getMessage());
            }
        });
    }

	private void GetCloudQuestionDatabaseVersion()
	{
        showProgressDialog("Checking database for newer version...");
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference("questionDatabaseVersion/cbse/" + Util.Subject +"/cbseClass" + Util.GRADE);

		//Firebase ref = new Firebase("schools/questionDatabaseVersion/cbse/" + Util.Subject +"/cbseClass" + Util.GRADE);
		databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(@NonNull DataSnapshot snapshot) {
				int version = snapshot.getValue(Integer.class);

                dismissProgressDialog();
				Log.d("myVersion", String.valueOf(version));

				try
				{
                    _cloudVersion = version;
                    saveLastCloudVersion(_cloudVersion);
					Log.d("CloudVersion", String.valueOf(_cloudVersion));
				}

				catch(Exception e)
				{
					Log.d("CloudVersionException", Objects.requireNonNull(e.getMessage()));
		    	}

                try {
                    int localVersion = _databaseHelper.getLocalQuestionDatabaseVersion(Util.Subject);
                    Log.d("CBSE_LocalVersion", String.valueOf(localVersion));

                    if (_cloudVersion > localVersion) {
                        Log.d("CBSE_CloudVersion", String.valueOf(_cloudVersion));
                        Log.d("CBSE_CloudVersionInfo", "Cloud Version is greater than local version");
                        _databaseHelper.resetDownloadStatus(Util.Subject);
                    }
                }
                catch(Exception e)
                {
                    Util.displayAlert("ERROR-121: " + e.getMessage(), "ERROR-121", SubjectList.this);
                }

                getQuestions();
			}

			@Override
			public void onCancelled(@NonNull DatabaseError firebaseError) {
                dismissProgressDialog();
				Log.d("CBSE_Exception: ", firebaseError.getMessage());
                Util.displayAlert("Unable to connect to the server. Make sure you are connected to the internet and try again","Unable to connect", SubjectList.this);
            }
		});
	}

    private void getQuestions()
    {
        _randomQuestionSet = getRandomQuestionSet();
        _pendingDownloads = _databaseHelper.pendingDownloads(Util.Subject, _randomQuestionSet);
        Log.d("CBSE_PendingDownloads", String.valueOf(_pendingDownloads.size()));

        if(!_pendingDownloads.isEmpty())
        {
            addDownloadLinksToDownload();
            DownloadQuestionsOnlyIfAllowed();
        }
        else {
            try {
                runnable = () -> {
                    runnableStarted = true;
                    readQuestionsFromLocalDatabase();
                    runnableStarted = false;
                };
                new Thread(runnable).start();
            }

            catch(Exception e)
            {
                Util.displayAlert("reading questions from local database failed. " + e.getMessage(), "Error", SubjectList.this);
            }
        }
    }

	public void readQuestionsFromLocalDatabase()
	{
		String tableName = Util.SCHOOL_NAME + "_" + Util.Subject;
		if(Util.allQuestions != null) {
            Util.allQuestions.clear();
        }
		Util.allQuestions = _databaseHelper.getAllQuestions(tableName.toUpperCase(), _randomQuestionSet);
        if(Util.allQuestions == null)
        {
            //Something went wrong, the database has returned null .. will use the questions from the cloud .. hope it does not rain
            String downloadLink = Util.Subject + "/set" + _randomQuestionSet;
            downloadQuestions(downloadLink);
            return;
        }
		Log.d("CBSE_QuestionSet", String.valueOf(_randomQuestionSet));
		Log.d("CBSE_QuestionCount", String.valueOf(Util.allQuestions.size()));

		if(!Util.allQuestions.isEmpty()) {
			{
				openChapters("set" + _randomQuestionSet);
			}
		}
	}

	private void GetDatabaseLocation()
    {
        GetCloudQuestionDatabaseVersion();
    }

    private void addQuestionToLocalDatabase(String downloadLink) {
        isAddToLocalDatabaseCompleted = false;
        String[] tokens = downloadLink.split("/");
        String subject = tokens[SUBJECT_INDEX];
        String set = tokens[QUESTION_SET_INDEX]; // will be of the form SetNN (NN = 11 to NN = 19)
        int setNumber = Integer.parseInt(set.substring(set.length() - 2)); // get the last 2 chars

        ArrayList<Question> questions = (ArrayList<Question>)_questionList.clone();
        _questionList.clear();

        if (_databaseHelper.addQuestions("CBSE_" + subject, questions, setNumber)) {
            _databaseHelper.updateDownloadStatus(subject, setNumber);
            if(_cloudVersion > 0) {
                _databaseHelper.updateLocalQuestionDatabaseVersionInfo(subject, _cloudVersion);
            }
        }

        isAddToLocalDatabaseCompleted = true;
    }

    private void showProgressDialog(final String message)
    {
        runOnUiThread(() -> {
            try {
                ringProgressDialog.setTitle("Please wait ...");
                ringProgressDialog.setMessage(message);
                ringProgressDialog.setCancelable(false);
                ringProgressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                if (ringProgressDialog != null && (!ringProgressDialog.isShowing())) {
                    ringProgressDialog.show();
                    ringProgressDialog.setCancelable(true);
                }
            }
            catch (Exception e)
            {
            }
        });
    }

    private void dismissProgressDialog()
    {
        runOnUiThread(() -> {
            if(ringProgressDialog!=null && ringProgressDialog.isShowing()) {
                ringProgressDialog.dismiss();
            }
        });
    }

    public void downloadQuestions(final String downloadLink)
    {
        showProgressDialog("Connecting to online question database...");
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference(downloadLink);

        Query queryRef = databaseReference.orderByChild("chapter");
        queryRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                try {
                    for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                        try {
                            Question question = postSnapshot.getValue(Question.class);
                            _questionList.add(question);
                        } catch (Exception e) {
                            Log.d("CBSE_ERROR", Objects.requireNonNull(e.getMessage()));
                        }
                    }

                    Log.d("CBSE_", _questionList.size() + " were downloaded");

                    if (!_questionList.isEmpty()) {
                        Util.allQuestions = (ArrayList<Question>) _questionList.clone();
                        if (isAddToLocalDatabaseCompleted)  // if the previous addition is completed, then only we add this, otherwise just ignore adding this set
                        {
                            Runnable runnable = () -> addQuestionToLocalDatabase(downloadLink);
                            new Thread(runnable).start();
                        }
                        else {
                            _questionList.clear();
                        }
                    } else {
                        Util.allQuestions.clear();
                        dismissProgressDialog();
                        Util.displayAlert("No questions available for this subject", "Questions not available", SubjectList.this);
                        return;
                    }

                    dismissProgressDialog();

                    openChapters("set" + String.valueOf(_randomQuestionSet));
                }
                catch(Exception e)
                {
                    Util.displayAlert(e.getMessage(), "ERROR_SUB_589", SubjectList.this);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError firebaseError) {
                Log.d("Exception: ", firebaseError.getMessage());
            }
        });
    }

    private void addDownloadLinksToDownload()
    {
        _downloadLinks.clear();
        final String subjectRoot = Util.SubjectRoot;

        for(int i = 0; i < _pendingDownloads.size(); i++)
        {
            //_downloadLinks.add(subjectRoot + "/" + _pendingDownloads.get(i));
            _downloadLinks.add(_pendingDownloads.get(i));
            Log.d("CBSE_PENDING_DOWNLOADS", _pendingDownloads.get(i));
        }
    }

	private void populateAdapter() {
		ArrayList<Integer> subjectImage = new ArrayList<>();
		ArrayList<String> subjectName = new ArrayList<>();
		ArrayList<String> tagLine = new ArrayList<>();

		//subjectImage.add(CONTEST, R.drawable.contest);
		subjectImage.add(SCIENCE, R.drawable.science);
		subjectImage.add(MATHS, R.drawable.maths);
		subjectImage.add(COMPUTERS, R.drawable.computers);
		subjectImage.add(GK, R.drawable.gk);
        subjectImage.add(HCF_LCM_CALCULATOR, R.drawable.ic_hcf_lcm_calculator);
		subjectImage.add(SCORE, R.drawable.score);
        subjectImage.add(SHARE_APP_LINK, R.drawable.share);
        subjectImage.add(APP_RATING, R.drawable.rating);
        subjectImage.add(GETMORE, R.drawable.getmore);
        subjectImage.add(EXIT, R.drawable.exit);

		//subjectName.add(CONTEST, "Knowledge Contest");
		subjectName.add(SCIENCE, "Science");
		subjectName.add(MATHS, "Maths");
		subjectName.add(COMPUTERS, "Computers");
		subjectName.add(GK, "GK");
        subjectName.add(HCF_LCM_CALCULATOR, "HCF-LCM Calculator");
		subjectName.add(SCORE, "Score");
        subjectName.add(SHARE_APP_LINK, "Share App Link");
        subjectName.add(APP_RATING, "Rate this app");
        subjectName.add(GETMORE, "Get More");
        subjectName.add(EXIT, "Exit");

        //tagLine.add(CONTEST, "Participate and win exciting prizes.");
        tagLine.add(SCIENCE, "");
        tagLine.add(MATHS, "");
        tagLine.add(COMPUTERS, "");
        tagLine.add(GK, "");
        tagLine.add(HCF_LCM_CALCULATOR, "");
        tagLine.add(SCORE, "");
        tagLine.add(SHARE_APP_LINK, "");
        tagLine.add(APP_RATING, "");
        tagLine.add(GETMORE, "");
        tagLine.add(EXIT, "");

        BaseAdapter _listAdapter = new ListViewAdapterForSubjectList(SubjectList.this, subjectImage, subjectName, tagLine);
		_listView.setAdapter(_listAdapter);
	}
}
