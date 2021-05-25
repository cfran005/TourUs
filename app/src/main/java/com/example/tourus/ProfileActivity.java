package com.example.tourus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity {

    Button btnSave;
    EditText personName, emailID, genre, bio, phoneNo, price;
    CheckBox artistCB, venueCB;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btnSave = findViewById(R.id.save);
        personName = findViewById(R.id.editTextTextPersonName);
        emailID = findViewById(R.id.editTextTextEmailAddress2);
        genre = findViewById(R.id.editTextTextGenre);
        bio = findViewById(R.id.editTextTextMultiLine);
        phoneNo = findViewById(R.id.editTextPhone);
        price = findViewById(R.id.editTextNumber);
        artistCB = findViewById(R.id.ACheckBox);
        venueCB = findViewById(R.id.VCheckBox);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent saveBtn = new Intent(ProfileActivity.this, HomeActivity.class);
                rootNode = FirebaseDatabase.getInstance();

                String name = personName.getEditableText().toString();
                String _genre = genre.getEditableText().toString();
                String email = emailID.getEditableText().toString();
                String phone = phoneNo.getEditableText().toString();
                String cost = price.getEditableText().toString();
                String about = bio.getEditableText().toString();

                if (artistCB.isChecked() && !venueCB.isChecked()) {

                    reference = rootNode.getReference("Artists");
                    UserHelperClass helperClass = new UserHelperClass(name, _genre, email, about, phone, cost);

                    reference.child(name).setValue(helperClass);
                    startActivity(saveBtn);


                } else if (venueCB.isChecked() && !artistCB.isChecked()) {

                    reference = rootNode.getReference("Venues");
                    UserHelperClass helperClass = new UserHelperClass(name, _genre, email, about, phone, cost);

                    reference.child(name).setValue(helperClass);
                    startActivity(saveBtn);

                } else if (!artistCB.isChecked() && !venueCB.isChecked()){

                    Toast.makeText(ProfileActivity.this, "Please choose artist or venue", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
