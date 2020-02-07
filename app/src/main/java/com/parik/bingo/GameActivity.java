package com.parik.bingo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.parik.bingo.databinding.ActivityGameBinding;

import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity {

    private ActivityGameBinding binding;
    private List<CharSequence> celektedNambers = new ArrayList<CharSequence>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_game);

        binding.baton1.setOnClickListener(v -> {
          celektedNambers.add(binding.baton1.getText());
           //TODO add baton selector and chehg coor en cre selektor
        });


    }
}
