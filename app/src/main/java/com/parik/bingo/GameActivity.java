package com.parik.bingo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.parik.bingo.databinding.ActivityGameBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private ActivityGameBinding binding;
    private List<Button> celektedButons = new ArrayList<>();
    private List<Button> buttons = new ArrayList<Button>();
    private String MYLOG_TEG = "My Log";
    private int childCount;
    private int buttonNaber;
    private int startCapital = 10000;
    private int capital = 0;
    private int ratesCaunter;
    private int maxRates = 5;
    private int bet = 10;
    private int bets;
    private int win;
    private int lose;
    private Random random = new Random();


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_game);

        startGame();

        binding.exitButton.setOnClickListener(v -> {
            finish();
        });
        binding.newGameButton.setOnClickListener(v -> {
            startGame();
        });

        binding.startButton.setOnClickListener(v -> {
//TODO
            buttonNaber= buttons.size();
            naberseGenerate();

            //TODO cheak bets and generate nambers
        });

        binding.resetCardButton.setOnClickListener(v -> {
                        resetCard();
        });

    }

    private void naberseGenerate() {
        binding.ball1TextView.setText(String.valueOf(random.nextInt(buttonNaber)));
        buttonNaber --;

        binding.ball2TextView.setText(String.valueOf(random.nextInt(buttonNaber)));
        buttonNaber --;

        binding.ball3TextView.setText(String.valueOf(random.nextInt(buttonNaber)));
        buttonNaber --;

        binding.ball4TextView.setText(String.valueOf(random.nextInt(buttonNaber)));
        buttonNaber --;

        binding.ball5TextView.setText(String.valueOf(random.nextInt(buttonNaber)));
        buttonNaber --;

    }

    private void resetCard() {
        capital = capital + bets;
        ratesCaunter = 0;
        bets = 0;
        setTextToMany(capital);
        resetBatons();
    }

    private void startGame() {
        binding.ball1TextView.setText("");
        binding.ball2TextView.setText("");
        binding.ball3TextView.setText("");
        binding.ball4TextView.setText("");
        binding.ball5TextView.setText("");

        celektedButons.clear();
        ratesCaunter = 0;
        bets = 0;
        capital = startCapital;
        resetBatons();
        setTextToMany(startCapital);
    }

    private void resetBatons() {
        buttons.clear();
        buttonNaber = 0;
        addBatonsToButtons();
        addButtonsCardValies();
    }

    @SuppressLint("SetTextI18n")
    private void setTextToMany(int capital) {
        binding.manyTextView2.setText(getText(R.string.many) + String.valueOf(capital));
    }

    private void addBatonsToButtons() {
        Button button;
        childCount = binding.card.getChildCount() - 1;
        while (childCount >= 0) {

            int id = binding.card.getChildAt(childCount).getId();
            button = findViewById(id);

            buttons.add(button);
            childCount--;
        }

        for (Button i : buttons) {
            Log.d(MYLOG_TEG, " buttonId = " + i);

        }

        Log.d(MYLOG_TEG, " buttons = " + buttons.size());

    }


    @SuppressLint("ResourceAsColor")
    public void addButtonsCardValies() {
        while (buttonNaber < buttons.size()) {
            Button button = buttons.get(buttonNaber);
            Log.d(MYLOG_TEG, "buttonId = " + button);
            button.setTag(buttonNaber);
            button.setTextColor(getResources().getColor(R.color.bleak_color));
            button.setOnClickListener(v -> {
                if (ratesCaunter < maxRates && capital >= bet) {
                    maceRate(button);
                } else if (capital < bet) {
                    showMessage(getString(R.string.you_dont_have_enough_money_to_bet));
                } else {
                    showMessage(getString(R.string.you_have_passed_the_maximum_number_of_bets));

                }


            });

            buttonNaber++;

        }


    }

    private void maceRate(Button button) {
        capital = capital - bet;
        bets = bets + bet;
        ratesCaunter++;
        setTextToMany(capital);

        celektedButons.add(button);
        button.setTextColor(getResources().getColor(R.color.colorPrimary));
    }

    public void showMessage(String message) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setCancelable(false)
                .setNegativeButton("ОК",
                        (dialog, id) -> {
                            dialog.cancel();
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
