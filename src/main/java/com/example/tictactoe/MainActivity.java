package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int scoreX = 0;
    int scoreO = 0;
    int round = 1;

    boolean cross = true;

    public boolean won(String pl) {
        String one = (String) ((Button) findViewById(R.id.first)).getText();
        String two = (String) ((Button) findViewById(R.id.second)).getText();
        String three = (String) ((Button) findViewById(R.id.third)).getText();
        String four = (String) ((Button) findViewById(R.id.fourth)).getText();
        String five = (String) ((Button) findViewById(R.id.fifth)).getText();
        String six = (String) ((Button) findViewById(R.id.sixth)).getText();
        String seven = (String) ((Button) findViewById(R.id.seventh)).getText();
        String eight = (String) ((Button) findViewById(R.id.eighth)).getText();
        String nine = (String) ((Button) findViewById(R.id.ninth)).getText();
        System.out.println(one + two + three + four + five + six + seven + eight + nine);
        boolean toRet = ((one == pl) && (two == pl) && (three == pl)) || ((four == pl) && (five == pl) && (six == pl)) || ((seven == pl) && (eight == pl) && (nine == pl)) || ((one == pl) && (four == pl) && (seven == pl)) || ((two == pl) && (five == pl) && (eight == pl)) || ((three == pl) && (six == pl) && (nine == pl)) || ((one == pl) && (five == pl) && (nine == pl)) || ((three == pl) && (five == pl) && (seven == pl));
        return toRet;

    }


    public void play(View view) {
        Button curr = (Button) view;
        String a = (String) curr.getText();
        System.out.println(a);
        if (a != "X" && a != "O") {

            if (cross) {

                curr.setText("X");
                cross = false;

                if (won("X")) {

                    System.out.println("X wins");
                    ((TextView) findViewById(R.id.result)).setText("X wins Round "+String.valueOf(round));

                    scoreX++;
                    round++;
                    displayScore();
                    resetGame(curr);

                }

            } else {
                curr.setText("O");
                cross = true;
                if (won("O")) {
                    ((TextView) findViewById(R.id.result)).setText("O wins Round "+String.valueOf(round));
                    System.out.println("O wins");
                    scoreO++;
                    round++;
                    displayScore();

                    resetGame(curr);
                }

            }
        }
    }


    public void resetGame(View view) {
        ((Button) findViewById(R.id.first)).setText("-");
        ((Button) findViewById(R.id.second)).setText("-");
        ((Button) findViewById(R.id.third)).setText("-");
        ((Button) findViewById(R.id.fourth)).setText("-");
        ((Button) findViewById(R.id.fifth)).setText("-");
        ((Button) findViewById(R.id.sixth)).setText("-");
        ((Button) findViewById(R.id.seventh)).setText("-");
        ((Button) findViewById(R.id.eighth)).setText("-");
        ((Button) findViewById(R.id.ninth)).setText("-");
    }

    public void reset(View view) {
        scoreO=0;
        scoreX=0;
        displayScore();
        round = 1;
        ((TextView) findViewById(R.id.result)).setText("Let's Play");


    }
    public void displayScore(){
        TextView ScoreA = (TextView)findViewById(R.id.Xscore);
        TextView ScoreB = (TextView)findViewById(R.id.Oscore);
        ScoreA.setText(String.valueOf(scoreX));
        ScoreB.setText(String.valueOf(scoreO));

    }
}