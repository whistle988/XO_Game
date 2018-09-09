package com.example.user.xo_game;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void butClick(View view) {
        Button butSelected = (Button) view;
        int cellID = 0;

        switch (butSelected.getId()) {
            case R.id.button1:
                cellID = 1;
                break;
            case R.id.button2:
                cellID = 2;
                break;
            case R.id.button3:
                cellID = 3;
                break;
            case R.id.button4:
                cellID = 4;
                break;
            case R.id.button5:
                cellID = 5;
                break;
            case R.id.button6:
                cellID = 6;
                break;
            case R.id.button7:
                cellID = 7;
                break;
            case R.id.button8:
                cellID = 8;
                break;
            case R.id.button9:
                cellID = 9;
                break;
        }

        playGame(cellID, butSelected);
    }

    ArrayList<Integer> player1 = new ArrayList<>();
    ArrayList<Integer> player2 = new ArrayList<>();
    int activePlayer = 1;

    void playGame(int cellID, Button butSelected) {

        if (activePlayer == 1) {
            butSelected.setText("X");
            butSelected.setBackgroundColor(Color.GREEN);
            player1.add(cellID);
            activePlayer = 2;
            autoPlay();
        } else if (activePlayer == 2){
            butSelected.setText("O");
            butSelected.setBackgroundColor(Color.RED);
            player2.add(cellID);
            activePlayer = 1;
        }

        butSelected.setEnabled(false);
        checkWinner();
    }

    public void checkWinner() {
        int winner = -1;

        //строка 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1;
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2;
        }
        //строка 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1;
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2;
        }
        //строка 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1;
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2;
        }
        //столбец1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1;
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2;
        }
        //столбец2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1;
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2;
        }
        //столбец3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1;
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2;
        }

        if (winner != -1) {
            if (winner == 1) {
                Toast.makeText(this, "Player 1 win the Game", Toast.LENGTH_LONG).show();
            } else if (winner == 2){
                Toast.makeText(this, "Player 2 win the Game", Toast.LENGTH_LONG).show();
            }
        }
    }
    //игра с автоплеером
    void autoPlay() {

        //какие из ячеек пустые?
        ArrayList<Integer> emptyCells = new ArrayList<>();
        for (int cellID = 1; cellID < 10; cellID++) {
            if (!(player1.contains(cellID) || player2.contains(cellID))) {
                emptyCells.add(cellID);
            }
        }
        //рандомное заполнение ячеек
        Random r = new Random();
        int randIndex = r.nextInt(emptyCells.size() + 0) + 0;
        int cellID = emptyCells.get(randIndex);

        Button butSelect;
        switch (cellID) {
            case 1:
                butSelect = button1;
                break;
            case 2:
                butSelect = button2;
                break;
            case 3:
                butSelect = button3;
                break;
            case 4:
                butSelect = button4;
                break;
            case 5:
                butSelect = button5;
                break;
            case 6:
                butSelect = button6;
                break;
            case 7:
                butSelect = button7;
                break;
            case 8:
                butSelect = button8;
                break;
            case 9:
                butSelect = button9;
                break;
            default:
                butSelect = button1;
                break;
        }

        playGame(cellID, butSelect);
    }
}
