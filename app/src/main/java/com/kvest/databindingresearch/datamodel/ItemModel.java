package com.kvest.databindingresearch.datamodel;

import com.kvest.databindingresearch.R;

/**
 * Created by kvest on 24.01.16.
 */
public class ItemModel extends BaseRecyclerViewModel {
    public final String title;
    public final String url;

    public ItemModel(String title, String url) {
        super(R.layout.item_view);
        this.title = title;
        this.url = url;
    }
}
