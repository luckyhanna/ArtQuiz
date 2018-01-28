package com.example.hannabotar.artquiz;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hannabotar.artquiz.domain.Question;
import com.example.hannabotar.artquiz.util.QuizUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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

        llm = new LinearLayoutManager(this); // (context)
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
