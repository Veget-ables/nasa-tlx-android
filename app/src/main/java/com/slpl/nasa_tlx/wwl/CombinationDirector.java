package com.slpl.nasa_tlx.wwl;

import com.slpl.nasa_tlx.RatingScale;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Takaki on 2017/11/03.
 */

class CombinationDirector {
    private int mIndex = 0;
    private CombinationDirector.ScalePair mCurrentPair;
    private List<ScalePair> mPairs = new ArrayList<ScalePair>() {
        {
            add(new ScalePair(RatingScale.MD, RatingScale.PD));
            add(new ScalePair(RatingScale.MD, RatingScale.TD));
            add(new ScalePair(RatingScale.MD, RatingScale.OP));
            add(new ScalePair(RatingScale.MD, RatingScale.EF));
            add(new ScalePair(RatingScale.MD, RatingScale.FR));
            add(new ScalePair(RatingScale.PD, RatingScale.TD));
            add(new ScalePair(RatingScale.PD, RatingScale.OP));
            add(new ScalePair(RatingScale.PD, RatingScale.EF));
            add(new ScalePair(RatingScale.PD, RatingScale.FR));
            add(new ScalePair(RatingScale.TD, RatingScale.OP));
            add(new ScalePair(RatingScale.TD, RatingScale.EF));
            add(new ScalePair(RatingScale.TD, RatingScale.FR));
            add(new ScalePair(RatingScale.OP, RatingScale.EF));
            add(new ScalePair(RatingScale.OP, RatingScale.FR));
            add(new ScalePair(RatingScale.EF, RatingScale.FR));
        }
    };

    CombinationDirector() {
        Collections.shuffle(mPairs); // インスタンス生成時にペアをランダムに並べかえる
    }

    void next() {
        mCurrentPair = mPairs.get(mIndex);
        mIndex++;
    }

    void countLeft() {
        mCurrentPair.getLeftScale().count();
    }

    void countRight() {
        mCurrentPair.getRightScale().count();
    }

    ScalePair getCurrentPair() {
        return mCurrentPair;
    }

    int getIndex() {
        return mIndex;
    }

    class ScalePair {
        private final RatingScale leftScale;
        private final RatingScale rightScale;

        private ScalePair(RatingScale leftScale, RatingScale rightScale) {
            this.leftScale = leftScale;
            this.rightScale = rightScale;
        }

        RatingScale getRightScale() {
            return rightScale;
        }

        RatingScale getLeftScale() {
            return leftScale;
        }
    }
}
