package com.example.hannabotar.artquiz;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.CheckBox;
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

    Map<Integer, Set<String>> answerSelection = new HashMap<>();

    public RVAdapter(List<Question> questions) {
        this.questions = questions;

        for (int i = 0; i < questions.size(); i++) {
            answerSelection.put(i, new HashSet<String>());
        }
        setHasStableIds(true);
    }

    public RVAdapter(List<Question> questions, Map<Integer, Set<String>> answerSelection) {
        this.questions = questions;
        this.answerSelection = answerSelection;
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
            holder.textLayout.setFocusable(false);

            for (int i = 0; i < questionList.size(); i++) {
                RadioButton rb = (RadioButton) holder.radioGroup.getChildAt(i);

                rb.setText(questionList.get(i));
                rb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String answerChecked = ((RadioButton) view).getText().toString();
                        Set<String> answerSet = new HashSet<>();
                        answerSet.add(answerChecked);
                        answerSelection.put(position, answerSet);
                    }
                });
            }
        } else if (QuestionType.MULTIPLE_CHOICE.equals(type)) {
            holder.radioGroup.setVisibility(View.GONE);
            holder.multipleLayout.setVisibility(View.VISIBLE);
            holder.textLayout.setVisibility(View.GONE);
            holder.textLayout.setFocusable(false);

            for (int i = 0; i < questionList.size(); i++) {
                LinearLayout checkBoxGroup = (LinearLayout) holder.multipleLayout.getChildAt(i);
                TextView textView = (TextView) checkBoxGroup.getChildAt(1);
                final String answerText = questionList.get(i);
                textView.setText(answerText);
                final CheckBox checkBox = (CheckBox) checkBoxGroup.getChildAt(0);
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        checkBox.setChecked(!checkBox.isChecked());
                        checkBox.callOnClick();
                    }
                });
                checkBox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String answerChecked = answerText;
                        if (((CheckBox) view).isChecked()) {
                            answerSelection.get(position).add(answerChecked);
                        } else {
                            answerSelection.get(position).remove(answerChecked);
                        }
                    }
                });

            }
        } else {
            holder.radioGroup.setVisibility(View.GONE);
            holder.multipleLayout.setVisibility(View.GONE);
            holder.textLayout.setVisibility(View.VISIBLE);
            holder.textLayout.setImeOptions(EditorInfo.IME_ACTION_DONE);
            holder.textLayout.addTextChangedListener(new TextWatcher() {
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
                    String answerChecked = editable.toString();
                    Set<String> answerSet = new HashSet<>();
                    answerSet.add(answerChecked);
                    answerSelection.put(position, answerSet);
                }
            });
        }
        restoreState(type, position, questionList.size(), holder);

    }

    private void restoreState(QuestionType questionType, int position,int numberOfAnswers, QuestionViewHolder holder) {
        Set<String> currentSelectionSet = answerSelection.get(position);
        if (currentSelectionSet == null || currentSelectionSet.size() == 0) {
            return;
        }
        if (QuestionType.SINGLE_CHOICE.equals(questionType)) {
            for (String s : currentSelectionSet) {
                for (int i = 0; i < numberOfAnswers; i++) {
                    RadioButton rb = (RadioButton) holder.radioGroup.getChildAt(i);
                    if (rb.getText().toString().equals(s)) {
                        rb.setChecked(true);
                        break;
                    }
                }
            }
        } else if (QuestionType.MULTIPLE_CHOICE.equals(questionType)) {

            for (String s : currentSelectionSet) {
                for (int i = 0; i < numberOfAnswers; i++) {
                    LinearLayout checkBoxGroup = (LinearLayout) holder.multipleLayout.getChildAt(i);
                    TextView textView = (TextView) checkBoxGroup.getChildAt(1);
                    if (textView.getText().toString().equals(s)) {
                        CheckBox checkBox = (CheckBox) checkBoxGroup.getChildAt(0);
                        checkBox.setChecked(true);
                    }
                }
            }
        } else {
            for (String s : currentSelectionSet) {
                holder.textLayout.setText(s);
            }
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

    public Map<Integer, Set<String>> getAnswerSelection() {
        return answerSelection;
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
