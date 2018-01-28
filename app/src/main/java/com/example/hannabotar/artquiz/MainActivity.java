package com.example.hannabotar.artquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "quiz_user_name";

    Button startButton;
    EditText nameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*final View decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener
                (new View.OnSystemUiVisibilityChangeListener() {
                    @Override
                    public void onSystemUiVisibilityChange(int visibility) {
                        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
                        decorView.setSystemUiVisibility(uiOptions);
                    }
                });
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);*/

        setContentView(R.layout.activity_main);

        startButton = (Button) findViewById(R.id.start_button);
        startButton.setEnabled(false);
        startButton.setTextColor(getResources().getColor(R.color.colorPrimaryDarker));

        nameInput = (EditText) findViewById(R.id.name_input);
        nameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // do nothing
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // do nothing
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    startButton.setEnabled(true);
                    startButton.setTextColor(getResources().getColor(R.color.white));
                } else {
                    startButton.setEnabled(false);
                    startButton.setTextColor(getResources().getColor(R.color.colorPrimaryDarker));
                }
            }
        });
    }

    public void clickStart(View view) {
        // navigate to scrollable questions
        Log.i("MainActivity","Start button clicked");

        String name = nameInput.getText().toString();
        Intent intent = new Intent(this, ScrollableQuizRecActivity.class);
        intent.putExtra(EXTRA_NAME, name);
        startActivity(intent);
    }
}
