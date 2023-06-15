package com.example.poet;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Love extends AppCompatActivity {

    TextView textView;
    Button btnprev,btnnext,btnshare;
    int i=0;

    String[] str = { "जिंदगी में कोई प्यार से प्यारा नही मिलता,\n" +
            "जिंदगी में कोई प्यार से प्यारा नही मिलता,\n" +
            "जो है पास आपके उसको सम्भाल कर रखना,\n" +
            "क्योंकि एक बार खोकर प्यार दोबारा नही मिलता।","बहुत सुकून मिलता है जब उनसे हमारी बात होती है,\n" +
            "वो हजारो रातों में वो एक रात होती है,\n" +
            "जब निगाहें उठा कर देखते हैं वो मेरी तरफ,\n" +
            "तब वो ही पल मेरे लीये पूरी कायनात होती है।","आग लगी दिल में जब वो खफ़ा हुए,\n" +
            "एहसास हुआ तब, जब वो जुदा हुए,\n" +
            "करके वफ़ा वो हमे कुछ दे न सके,\n" +
            "लेकिन दे गये बहुत कुछ जब वो वेबफा हुए।","किसी न किसी को किसी पर एतवार हो जाता है,\n" +
            "एक अजनबी सा चेहरा ही यार हो जाता है,\n" +
            "खूबियों से ही नही होती मोहब्बत सदा,\n" +
            "किसी की कमियों से भी कभी प्यार हो जाता है।","दिल का हाल बताना नही आता,\n" +
            "हमे ऐसे किसी को तड़पाना नही आता,\n" +
            "सुनना तो चाहतें हैं हम उनकी आवाज़ को,\n" +
            "पर हमे कोई बात करने का बहाना नही आता।\n" +
            "\n","हर कदम हर पल हम आपके साथ है,\n" +
            "भले ही आपसे दूर सही, लेकिन आपके पास हैं,\n" +
            "जिंदगी में हम कभी आपके हो या न हों,\n" +
            "लेकिन हमे आपकी कमी का हर पल एहसास हैं।","इश्क करती हूँ तुझसे अपनी जिंदगी से ज्यादा,\n" +
            "मैं डरतीं हूँ मौत से नही तेरी जुदाई से ज्यादा,\n" +
            "चाहे तो हमे आज़मा कर देख किसी और से ज्यादा,\n" +
            "मेरी जिंदगी में कुछ नही तेरी आवाज़ से ज्यादा।\n" +
            "\n","jjजब खामोश निगाहों से बात होती है,\n" +
            "तो ऐसे ही मोहब्बत की शुरुआत होती है,\n" +
            "हमतो बस खोये ही रहतें हैं उनके ख्यालों में,\n" +
            "पता ही नही चलता कब दिन कब रात होती है।\n"
    };
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textView = findViewById(R.id.tv);
        btnprev = findViewById(R.id.prev);
        btnnext = findViewById(R.id.next);
        btnshare = findViewById(R.id.sharebtn);
        textView.setText(str[i]);

        btnshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,str[i]);
                startActivity(intent);
            }
        });

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(i<str.length-1){
                    i++;
                    textView.setText(str[i]);

                    btnshare.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent();
                            intent.setAction(Intent.ACTION_SEND);
                            intent.setType("text/plain");
                            intent.putExtra(Intent.EXTRA_TEXT,str[i]);
                            startActivity(intent);
                        }
                    });

                }
                else{
                    Toast.makeText(Love.this, "no more quotes left", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnprev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(i>0){
                    i--;
                    textView.setText(str[i]);

                    btnshare.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent();
                            intent.setAction(Intent.ACTION_SEND);
                            intent.setType("text/plain");
                            intent.putExtra(Intent.EXTRA_TEXT,str[i]);
                            startActivity(intent);
                        }
                    });
                }
                else{
                    Toast.makeText(Love.this, "no more quotes left", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}