package com.slpl.nasa_tlx.wwl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.slpl.nasa_tlx.CsvUtil;
import com.slpl.nasa_tlx.R;
import com.slpl.nasa_tlx.RatingScale;

public class PairCombinationActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvNameLeft;
    private TextView tvNameRight;
    private TextView tvDescLeft;
    private TextView tvDescRight;
    private RadioButton rbScaleLeft;
    private RadioButton rbScaleRight;
    private RadioGroup rgScale;
    private ProgressBar progressBar;
    private Button btNext;

    private CombinationDirector mCombination = new CombinationDirector();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pair_combination);

        setupViews();
        nextPair(); // 一対比較を開始
    }

    private void setupViews() {
        rbScaleLeft = (RadioButton) findViewById(R.id.rbScaleLeft);
        rbScaleRight = (RadioButton) findViewById(R.id.rbScaleRight);
        tvNameLeft = (TextView) findViewById(R.id.tvNameLeft);
        tvNameRight = (TextView) findViewById(R.id.tvNameRight);
        tvDescLeft = (TextView) findViewById(R.id.tvDescribeLeft);
        tvDescRight = ((TextView) findViewById(R.id.tvDescribeRight));
        rgScale = (RadioGroup) findViewById(R.id.rgScale);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btNext = (Button) findViewById(R.id.btNext);
        btNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (rbScaleLeft.isChecked()) {
            mCombination.countLeft();
        } else if (rbScaleRight.isChecked()) {
            mCombination.countRight();
        } else {
            Toast.makeText(getBaseContext(), "項目を選択して下さい．", Toast.LENGTH_SHORT).show();
            return;
        }
        nextPair();
    }

    private void nextPair() {
        rgScale.clearCheck();
        progressBar.setProgress(mCombination.getIndex());
        try {
            mCombination.next();
            setPairViews();
        } catch (IndexOutOfBoundsException e) {
            rbScaleLeft.setClickable(false);
            rbScaleRight.setClickable(false);
            btNext.setClickable(false);
            Toast.makeText(this, "アンケートは終了です．ご協力ありがとうございます．", Toast.LENGTH_LONG).show();
            save();
        }
    }

    private void setPairViews() {
        CombinationDirector.ScalePair pair = mCombination.getCurrentPair();
        RatingScale scaleLeft = pair.getLeftScale();
        RatingScale scaleRight = pair.getRightScale();
        rbScaleLeft.setText(scaleLeft.getName());
        tvNameLeft.setText(scaleLeft.getName());
        tvDescLeft.setText(scaleLeft.getPairDesc());
        rbScaleRight.setText(scaleRight.getName());
        tvNameRight.setText(scaleRight.getName());
        tvDescRight.setText(scaleRight.getPairDesc());
    }

    private void save() {
        CsvUtil.save(this, "下位尺度", "素点", "重み係数（選択回数）", "評点");
        CsvUtil.saveScales(this);
    }

    @Override
    public void onBackPressed() {
    }
}
