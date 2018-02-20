package com.example.hannabotar.artquiz;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hannabotar.artquiz.domain.Question;
import com.example.hannabotar.artquiz.domain.Result;
import com.example.hannabotar.artquiz.util.QuizUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ScrollableQuizRecActivity extends AppCompatActivity {

    public static final String QUESTION_LIST = "question_list";
    public static final String ANSWER_MAP = "answer_map";
    public static final String PARCELABLE = "parcelable";
    public static final String QUESTIONS = "questions";
    public static final String SELECTION = "selection";

    String userName;

    RVAdapter adapter;

    RecyclerView rv;

    LinearLayoutManager llm;

    List<Question> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_scrollable_quiz_rec);

        Intent intent = getIntent();
        userName = intent.getStringExtra(MainActivity.EXTRA_NAME);

        TextView textView = (TextView) findViewById(R.id.questions_title);
        textView.setText( getString(R.string.have_fun, userName));

        rv = (RecyclerView)findViewById(R.id.rv);
        rv.setHasFixedSize(true);

        llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        if (savedInstanceState != null) {
            Parcelable parcelable = savedInstanceState.getParcelable(PARCELABLE);
            rv.getLayoutManager().onRestoreInstanceState(parcelable);

            questionList = (List<Question>) savedInstanceState.getSerializable(QUESTIONS);
            HashMap<Integer, Set<String>> selection = (HashMap<Integer, Set<String>>) savedInstanceState.getSerializable(SELECTION);

            adapter = new RVAdapter(questionList, selection);
            rv.setAdapter(adapter);
        } else {
            questionList = QuizUtil.initMockData();

            adapter = new RVAdapter(questionList);
            rv.setAdapter(adapter);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Parcelable parcelable = rv.getLayoutManager().onSaveInstanceState();
        outState.putParcelable(PARCELABLE, parcelable);

        ArrayList<Question> questions = (ArrayList<Question>) adapter.getQuestions();
        outState.putSerializable(QUESTIONS, questions);
        HashMap<Integer, Set<String>> selection = (HashMap<Integer, Set<String>>) adapter.getAnswerSelection();
        outState.putSerializable(SELECTION, selection);

        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View view = getCurrentFocus();
        if (view != null && (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) && view instanceof EditText && !view.getClass().getName().startsWith("android.webkit.")) {
            int scrcoords[] = new int[2];
            view.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + view.getLeft() - scrcoords[0];
            float y = ev.getRawY() + view.getTop() - scrcoords[1];
            if (x < view.getLeft() || x > view.getRight() || y < view.getTop() || y > view.getBottom())
                ((InputMethodManager)this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow((this.getWindow().getDecorView().getApplicationWindowToken()), 0);
        }
        return super.dispatchTouchEvent(ev);
    }

    public void finishQuiz(View view) {

        RecyclerView recView = (RecyclerView) findViewById(R.id.rv);
        RVAdapter rvAdapter = (RVAdapter) recView.getAdapter();
        Map<Integer, Set<String>> answerSelection = rvAdapter.getAnswerSelection();
        System.out.println(answerSelection);

        List<Integer> unanswered = getUnansweredQuestions(answerSelection);
        if (unanswered.size() > 0) {
            String message = unanswered.toString();
            message = message.substring(1, message.length() - 1);
            Toast incompleteToast = Toast.makeText(this, getString(R.string.incomplete, message), Toast.LENGTH_LONG);
            incompleteToast.show();
            return;
        }

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
            if (correctAnswers.equals(answerSelection.get(i))) {
                result.setCorrect(true);
            } else {
                result.setCorrect(false);
            }
            for (String checkedAnswer : answerSelection.get(i)) {
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
        }
        Toast resultToast = Toast.makeText(this, getString(R.string.score, correct, questionList.size()), Toast.LENGTH_LONG);
        resultToast.show();

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(MainActivity.EXTRA_NAME, userName);
        intent.putExtra(QUESTION_LIST, (ArrayList) questionList);
        intent.putExtra(ANSWER_MAP, (HashMap) answerSelection);

        startActivity(intent);

    }

    private List<Integer> getUnansweredQuestions(Map<Integer, Set<String>> answerSelection) {
        List<Integer> unanswered = new ArrayList<>();
        for (Integer questionNo : answerSelection.keySet()) {
            if (answerSelection.get(questionNo) == null || answerSelection.get(questionNo).size() == 0) {
                unanswered.add(questionNo + 1);
            }
        }
        Collections.sort(unanswered);
        return unanswered;
    }

    @Override
    public void onBackPressed() {
        ConfirmationDialogFragment dialog = new ConfirmationDialogFragment();
        dialog.show(getSupportFragmentManager(), "ConfirmationDialogFragment");
    }

    public void goBack() {
        super.onBackPressed();
    }
}
