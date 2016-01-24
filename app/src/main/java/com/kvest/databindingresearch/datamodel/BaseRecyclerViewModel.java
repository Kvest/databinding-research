package com.kvest.databindingresearch.datamodel;

/**
 * Created by kvest on 24.01.16.
 */
public abstract class BaseRecyclerViewModel {
    public final int layout;

    public BaseRecyclerViewModel(int layout) {
        this.layout = layout;
    }
}