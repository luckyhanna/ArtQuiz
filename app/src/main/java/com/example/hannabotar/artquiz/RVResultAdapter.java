package com.example.hannabotar.artquiz;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hannabotar.artquiz.domain.Result;

import java.util.List;
import java.util.Map;

/**
 * Created by hanna.botar on 1/23/2018.
 */

public class RVResultAdapter extends RecyclerView.Adapter<RVResultAdapter.ResultViewHolder> {

    List<Result> results;

    public RVResultAdapter(List<Result> results) {
        this.results = results;
    }

    @Override
    public ResultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.result_item, parent, false);
        ResultViewHolder rvh = new ResultViewHolder(v);

        return rvh;
    }

    @Override
    public void onBindViewHolder(ResultViewHolder holder, int position) {
        Result result = results.get(position);
        holder.resultImage.setImageResource(result.getQuestion().getImageId());
        Spanned explanation = Html.fromHtml(String.valueOf(position + 1) + ". " + result.getQuestion().getExplanation());
        holder.explanationText.setText(explanation);
        if (result.isCorrect()){
            holder.explanationText.setTextColor(holder.explanationText.getResources().getColor(R.color.black));
        } else {
            holder.explanationText.setTextColor(holder.explanationText.getResources().getColor(R.color.colorAccent));
        }
        Map<String, Boolean> answerMap = result.getAnswerMap();
        int i = 0;
        holder.answer1.setVisibility(View.GONE);
        holder.answer2.setVisibility(View.GONE);
        holder.answer3.setVisibility(View.GONE);
        for (String answer : answerMap.keySet()) {
            TextView answerTextView = (TextView) holder.answerLayout.getChildAt(i);
            answerTextView.setText(answer);
            if (answerMap.get(answer)) {
                answerTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.correct_35, 0, 0, 0);
            } else {
                answerTextView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.incorrect_35, 0, 0, 0);
            }
            answerTextView.setVisibility(View.VISIBLE);
            i++;
        }
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public static class ResultViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        ImageView resultImage;
        TextView explanationText;
        LinearLayout answerLayout;
        TextView answer1;
        TextView answer2;
        TextView answer3;

        public ResultViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.result_cv);
            resultImage  = (ImageView) itemView.findViewById(R.id.result_image);
            explanationText = (TextView) itemView.findViewById(R.id.explanation_text);
            answer1 = (TextView) itemView.findViewById(R.id.answer1);
            answer2 = (TextView) itemView.findViewById(R.id.answer2);
            answer3 = (TextView) itemView.findViewById(R.id.answer3);
            answerLayout = (LinearLayout) itemView.findViewById(R.id.answer_layout);
        };
    }

}