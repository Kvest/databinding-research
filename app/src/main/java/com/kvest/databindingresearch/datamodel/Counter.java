package com.kvest.databindingresearch.datamodel;

import android.databinding.ObservableInt;
import android.view.View;

/**
 * Created by kvest on 18.01.16.
 */
public class Counter {
    public final ObservableInt count = new ObservableInt();

    public void increase(View view) {
        count.set(count.get() + 1);
    }

    public void decrease(View view) {
        count.set(count.get() - 1);
    }
}
