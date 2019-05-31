package com.example.task332;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.os.ConfigurationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Spinner langSelector;
    private Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        langSelector = findViewById(R.id.langSelector);
        btnOk = findViewById(R.id.btnOk);
        btnOk.setOnClickListener(btnOkListener);
        initSpinner();
    }

    private void initSpinner() {
        ArrayAdapter<CharSequence> adapterLanguage = ArrayAdapter.createFromResource(this,
                R.array.language, android.R.layout.simple_spinner_item);
        adapterLanguage.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        langSelector.setAdapter(adapterLanguage);
        langSelector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                String[] language = getResources().getStringArray(R.array.language);
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
    }

    private final View.OnClickListener btnOkListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String select = langSelector.getSelectedItem().toString();
            switch (select) {
                case "Русский":
                    Locale localeRu = new Locale("ru");
                    Configuration configRu = new Configuration();
                    configRu.setLocale(localeRu);
                    getResources().updateConfiguration(configRu, getBaseContext().getResources().getDisplayMetrics());
                    recreate();
                    break;
                case "English":
                    Locale localeEn = new Locale("en");
                    Configuration configEn = new Configuration();
                    configEn.setLocale(localeEn);
                    getResources().updateConfiguration(configEn, getBaseContext().getResources().getDisplayMetrics());
                    recreate();
                    break;
            }
        }
    };
}
