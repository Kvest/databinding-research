package com.kvest.databindingresearch.datamodel;

import com.kvest.databindingresearch.R;

/**
 * Created by kvest on 24.01.16.
 */
public class TitleModel extends BaseRecyclerViewModel {
    public final String title;

    public TitleModel(String title) {
        super(R.layout.title_view);
        this.title = title;
    }
}
