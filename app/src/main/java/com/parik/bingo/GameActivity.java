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
    private List<CharSequence> celektedNambers = new ArrayList<CharSequence>();
    private List<Button> buttons = new ArrayList<Button>();
    private String MYLOG_TEG = "My Log";
    private int childCount;
    private int buttonNaber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_game);

//        binding.baton1.setOnClickListener(v -> {
//            celektedNambers.add(binding.baton1.getText());
//            //TODO add baton selector and chehg coor en cre selektor
//        });

        addBatonsToButtons();
        addButtonsValies();

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
    public void addButtonsValies() {
        while (buttonNaber < buttons.size()) {
            Button button = buttons.get(buttonNaber);
            Log.d(MYLOG_TEG, "buttonId = " + button);

            button.setOnClickListener(v -> {
                celektedNambers.add(buttons.get(buttonNaber -1).getText());
                button.setTextColor(getResources().getColor(R.color.colorAccent));

            });

            buttonNaber++;

        }


    }
}
