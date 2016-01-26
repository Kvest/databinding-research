package com.kvest.databindingresearch.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kvest.databindingresearch.R;

import java.util.List;

/**
 * Created by kvest on 26.01.16.
 */
public class OnActivityResultTestFragment extends Fragment {
    private static final String ARGUMENT_ADD_NESTED = "com.kvest.databindingresearch.argument.ADD_NESTED";

    private TextView log;

    public static OnActivityResultTestFragment newInstance(boolean addNested) {
        Bundle arguments = new Bundle(1);
        arguments.putBoolean(ARGUMENT_ADD_NESTED, addNested);

        OnActivityResultTestFragment result = new OnActivityResultTestFragment();
        result.setArguments(arguments);

        return result;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.on_activity_result_test, container, false);

        init(view);

        return view;
    }

    private void init(View view) {
        log = (TextView) view.findViewById(R.id.log);
        view.findViewById(R.id.start_for_result).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 2);
            }
        });

        if (getArguments().getBoolean(ARGUMENT_ADD_NESTED)) {
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.add(R.id.fragment_container, OnActivityResultTestFragment.newInstance(false));
            transaction.commit();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        List<Fragment> fragments = getChildFragmentManager().getFragments();
        if (fragments != null) {
            for (Fragment fragment : fragments) {
                fragment.onActivityResult(requestCode, resultCode, data);
            }
        }

        log.append("onActivityResult " + resultCode + ", " + requestCode + ", "
                    + (data != null ? data.getData().toString() : "null") + "\n");
    }
}
