package com.parik.bingo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.parik.bingo.databinding.ActivityGameBinding;

import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity {

    private ActivityGameBinding binding;
    private List<Integer> celektedNambers = new ArrayList<Integer>();
    private List<Button> buttons = new ArrayList<Button>();
    private String MYLOG_TEG = "My Log";
    private int childCount;
    private int buttonNaber;
    private int startCapital = 10000;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_game);


        addBatonsToButtons();
        addButtonsCardValies();

        binding.exitButton.setOnClickListener(v -> {
            finish();
        });
        binding.newGameButton.setOnClickListener(v -> {
            celektedNambers.clear();
            binding.manyTextView2.setText(getText(R.string.many) + String.valueOf(startCapital));
        });

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
            button.setOnClickListener(v -> {
                celektedNambers.add((Integer) buttons.get(buttonNaber - 1).getTag());
                button.setTextColor(getResources().getColor(R.color.colorAccent));

            });

            buttonNaber++;

        }


    }
}
