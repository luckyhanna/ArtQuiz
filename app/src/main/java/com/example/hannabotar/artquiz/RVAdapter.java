package com.example.hannabotar.artquiz;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.hannabotar.artquiz.domain.Question;
import com.example.hannabotar.artquiz.domain.QuestionType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by hanna.botar on 1/23/2018.
 */
public class RVAdapter extends RecyclerView.Adapter<RVAdapter.QuestionViewHolder> {

    List<Question> questions;

    Map<Integer, Set<String>> radioGroupSelection = new HashMap<>();

    public RVAdapter(List<Question> questions) {
        this.questions = questions;

        for (int i = 0; i < questions.size(); i++) {
            radioGroupSelection.put(i, new HashSet<String>());
        }
        System.out.println("TODO");
        setHasStableIds(true);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onViewRecycled(QuestionViewHolder holder) {
        holder.questionImage.setImageBitmap(null);
    }

    @Override
    public QuestionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_item, parent, false);
        QuestionViewHolder qvh = new QuestionViewHolder(v);
        return qvh;
    }

    @Override
    public void onBindViewHolder(final QuestionViewHolder holder, final int position) {
        Question question = questions.get(position);
        holder.questionImage.setImageResource(question.getImageId());
        holder.questionText.setText(String.valueOf(position + 1) + ". " + question.getQuestion());

        Map<String, Boolean> answerMap = question.getAnswerMap();
        List<String> questionList = new ArrayList<>();
        questionList.addAll(answerMap.keySet());

        QuestionType type = question.getQuestionType();
        if (QuestionType.SINGLE_CHOICE.equals(type)) {
            holder.radioGroup.setVisibility(View.VISIBLE);
            holder.multipleLayout.setVisibility(View.GONE);
            holder.textLayout.setVisibility(View.GONE);

            for (int i = 0; i < questionList.size(); i++) {
                RadioButton rb = (RadioButton) holder.radioGroup.getChildAt(i);

                rb.setText(questionList.get(i));
                rb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String answerChecked = ((RadioButton) view).getText().toString();
                        Set<String> answerSet = new HashSet<>();
                        answerSet.add(answerChecked);
                        radioGroupSelection.put(position, answerSet);
                    }
                });
            }
        } else if (QuestionType.MULTIPLE_CHOICE.equals(type)) {
            holder.radioGroup.setVisibility(View.GONE);
            holder.multipleLayout.setVisibility(View.VISIBLE);
            holder.textLayout.setVisibility(View.GONE);

            for (int i = 0; i < questionList.size(); i++) {
                LinearLayout checkBoxGroup = (LinearLayout) holder.multipleLayout.getChildAt(i);
                TextView textView = (TextView) checkBoxGroup.getChildAt(1);
                final String answerText = questionList.get(i);
                textView.setText(answerText);
                CheckBox checkBox = (CheckBox) checkBoxGroup.getChildAt(0);
                checkBox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String answerChecked = answerText;
                        if (((CheckBox) view).isChecked()) {
                            radioGroupSelection.get(position).add(answerChecked);
                        } else {
                            radioGroupSelection.get(position).remove(answerChecked);
                        }
                    }
                });

            }
        } else {
            holder.radioGroup.setVisibility(View.GONE);
            holder.multipleLayout.setVisibility(View.GONE);
            holder.textLayout.setVisibility(View.VISIBLE);
        }

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

    public Map<Integer, Set<String>> getRadioGroupSelection() {
        return radioGroupSelection;
    }

    public static class QuestionViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        ImageView questionImage;
        TextView questionText;
        RadioGroup radioGroup;
        CheckBox checkBox1;
        CheckBox checkBox2;
        CheckBox checkBox3;
        LinearLayout multipleLayout;
        EditText textLayout;

        public QuestionViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            questionImage  = (ImageView) itemView.findViewById(R.id.question_image);
            questionText = (TextView) itemView.findViewById(R.id.question_text);
            radioGroup = (RadioGroup) itemView.findViewById(R.id.radio_group);
            multipleLayout = (LinearLayout) itemView.findViewById(R.id.multiple_choice);
            checkBox1 = (CheckBox) itemView.findViewById(R.id.multiple_checkbox1);
            checkBox2 = (CheckBox) itemView.findViewById(R.id.multiple_checkbox2);
            checkBox3 = (CheckBox) itemView.findViewById(R.id.multiple_checkbox3);
            textLayout = (EditText) itemView.findViewById(R.id.text_layout);
        }
    }

}
