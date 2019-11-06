package com.android.simpleapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.simpleapplication.databinding.ActivityHomeBinding;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity {

    ActivityHomeBinding binding;
    public int numberOfLines = 2;
    ArrayList<String> textList = new ArrayList<>();
    ArrayList<EditText> editTextList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        init();

    }

    public void init() {
        binding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textList.clear();
                textList.add(binding.editDefaultField.getText().toString().trim());
                for (EditText data : editTextList) {
                    textList.add(data.getText().toString().trim());
                }

                if (textList.size() > 0) {
                    Intent intent = new Intent(HomeActivity.this, ShowDetailsActivity.class);
                    intent.putStringArrayListExtra("List", textList);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "No Data Present", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    public void addLine(View view) {
        /*Add EditText*/

        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        EditText et = new EditText(HomeActivity.this);
        p.setMargins(0, 10, 0, 10);
        et.setLayoutParams(p);
        et.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.round_border_black));
        et.setHint("Device " + numberOfLines);
        et.setId(numberOfLines + 1);
        et.setMaxLines(1);
        et.setPadding(16, 12, 16, 12);
        binding.linearLayoutDecisions.addView(et);
        editTextList.add(et);
        numberOfLines++;
    }
}
