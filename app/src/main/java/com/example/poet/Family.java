package com.example.poet;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Family extends AppCompatActivity {

    TextView textView;
    Button btnprev,btnnext,btnshare;
    int i=0;

    String[] str = { "कोई हल ढूंढ लेते है मुसीबत जब भी आती है,\n" +
            "मेरे परिवार का हर शख्स खुदा से कम नहीं है।","हर मर्ज का इलाज नही दवाखाने में,\n" +
            "कुछ दर्द चले जाते है परिवार के साथ मुस्कुराने में।","घर बडा हो या छोटा,\n" +
            "अगर मिठास ना हो तो\n" +
            "इंसान तो क्या\n" +
            "चीटियां भी नही आती।","एक अरसे से मुझको कहीं नजर नहीं आये,\n" +
            "बच्चे जबसे कमाने लगे कभी घर नहीं आये,\n" +
            "मेरी हालत देख कर सोचता है वो परिंदा भी\n" +
            "अच्छा हुआ कि मेरे बच्चों के पर नहीं आये.\n" +
            "पंकज राज मिश्रा","ना कोई राह आसान चाहिए,\n" +
            "ना ही हमें कोई पहचान चाहिए,\n" +
            "एक ही चीज माँगते है रोज भगवान से\n" +
            "अपनों के चेहरे पर हर पल प्यारी से मुस्कान चाहिए…","जहाँ सूर्य की किरण हो वहीं प्रकाश होता है,\n" +
            "और जहाँ प्रेम की भाषा हो वहीं परिवार होता है."," इस प्यारी सी दुनिया में एक छोटा सा मेरा परिवार है,\n" +
            "खुशियाँ मुझे इतनी मिलती है जैसे रोज कोई त्यौहार है."," कमजोर पड़ जाएँ एक ईट\n" +
            "तो टूट जाता है दीवार,\n" +
            "रोजगार पाने के चककर\n" +
            "छूट जाता है परिवार।","उस ग़रीब को अपने परिवार के लिए लड़ते देखा है मैंने,\n" +
            "जीवन में पहली बार डर को भी डरते हुए देखा है मैंने।"
    };
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

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
                    Toast.makeText(Family.this, "no more quotes left", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(Family.this, "no more quotes left", Toast.LENGTH_SHORT).show();
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