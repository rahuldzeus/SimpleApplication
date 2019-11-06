package com.android.simpleapplication;

import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.android.simpleapplication.databinding.ActivityShowDetailsBinding;

import java.util.ArrayList;
import java.util.List;

public class ShowDetailsActivity extends BaseActivity {

    ActivityShowDetailsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_show_details);
        init();
    }

    public void init() {
        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Intent intent = getIntent();
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(ShowDetailsActivity.this, android.R.layout.simple_list_item_1, intent.getStringArrayListExtra("List"));
        binding.listDetail.setAdapter(adapter);

    }
}
