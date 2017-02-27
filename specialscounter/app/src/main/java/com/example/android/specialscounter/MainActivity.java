package com.example.android.specialscounter;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    int score1 = 0;
    int score2 = 0;
    int score3 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private void checkScore() {
        if ((score1 > score2)&&(score1 > score3)) {
            View box1 = findViewById(R.id.Top_Box);
            box1.setBackgroundColor(Color.YELLOW);
            View box2 = findViewById(R.id.Middle_Box);
            box2.setBackgroundColor(Color.WHITE);
            View box3 = findViewById(R.id.Bottom_Box);
            box3.setBackgroundColor(Color.WHITE);
        }
        else if ((score2 > score1)&&(score2 > score3)) {
            View box2 = findViewById(R.id.Middle_Box);
            box2.setBackgroundColor(Color.YELLOW);
            View box1 = findViewById(R.id.Top_Box);
            box1.setBackgroundColor(Color.WHITE);
            View box3 = findViewById(R.id.Bottom_Box);
            box3.setBackgroundColor(Color.WHITE);
        }
        else if ((score3 > score1)&&(score3 > score2)) {
            View box3 = findViewById(R.id.Bottom_Box);
            box3.setBackgroundColor(Color.YELLOW);
            View box1 = findViewById(R.id.Top_Box);
            box1.setBackgroundColor(Color.WHITE);
            View box2 = findViewById(R.id.Middle_Box);
            box2.setBackgroundColor(Color.WHITE);
        }
        else if ((score1 == score2)&&(score3 < score2) && (score1 > 0)) {
            View box1 = findViewById(R.id.Top_Box);
            box1.setBackgroundColor(Color.YELLOW);
            View box2 = findViewById(R.id.Middle_Box);
            box2.setBackgroundColor(Color.YELLOW);
            View box3 = findViewById(R.id.Bottom_Box);
            box3.setBackgroundColor(Color.WHITE);
        }
        else if ((score1 == score3)&&(score2 < score3) && (score1 > 0)) {
            View box1 = findViewById(R.id.Top_Box);
            box1.setBackgroundColor(Color.YELLOW);
            View box2 = findViewById(R.id.Middle_Box);
            box2.setBackgroundColor(Color.WHITE);
            View box3 = findViewById(R.id.Bottom_Box);
            box3.setBackgroundColor(Color.YELLOW);
        } else if ((score2 == score3)&&(score1 < score3) && (score2 > 0)) {
                View box1 = findViewById(R.id.Top_Box);
                box1.setBackgroundColor(Color.WHITE);
                View box2 = findViewById(R.id.Middle_Box);
                box2.setBackgroundColor(Color.YELLOW);
                View box3 = findViewById(R.id.Bottom_Box);
                box3.setBackgroundColor(Color.YELLOW);
        }
        else if ((score1 == score2)&&(score3 == score2)) {
            View box1 = findViewById(R.id.Top_Box);
            box1.setBackgroundColor(Color.WHITE);
            View box2 = findViewById(R.id.Middle_Box);
            box2.setBackgroundColor(Color.WHITE);
            View box3 = findViewById(R.id.Bottom_Box);
            box3.setBackgroundColor(Color.WHITE);
        }
        if (score1 > 0) {
            View b = findViewById(R.id.decrement_button1);
            b.setVisibility(View.VISIBLE);
        } else {
        View b = findViewById(R.id.decrement_button1);
        b.setVisibility(View.INVISIBLE);
    }

        if (score2 > 0) {
            View b = findViewById(R.id.decrement_button2);
            b.setVisibility(View.VISIBLE);
        } else {
            View b = findViewById(R.id.decrement_button2);
            b.setVisibility(View.INVISIBLE);
        }

        if (score3 > 0) {
            View b = findViewById(R.id.decrement_button3);
            b.setVisibility(View.VISIBLE);
        }
        else {
            View b = findViewById(R.id.decrement_button3);
            b.setVisibility(View.INVISIBLE);
        }

    }


    /**
     *
     * The following methods are for the first player
     */

    // This method displays the score
    public void displayScore1(int score1) {
        TextView scoreView = (TextView) findViewById(R.id.Score1_text_view);
        scoreView.setText(String.valueOf(score1));
    }

    // Method for increasing the score
    public void Increment1(View v) {
        score1 += 1;

        checkScore();
        displayScore1(score1);

    }

    // Method for decreasing the score
    public void Decrement1(View v) {
        score1 -= 1;
        checkScore();
        displayScore1(score1);
    }


    /**
     *
     * The following methods are for the second player
     */

    // This method displays the score
    public void displayScore2(int score2) {
        TextView scoreView = (TextView) findViewById(R.id.Score2_text_view);
        scoreView.setText(String.valueOf(score2));
    }

    // Method for increasing the score
    public void Increment2(View v) {
        score2 += 1;

        checkScore();
        displayScore2(score2);
    }

    // Method for decreasing the score
    public void Decrement2(View v) {
        score2 -= 1;

        checkScore();
        displayScore2(score2);
    }

    /**
     *
     * The following methods are for the third player
     */

    // This method displays the score
    public void displayScore3(int score3) {
        TextView scoreView = (TextView) findViewById(R.id.Score3_text_view);
        scoreView.setText(String.valueOf(score3));
    }

    // Method for increasing the score
    public void Increment3(View v) {
        score3 += 1;

        checkScore();
        displayScore3(score3);
    }

    // Method for decreasing the score
    public void Decrement3(View v) {
        score3 -= 1;

        checkScore();
        displayScore3(score3);
    }

    public void ResetScores(View v) {
        score1 = 0;
        score2 = 0;
        score3 = 0;
        checkScore();
        displayScore1(score1);
        displayScore2(score2);
        displayScore3(score3);
    }

}
