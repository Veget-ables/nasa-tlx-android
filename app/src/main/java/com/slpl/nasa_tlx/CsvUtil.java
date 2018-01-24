package com.slpl.nasa_tlx;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import static android.content.Context.MODE_APPEND;

/**
 * Created by Takaki on 2017/11/04.
 */

public class CsvUtil {
    private static final String FILE_NAME = "RatingScale.csv";
    private static final String ENCODE = "Shift_JIS";

    private static PrintWriter setupWriter(Context context) throws UnsupportedEncodingException, FileNotFoundException {
        OutputStream out = context.openFileOutput(FILE_NAME, MODE_APPEND);
        return new PrintWriter(new OutputStreamWriter(out, ENCODE));
    }

    public static void save(Context context, Object... params) {
        try {
            PrintWriter w = setupWriter(context);
            for (Object p : params) {
                w.append(p + ",");
            }
            w.append("\n");
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveScales(Context context) {
        try {
            PrintWriter w = setupWriter(context);
            for (RatingScale scale : RatingScale.values()) {
                int count = scale.getCount();
                int score = scale.getScore();
                w.append(scale.getName() + ",");
                w.append(score + ",");
                w.append(count + ",");
                w.append(score * count + ",");
                w.append("\n");
            }
            w.append("\n");
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
