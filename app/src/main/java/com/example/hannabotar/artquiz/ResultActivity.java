package com.example.hannabotar.artquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.hannabotar.artquiz.domain.Question;
import com.example.hannabotar.artquiz.domain.Result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ResultActivity extends AppCompatActivity {

    String userName;

    RecyclerView rv;

    List<Question> questionList;

    Map<Integer, Set<String>> answerMap;

    TextView scoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        userName = intent.getStringExtra(MainActivity.EXTRA_NAME);
        questionList = (ArrayList) intent.getSerializableExtra(ScrollableQuizRecActivity.QUESTION_LIST);
        answerMap = (HashMap) intent.getSerializableExtra(ScrollableQuizRecActivity.ANSWER_MAP);

        scoreTextView = (TextView) findViewById(R.id.score_text);

        loadResults();
    }

    private void loadResults() {
        List<Result> resultList = new ArrayList<>();

        int correct = 0;
        for (int i = 0; i < questionList.size(); i++) {
            Result result = new Result();
            Question question = questionList.get(i);
            result.setQuestion(question);

            Set<String> correctAnswers = new HashSet<>();
            Map<String, Boolean> resultAnswers = new HashMap<>();
            for (String answer : question.getAnswerMap().keySet()) {
                if (question.getAnswerMap().get(answer)) {
                    correctAnswers.add(answer);
                }
            }
            if (correctAnswers.equals(answerMap.get(i))) {
                result.setCorrect(true);
            } else {
                result.setCorrect(false);
            }
            for (String checkedAnswer : answerMap.get(i)) {
                if (question.getAnswerMap().get(checkedAnswer) == null){
                    resultAnswers.put(checkedAnswer, false);
                } else {
                    resultAnswers.put(checkedAnswer, (question.getAnswerMap().get(checkedAnswer)));
                }
            }
            result.setAnswerMap(resultAnswers);

            if (result.isCorrect()) {
                correct += 1;
            }
            resultList.add(result);
        }

        scoreTextView.setText(getString(R.string.score, correct, questionList.size()));
        TextView resultsTitle = (TextView) findViewById(R.id.results_title);
        resultsTitle.setText(getString(R.string.congrats, userName));

        rv = (RecyclerView)findViewById(R.id.result_rv);
        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        RVResultAdapter rvResultAdapter = new RVResultAdapter(resultList);
        rv.setAdapter(rvResultAdapter);
    }

    @Override
    public void onBackPressed() {
        goHome(null);
    }

    public void goHome(View view) {
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }
}
