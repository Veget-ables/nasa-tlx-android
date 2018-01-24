package com.slpl.nasa_tlx;

import android.support.annotation.IdRes;

/**
 * Created by Takaki on 2017/11/03.
 */

public enum RatingScale {
    MD(
            "知的・知覚的要求",
            "小さい",
            "大きい",
            "どの程度の知的・知覚的活動（考える，決める，計算する，記憶する，見るなど）を必要としましたか．課題はやさしかったですか難しかったですか，単純でしたか複雑でしたか，正確さが求められましたか大雑把でよかったですか．",
            "どの程度の知的・知覚的活動（考える，決める，計算する，記憶する，見るなど）を必要とするか．課題がやさしいか難しいか，単純か複雑か，正確さが求められるか大雑把でよいか．"),
    PD(
            "身体的要求",
            "小さい",
            "大きい",
            "どの程度の身体的活動（押す，引く，回す，制御する，動き回るなど）を必要としましたか．作業はラクでしたかキツかったですか，ゆっくりできましたかキビキビやらなければなりませんでしたか，休み休みできましたか働きづめでしたか．",
            "どの程度の身体的活動（押す，引く，回す，制御する，動き回るなど）を必要とするか．作業がラクかキツイか，ゆっくりできるかキビキビやらなければならないか，休み休みできるか働きづめか．"),
    TD(
            "タイムプレッシャー",
            "弱い",
            "強い",
            "仕事のペースや課題が発生する頻度のために感じる時間的切迫感はどの程度でしたか．ペースはゆっくりとして余裕があるものでしたか，それとも速くて余裕のないものでしたか．",
            "仕事のペースや課題が発生する頻度のために感じる時間的切迫感がどの程度か．ペースはゆっくりとして余裕があるものか，それとも速くて余裕のないものか．"),
    OP(
            "作業成績",
            "良い",
            "悪い",
            "作業指示者（またはあなた自信）によって設定された課題の目標をどの程度達成できたと思いますか．目標の達成に関して自分の作業成績にどの程度満足していますか．",
            "作業指示者（またはあなた自信）によって設定された課題の目標をどの程度達成できたと考えるか．目標の達成に関して自分の作業成績にどの程度満足しているか．"),
    EF(
            "努力",
            "少ない",
            "多い",
            "作業成績のレベルを達成・維持するために，精神的・身体的にどの程度いっしょうけんめいに作業しなければなりませんでしたか．",
            "作業成績のレベルを達成・維持するために，精神的・身体的にどの程度いっしょうけんめいに作業しなければならないか．"),
    FR(
            "フラストレーション",
            "低い",
            "高い",
            "作業中に，不安感，落胆，いらいら，ストレス，悩みをどの程度感じましたか（感じるとフラストレーションは高い）．あるいは逆に，安心感，満足感，充足感，楽しさ，リラックスをどの程度感じましたか（感じるとフラストレーションは低い）．",
            "作業中に，不安感，落胆，いらいら，ストレス，悩みをどの程度感じるか．あるいは逆に，安心感，満足感，充足感，楽しさ，リラックスをどの程度感じるか．");

    private
    @IdRes
    int id;
    private String name;
    private String pairDesc;
    private String evalDesc;
    private String min;
    private String max;
    private int score = 0;
    private int count = 0;

    RatingScale(String name, String min, String max, String evalDesc, String pairDesc) {
        this.name = name;
        this.min = min;
        this.max = max;
        this.evalDesc = evalDesc;
        this.pairDesc = pairDesc;
    }

    public void setId(int id) {
        this.id = id;
    }

    public
    @IdRes
    int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMin() {
        return min;
    }

    public String getMax() {
        return max;
    }

    public String getEvalDesc() {
        return evalDesc;
    }

    public String getPairDesc() {
        return pairDesc;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCount() {
        return count;
    }

    public void count() {
        count = count + 1;
    }

}
