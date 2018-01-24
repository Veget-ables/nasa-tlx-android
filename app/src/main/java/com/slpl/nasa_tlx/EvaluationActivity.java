package com.slpl.nasa_tlx;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.slpl.nasa_tlx.wwl.PairCombinationActivity;

/**
 * Created by Takaki on 2017/11/04.
 */

public class EvaluationActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvName;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluation);
        setupViews();
    }

    private void setupViews() {
        tvName = (TextView) findViewById(R.id.etName);
        findViewById(R.id.btNext).setOnClickListener(this);

        LinearLayout container = (LinearLayout) findViewById(R.id.llContainer);
        for (RatingScale scale : RatingScale.values()) {
            View v = LayoutInflater.from(this).inflate(R.layout.scale_item, null);
            ((TextView) v.findViewById(R.id.tvScaleName)).setText(scale.getName());
            ((TextView) v.findViewById(R.id.tvScaleDesc)).setText(scale.getEvalDesc());
            ((TextView) v.findViewById(R.id.tvScaleMin)).setText(scale.getMin());
            ((TextView) v.findViewById(R.id.tvScaleMax)).setText(scale.getMax());
            @IdRes int id = View.generateViewId();
            scale.setId(id);
            v.findViewById(R.id.sbScore).setId(id);
            container.addView(v);
        }
    }

    @Override
    public void onClick(View v) {
        if (isSave()) {
            CsvUtil.save(getBaseContext(), tvName.getText().toString());
            for (RatingScale scale : RatingScale.values()) {
                SeekBar bar = (SeekBar) findViewById(scale.getId());
                scale.setScore(bar.getProgress());
            }
            nextStage();
        }
    }

    private boolean isSave() {
        if (tvName.getText().toString().isEmpty()) {
            Toast.makeText(getBaseContext(), "名前を入力して下さい．", Toast.LENGTH_LONG).show();
            return false;
        } else {
            return true;
        }
    }

    private void nextStage() {
        Intent intent = new Intent(EvaluationActivity.this, PairCombinationActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
    }
}
