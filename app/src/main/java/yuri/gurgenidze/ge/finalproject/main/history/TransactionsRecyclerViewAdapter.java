package yuri.gurgenidze.ge.finalproject.main.history;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import yuri.gurgenidze.ge.finalproject.R;
import yuri.gurgenidze.ge.finalproject.model.transactions.MyOperation;

public class TransactionsRecyclerViewAdapter extends RecyclerView.Adapter<TransactionsViewHolder> {
    private List<MyOperation> data = new ArrayList<>();


    @NonNull
    @Override
    public TransactionsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.transactions_view_holder, viewGroup, false);
        return new TransactionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionsViewHolder transactionsViewHolder, int i) {
        transactionsViewHolder.setData(data.get(i));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<MyOperation> data){
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }
}
