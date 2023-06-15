package com.example.poet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.zip.Inflater;

public class cardView extends AppCompatActivity {
    CardView cardView1, cardView2, cardView3, cardView4, cardView5, cardView6, cardView7, cardView8;
    FirebaseAuth auth;
    FirebaseUser user;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);

        cardView1 = findViewById(R.id.gmView);
        cardView2 = findViewById(R.id.gnview);
        cardView3 = findViewById(R.id.loveView);
        cardView4 = findViewById(R.id.familyView);
        cardView5 = findViewById(R.id.friendView);
        cardView6 = findViewById(R.id.romanticView);
        cardView7 = findViewById(R.id.coupleView);
        cardView8 = findViewById(R.id.allView);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cardView.this, FirstView.class);
                startActivity(intent);
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cardView.this, gnView.class);
                startActivity(intent);
            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cardView.this, Love.class);
                startActivity(intent);
            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cardView.this, Family.class);
                startActivity(intent);
            }
        });
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cardView.this, Friendship.class);
                startActivity(intent);
            }
        });

        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cardView.this, Romantic.class);
                startActivity(intent);
            }
        });

        cardView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cardView.this, Couple.class);
                startActivity(intent);
            }
        });

        cardView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cardView.this, All.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.settings: {
                Intent i1 = new Intent(getApplicationContext(), Settings.class);
                startActivity(i1);
                finish();
                break;
            }


            case R.id.community: {
                Toast.makeText(this, "This field is empty", Toast.LENGTH_SHORT).show();
                break;
            }


            case R.id.share: {
                try {
                    Intent i3 = new Intent(Intent.ACTION_SEND);
                    i3.setType("text/plain");
                    i3.putExtra(Intent.EXTRA_SUBJECT, "The Poet");
                    i3.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=" + getApplicationContext().getPackageName());
                    startActivity(Intent.createChooser(i3, "Share Via"));
                } catch (Exception e) {
                    Toast.makeText(this, "Unable to share this app", Toast.LENGTH_SHORT).show();
                }
                   break;
            }

            case R.id.rateus: {
                Toast.makeText(this, "This field is empty", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.search: {
                Toast.makeText(this, "This field is empty", Toast.LENGTH_SHORT).show();
                break;
            }

            case R.id.signout: {
                auth.signOut();
                Intent i = new Intent(getApplicationContext(), Login.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(), "Signed out", Toast.LENGTH_SHORT).show();
                 break;
            }

            default: return super.onOptionsItemSelected(item);

        }

  return true;

    }
}

