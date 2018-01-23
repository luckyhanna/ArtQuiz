package com.example.hannabotar.artquiz;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.hannabotar.artquiz.domain.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hanna.botar on 1/23/2018.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.QuestionViewHolder> {

    List<Question> questions;

    Map<Integer, String> radioGroupSelection = new HashMap<>();

    public RVAdapter(List<Question> questions) {
        this.questions = questions;

        for (int i = 0; i < questions.size(); i++) {
            radioGroupSelection.put(i, null);
        }
    }

    @Override
    public QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_item, parent, false);
        QuestionViewHolder qvh = new QuestionViewHolder(v);
        return qvh;
    }

    @Override
    public void onBindViewHolder(final QuestionViewHolder holder, final int position) {
        holder.questionImage.setImageResource(questions.get(position).getImageId());
        holder.questionText.setText(String.valueOf(position + 1) + ". " + questions.get(position).getQuestion());
        Map<String, Boolean> answerMap = questions.get(position).getAnswerMap();
        List<String> questionList = new ArrayList<>();
        questionList.addAll(answerMap.keySet());
        for (int i = 0; i < questionList.size(); i++) {
            final RadioButton rb = (RadioButton) holder.radioGroup.getChildAt(i);
            rb.setText(questionList.get(i));
            rb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = position;
                    radioGroupSelection.put(pos, rb.getText().toString());
//                    setRadio(holder, radioGroupSelection.get(pos));
                }
            });
        }
//        setRadio(holder, radioGroupSelection.get(position));

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public Map<Integer, String> getRadioGroupSelection() {
        return radioGroupSelection;
    }

    public static class QuestionViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        ImageView questionImage;
        TextView questionText;
        RadioGroup radioGroup;

        public QuestionViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            questionImage  = (ImageView) itemView.findViewById(R.id.question_image);
            questionText = (TextView) itemView.findViewById(R.id.question_text);
            radioGroup = (RadioGroup) itemView.findViewById(R.id.radio_group);
        }
    }

}
