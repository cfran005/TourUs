package com.example.tourus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {


    Button btnArtist;
    Button btnVenue;
    Button btnLogout;
    Button btnProfile;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnLogout = findViewById(R.id.logOut);
        btnArtist = findViewById(R.id.artists);
        btnVenue = findViewById(R.id.venues);
        btnProfile = findViewById(R.id.profile);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intToMain);

            }
        });

        btnArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intToArtist = new Intent(HomeActivity.this, ArtistActivity.class);
                startActivity(intToArtist);

            }
        });

        btnVenue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intToVenue = new Intent(HomeActivity.this, VenueActivity.class);
                startActivity(intToVenue);

            }
        });

        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intToProfile = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(intToProfile);

            }
        });
    }
}