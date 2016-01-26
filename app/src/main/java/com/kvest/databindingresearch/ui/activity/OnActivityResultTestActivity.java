package com.kvest.databindingresearch.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.kvest.databindingresearch.R;
import com.kvest.databindingresearch.ui.fragment.OnActivityResultTestFragment;

/**
 * Created by kvest on 26.01.16.
 */
public class OnActivityResultTestActivity extends AppCompatActivity {
    public static void start(Context context) {
        Intent intent = new Intent(context, OnActivityResultTestActivity.class);
        context.startActivity(intent);
    }

    private TextView log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.on_activity_result_test);

        init();

        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.fragment_container, OnActivityResultTestFragment.newInstance(true));
            transaction.commit();
        }
    }

    private void init() {
        log = (TextView) findViewById(R.id.log);
        findViewById(R.id.start_for_result).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select Picture"), 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        log.append("onActivityResult " + resultCode + ", " + requestCode + ", "
                   + (data != null ? data.getData().toString() : "null") + "\n");
    }
}
