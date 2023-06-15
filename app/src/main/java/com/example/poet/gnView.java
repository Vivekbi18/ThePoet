package com.example.poet;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class gnView extends AppCompatActivity {

    TextView textView;
    Button btnprev,btnnext,btnshare;
    int i=0,j=0;

    String[] str = { "रात को जब चाँद सितारे चमकते हैं,\n" +
            "हम हरदम आपकी याद में तड़पते हैं,\n" +
            "आप तो चले जाते हो छोड़कर हमें,\n" +
            "हम रात भर आपसे मिलने को तरसते हैं।","चाँद की चाँदनी से एक पालकी बनायी है,\n" +
            "ये पालकी हम ने तारों से सजाई है,\n" +
            "ऐ हवा ज़रा धीरे-धीरे ही चलना,\n" +
            "मेरे दोस्त को बड़ी प्यारी सी नींद आई है।\n" +
            "शुभरात्रि।","ऐ चाँद मेरे दोस्त को एक तोहफा देना,\n" +
            "तारों की महफ़िल के सपने दे देना,\n" +
            "छुपा देना तुम अंधेरों को रौशनी से,\n" +
            "इस रात के बाद एक खूबसूरत सवेरा देना।\n" +
            "गुड नाईट।","तन्हा रात में जब हमारी याद सताये,\n" +
            "हवा जब आपके बालों को सहलाये,\n" +
            "कर लेना आँखें बंद और सो जाना,\n" +
            "शायद हम आपके ख्वाबों में आ जाये।\n" +
            "शुभरात्रि।","होंठ कह नहीं सकते फ़साना दिल का,\n" +
            "शायद नजर से हमारी बात हो जाए,\n" +
            "इस उम्मीद में करते हैं इंतज़ार रात का,\n" +
            "शायद सपने में ही मुलाकात हो जाये।\n" +
            "शुभरात्रि।","मिलने आयेंगे हम आपसे ख्वाबों में,\n" +
            "ये जरा रौशनी के दिये बुझा दीजिए,\n" +
            "अब नहीं होता इंतज़ार आपसे मुलाकात का,\n" +
            "जरा अपनी आँखों के परदे गिरा दीजिए।\n" +
            "शुभरात्रि।","इस कदर हम आपकी मोहब्बत में खो गए,\n" +
            "एक नजर देखा और बस आपके ही हो गए,\n" +
            "आँख खुली तो पता चला देखा एक सपना था,\n" +
            "आँख बंद की और उसी सपने में खो गए।\n" +
            "शुभरात्रि।","रोज़ आ जाते हो तुम नींद की मुंडेरों पर,\n" +
            "बादलों में छुपे एक ख्वाब का मुखड़ा बन कर,\n" +
            "खुद को फैलाओ कभी आसमाँ की बाँहों सा,\n" +
            "तुम में घुल जाए कोई चाँद का टुकड़ा बन कर।\n" +
            "शुभरात्रि।।"
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
                    Toast.makeText(gnView.this, "no more quotes left", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(gnView.this, "no more quotes left", Toast.LENGTH_SHORT).show();
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