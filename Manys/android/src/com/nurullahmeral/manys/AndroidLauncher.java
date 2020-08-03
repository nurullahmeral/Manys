package com.nurullahmeral.manys;


import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Gravity;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.backends.android.AndroidGraphics;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.GamesClient;
import com.google.android.gms.games.LeaderboardsClient;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayersClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;

public class AndroidLauncher extends AndroidApplication implements PlayServices {
    // Client used to sign in with Google APIs
    private GoogleSignInClient mGoogleSignInClient;
    private GoogleSignInAccount mGoogleSignInAccount;

    // Client variables
    private LeaderboardsClient mLeaderboardsClient;
    private PlayersClient mPlayersClient;

    // request codes we use when invoking an external activity
    private static final int RC_UNUSED = 5001;
    private static final int RC_SIGN_IN = 9001;
    private static final int RC_LEADERBOARD_UI = 9004;

    // tag for debug logging
    private static final String TAG = "Firebase Test";

    // Firebase Analytics
    private FirebaseAnalytics mFirebaseAnalytics;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        config.useImmersiveMode = true;
        initialize(new CountMoneyGame(this), config);

        // Create the client used to sign in to Google services.
        mGoogleSignInClient = GoogleSignIn.getClient(this,
                new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN).build());

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
    }



    private void startSignInIntent() {
        Log.d(TAG, "startSignInIntent");
        startActivityForResult(mGoogleSignInClient.getSignInIntent(), RC_SIGN_IN);
    }

    private void signOut() {
        Log.d(TAG, "signOut()");

        if (!isSignedIn()) {
            Log.w(TAG, "signOut() called, but was not signed in!");
            return;
        }

        mGoogleSignInClient.signOut().addOnCompleteListener(this,
                new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        boolean successful = task.isSuccessful();
                        Log.d(TAG, "signOut(): " + (successful ? "success" : "failed"));

                        onDisconnected();
                    }
                });

    }

    @Override
    public void signInSilently() {
        Log.d(TAG, "signInSilently()");

        mGoogleSignInClient.silentSignIn().addOnCompleteListener(this,
                new OnCompleteListener<GoogleSignInAccount>() {
                    @Override
                    public void onComplete(@NonNull Task<GoogleSignInAccount> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "signInSilently(): success");
                            onConnected(task.getResult());
                        } else {
                            Log.d(TAG, "signInSilently(): failure", task.getException());
                            onDisconnected();
                        }
                    }
                });
    }

    public boolean isSignedIn() {
        Log.d(TAG, "isSignedIn= " + (GoogleSignIn.getLastSignedInAccount(this) != null));
        return GoogleSignIn.getLastSignedInAccount(this) != null;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task =
                    GoogleSignIn.getSignedInAccountFromIntent(intent);

            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                onConnected(account);
            } catch (ApiException apiException) {
                String message = apiException.getMessage();
                if (message == null || message.isEmpty()) {
                  //  message = getString(R.string.signin_other_error);
                }

                onDisconnected();

                new AlertDialog.Builder(this)
                        .setMessage(message)
                        .setNeutralButton(android.R.string.ok, null)
                        .show();
            }
        }
    }

    private void onConnected(GoogleSignInAccount googleSignInAccount) {
        Log.d(TAG, "onConnected(): connected to Google APIs");

        mGoogleSignInAccount = googleSignInAccount;

        mLeaderboardsClient = Games.getLeaderboardsClient(this, googleSignInAccount);
        mPlayersClient = Games.getPlayersClient(this, googleSignInAccount);

        // Set the greeting appropriately on main menu
        mPlayersClient.getCurrentPlayer()
                .addOnCompleteListener(new OnCompleteListener<Player>() {
                    @Override
                    public void onComplete(@NonNull Task<Player> task) {
                        String displayName;
                        if (task.isSuccessful()) {
                            displayName = task.getResult().getDisplayName();
                        } else {
                            Exception e = task.getException();
                          //  handleException(e, getString(R.string.players_exception));
                            displayName = "???";
                        }
                        GamesClient gamesClient = Games.getGamesClient(AndroidLauncher.this, mGoogleSignInAccount); //setGravityForPopups(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
                        gamesClient.setGravityForPopups(Gravity.TOP | Gravity.CENTER_HORIZONTAL);
                        gamesClient.setViewForPopups(((AndroidGraphics) AndroidLauncher.this.getGraphics()).getView());
                    }
                });
    }

    private void onDisconnected() {
        Log.d(TAG, "onDisconnected()");

        mLeaderboardsClient = null;
        mPlayersClient = null;
    }

    private void handleException(Exception e, String details) {
        int status = 0;

        if (e instanceof ApiException) {
            ApiException apiException = (ApiException) e;
            status = apiException.getStatusCode();
        }
    }

    @Override
    public void onSignInButtonClicked() {
        startSignInIntent();
    }

    @Override
    public void onSignOutButtonClicked() {
        signOut();
    }

    @Override
    public void submitScore(String leaderboardId, int highScore) {
        Log.d(TAG, "leaderboardId IN= " + leaderboardId);
        if (isSignedIn()) {
            Log.d(TAG, "leaderboardId OUT= " + leaderboardId);
            mLeaderboardsClient.submitScore(leaderboardId, highScore);
        }
    }

    @Override
    public void showLeaderboard(String leaderboardId) {
        Log.d(TAG, "showLeaderboard IN= " + leaderboardId);
        if (isSignedIn()) {
            Log.d(TAG, "showLeaderboard OUT= " + leaderboardId);
            Games.getLeaderboardsClient(this, GoogleSignIn.getLastSignedInAccount(this))
                    .getLeaderboardIntent(leaderboardId)
                    .addOnSuccessListener(new OnSuccessListener<Intent>() {
                        @Override
                        public void onSuccess(Intent intent) {
                            startActivityForResult(intent, RC_LEADERBOARD_UI);
                        }
                    });
        }
    }

    @Override
    public void setTrackerScreenName(String screenName) {
        mFirebaseAnalytics.setCurrentScreen(this, screenName, null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");

        // Since the state of the signed in user can change when the activity is not active
        // it is recommended to try and sign in silently from when the app resumes.
        signInSilently();
    }
}



