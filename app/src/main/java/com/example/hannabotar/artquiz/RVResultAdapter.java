package com.example.hannabotar.artquiz;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hannabotar.artquiz.domain.Result;

import java.util.List;

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
        holder.explanationText.setText(String.valueOf(position + 1) + ". " + result.getQuestion().getExplanation());
        holder.answer.setText(result.getAnswer());

        if (result.isCorrect()) {
            holder.answer.setCompoundDrawablesWithIntrinsicBounds(R.drawable.correct, 0, 0, 0);
        } else {
            holder.answer.setCompoundDrawablesWithIntrinsicBounds(R.drawable.incorrect, 0, 0, 0);
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
        TextView answer;

        public ResultViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.result_cv);
            resultImage  = (ImageView) itemView.findViewById(R.id.result_image);
            explanationText = (TextView) itemView.findViewById(R.id.explanation_text);
            answer = (TextView) itemView.findViewById(R.id.answer);
        }
    }

}