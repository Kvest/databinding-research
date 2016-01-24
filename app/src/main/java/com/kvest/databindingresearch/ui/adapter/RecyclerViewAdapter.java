package com.kvest.databindingresearch.ui.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kvest.databindingresearch.BR;
import com.kvest.databindingresearch.R;
import com.kvest.databindingresearch.datamodel.BaseRecyclerViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by kvest on 24.01.16.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<BaseRecyclerViewModel> dataset;

    public RecyclerViewAdapter(BaseRecyclerViewModel[] dataset) {
        this.dataset = new ArrayList<>(Arrays.asList(dataset));
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);

        switch (viewType) {
            case R.layout.item_view:
                return new ItemViewHolder(v);
            case R.layout.title_view:
                return new TitleViewHolder(v);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(dataset.get(position));
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    @Override
    public int getItemViewType(int position) {
        return dataset.get(position).layout;
    }

    public void onItemDismiss(int position) {
        dataset.remove(position);
        notifyItemRemoved(position);
    }

    public boolean onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(dataset, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(dataset, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    public static abstract class ViewHolder extends RecyclerView.ViewHolder {
        protected final ViewDataBinding viewDataBinding;

        public ViewHolder(View itemView) {
            super(itemView);

            viewDataBinding = DataBindingUtil.bind(itemView);
        }

        public abstract void bind(BaseRecyclerViewModel model);
    }

    public static class TitleViewHolder extends ViewHolder {
        public TitleViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bind(BaseRecyclerViewModel model) {
            viewDataBinding.setVariable(BR.titleModel, model);
            viewDataBinding.executePendingBindings();
        }
    }

    public static class ItemViewHolder extends ViewHolder {
        public ItemViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bind(BaseRecyclerViewModel model) {
            viewDataBinding.setVariable(BR.itemModel, model);
            viewDataBinding.executePendingBindings();
        }
    }
}
