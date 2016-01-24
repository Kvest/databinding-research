package com.kvest.databindingresearch.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kvest.databindingresearch.R;

/**
 * Created by roman on 1/18/16.
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        init();
    }

    private void init() {
        findViewById(R.id.simple_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleTestActivity.start(MainActivity.this);
            }
        });
        findViewById(R.id.recyclerview_test).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecyclerViewTestActicity.start(MainActivity.this);
            }
        });
    }
}
