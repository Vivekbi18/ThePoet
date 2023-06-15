package com.example.poet;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Friendship extends AppCompatActivity {

    TextView textView;
    Button btnprev,btnnext,btnshare;
    int i=0;

    String[] str = { "तेरी मेरी यारी जमाने में सबसे प्यारी है\n" +
            "तेरे होने से ही मेरी जिंदगी में खुशियां आयी है..!","मुझे लाखो लोगो की जरूरत नही है\n" +
            "मेरा सच्चा यार ही करोड़ो में एक है..!","जिंदगी जीने का फलसफा\n" +
            "यार ने सिखाया है\n" +
            "अपना गम छुपाकर हमे हंसाया है..!","वक्त के साथ बहुत लोग बदल गए\n" +
            "कुछ अजनबी दोस्त जिंदगी बन गए..!","जिंदगी का बस यही फलसफा चाहिए था\n" +
            "कुछ नही बस एक सच्चा यार चाहिए था..!","हम जब भी राह भटकते है\n" +
            "तब जिंदगी की हर मुश्किल को\n" +
            "आसान बनाते है दोस्त..!","मेरा यार जिस पल मेरे साथ होता है\n" +
            "उस पल कोई गम\n" +
            "मेरे पास नही होता है.!","इश्क ने तबाह किया हमे तो\n" +
            "मेरे बेस्ट फ्रेंड ने मुझे संभाल लिया..!","जो सबकी मदद करते है\n" +
            "खुद बेबसी को खेलते है\n" +
            "वो सब के बेस्ट फ्रेंड होते है..!\n" +
            "\n" +
            "best friend shayari3","मैं ढूंढ रहा था दुनिया\n" +
            "के समुंदर में किनारा\n" +
            "ए दोस्त तू बनकर आया मेरी\n" +
            "जिंदगी में चमकता सितारा..!"
    };
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friendship);

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
                    Toast.makeText(Friendship.this, "no more quotes left", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(Friendship.this, "no more quotes left", Toast.LENGTH_SHORT).show();
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