package com.kvest.databindingresearch.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.kvest.databindingresearch.R;
import com.kvest.databindingresearch.databinding.SimpleTestActivityBinding;
import com.kvest.databindingresearch.datamodel.Counter;
import com.kvest.databindingresearch.datamodel.User;
import com.kvest.databindingresearch.datamodel.UserHandler;

/**
 * Created by roman on 1/18/16.
 */
public class SimpleTestActivity extends AppCompatActivity {
    public static void start(Context context) {
        Intent intent = new Intent(context, SimpleTestActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SimpleTestActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.simple_test_activity);
        User user = new User("Roman", "Bielokon");
        UserHandler userHandler = new UserHandler(user, (EditText)findViewById(R.id.new_first_name),
                                                        (EditText)findViewById(R.id.new_last_name));
        binding.setUserHandler(userHandler);
        binding.setUser(user);
        binding.setCounter(new Counter());
    }
}
