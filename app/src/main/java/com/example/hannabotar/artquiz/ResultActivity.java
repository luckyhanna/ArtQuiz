package com.example.hannabotar.artquiz;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.hannabotar.artquiz.domain.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultActivity extends AppCompatActivity {

    ProgressBar progressBar;

    String userName;

    List<Question> questionList;

    Map<Integer, String> answerMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        userName = intent.getStringExtra(MainActivity.EXTRA_NAME);
        questionList = (ArrayList) intent.getSerializableExtra(ScrollableQuizRecActivity.QUESTION_LIST);
        answerMap = (HashMap) intent.getSerializableExtra(ScrollableQuizRecActivity.ANSWER_MAP);


    }

    // TODO
    private void showProgress() {
        progressBar.setVisibility(View.VISIBLE);

    }

    // TODO
    private void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

}
