package com.parik.bingo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;

import com.parik.bingo.databinding.ActivityGameBinding;

import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity {

    private ActivityGameBinding binding;
    private List<CharSequence> celektedNambers = new ArrayList<CharSequence>();
    private List<Integer> buttons = new ArrayList<Integer>();
    private String MYLOG_TEG = "My Log";
    private int childCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_game);

//        binding.baton1.setOnClickListener(v -> {
//            celektedNambers.add(binding.baton1.getText());
//            //TODO add baton selector and chehg coor en cre selektor
//        });

        addBatonsToButtons();


    }

    private void addBatonsToButtons() {
        childCount = binding.card.getChildCount() -1;
        while (childCount >=0) {
            buttons.add(binding.card.getChildAt(childCount).getId());
            childCount--;
        }

        for (int i : buttons) {
            Log.d(MYLOG_TEG, " buttonId = " + i);

        }

        Log.d(MYLOG_TEG, " buttons = " + buttons.size());

    }


}
