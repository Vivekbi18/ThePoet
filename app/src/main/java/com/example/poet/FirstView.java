package com.example.poet;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FirstView extends AppCompatActivity {

    TextView textView;
    Button btnprev,btnnext,btnshare;
    int i=0;

    String[] str = { "हँसना हँसाना ये कोशिश है मेरी, सबको खुश रखना चाहत है मेरी, कोई याद करे या न करे, हर किसी को याद करना आदत है मेरी।",
            "मुस्कुराहट का कोई मोल नही होता है, रिश्तों का कोई तोल नही होता है, इंसान तो मिल जातें है हमे हर मोड़ पर, लेकिन हर कोई आप की तरह अनमोल नही होता है।\n" +
            "\n","पलके झुका कर सलाम करते हैं, हम तह दिल से आपके लिए दुआ करते हैं, कुबूल हो तो बस मुस्कुरा देना, हम ये प्यारा सा दिन आपके नाम करते हैं।",
            "खुशबू बन कर मेरी सांसो में रहना, लहू बन कर मेरी रग रग में बहना, दोस्त होते हैं रिश्तों का अनमोल गहना, इसलिये हर रोज़ सुबह हम से Good Morning कहना।\n" +
                    "\n","दिल ने कहा कोई याद कर रहा है, मैंने सोचा दिल मज़ाक कर रहा है, फिर आईं हिचकी मैंने सोचा,अपना ही कोई मैसेज का इंतज़ार कर रहा है।\n" +
            "\n","सुबह-सुबह ये कलियां सब खिल जाती हैं,\n" +
            "हमे तो तेरी यादों की गलियां मिल जाती हैं,\n" +
            "तुझसे मुलाकात तो हमारी कभी होती नही,\n" +
            "लेकिन सूरज की पहली किरण के साथ एक आस तो मिल जाती है।","ज़िन्दगी में सुबह की ताजी हवा और फूलों की महक रहे,\n" +
            "सूरज की पहली किरण और चिड़ियो की चहक रहे,\n" +
            "जब रोज सुबह आप अपनी आँखें खोलें,\n" +
            "तो उन आँखों मे बस खुशियों की झलक रहे।","रोज सुबह उठकर ऊपर वाले का नाम लिया करो,\n" +
            "रोज सुबह ताज़ा हवा का जाम लिया करो,\n" +
            "रोज सुबह अपना मोबाईल थाम लिया करो,\n" +
            "रोज सुबह मोबाइल पर हमसे प्यारा सा पैगाम लिया करो।","आप हर सुबह मुस्कुराते रहो,\n" +
            "आप हर शाम गुनगुनाते रहो,\n" +
            "हम तो खुदा से यही दुआ करते हैं,\n" +
            "आप जिससे भी मिलो आप उसकी यादों में रहो।","सुबह-सुबह आपकी यादों का साथ हो,\n" +
            "मीठी-मीठी परिंदों की आवाज़ हो,\n" +
            "आपके चेहरे पर हमेशा मुस्कुराहट हो,\n" +
            "और हमारी ज़िन्दगी में सिर्फ आपका साथ हो।"
    };
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_view);

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
                intent.putExtra(Intent.EXTRA_TEXT, str[i]);
                startActivity(intent);
            }
        });

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (i < str.length - 1) {
                    i++;
                    textView.setText(str[i]);

                    btnshare.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent();
                            intent.setAction(Intent.ACTION_SEND);
                            intent.setType("text/plain");
                            intent.putExtra(Intent.EXTRA_TEXT, str[i]);
                            startActivity(intent);
                        }
                    });

                } else {
                    Toast.makeText(FirstView.this, "no more quotes left", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnprev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (i > 0) {
                    i--;
                    textView.setText(str[i]);

                    btnshare.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent();
                            intent.setAction(Intent.ACTION_SEND);
                            intent.setType("text/plain");
                            intent.putExtra(Intent.EXTRA_TEXT, str[i]);
                            startActivity(intent);
                        }
                    });
                } else {
                    Toast.makeText(FirstView.this, "no more quotes left", Toast.LENGTH_SHORT).show();
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
