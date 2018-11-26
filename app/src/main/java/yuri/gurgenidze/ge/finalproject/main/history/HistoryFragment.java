package yuri.gurgenidze.ge.finalproject.main.history;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import yuri.gurgenidze.ge.finalproject.R;
import yuri.gurgenidze.ge.finalproject.model.transactions.Transactions;
import yuri.gurgenidze.ge.finalproject.network.Api;
import yuri.gurgenidze.ge.finalproject.network.RetrofitSingleton;

public class HistoryFragment extends Fragment {
    Retrofit retrofit;
    Api api;
    RecyclerView recyclerView;
    TransactionsRecyclerViewAdapter transactionsRecyclerViewAdapter;
    TextView tvIncomeValue;
    TextView tvOutcomeValue;


    public static HistoryFragment newInstance() {

        Bundle args = new Bundle();

        HistoryFragment fragment = new HistoryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.transaction_history_fragment, container, false);

        tvIncomeValue = view.findViewById(R.id.transaction_history_fragment_income_value);
        tvOutcomeValue = view.findViewById(R.id.transaction_history_fragment_outcome_value);


        retrofit = RetrofitSingleton.getRetrofitInstance();
        api = retrofit.create(Api.class);
        recyclerView = view.findViewById(R.id.transaction_history_fragment_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        transactionsRecyclerViewAdapter = new TransactionsRecyclerViewAdapter();
        recyclerView.setAdapter(transactionsRecyclerViewAdapter);

        getMyOperations();
        return view;
    }

    private void getMyOperations(){
        api.getTransactionsInfo().enqueue(new Callback<Transactions>() {
            @Override
            public void onResponse(Call<Transactions> call, Response<Transactions> response) {

                if (response.isSuccessful()){
                    setData(response.body());
                    transactionsRecyclerViewAdapter.setData(response.body().getMyOperations());
                }
            }

            @Override
            public void onFailure(Call<Transactions> call, Throwable t) {

            }
        });
    }

    private void setData(Transactions transactions){
        tvIncomeValue.setText(transactions.getIncomeSum().toString());
        tvOutcomeValue.setText(transactions.getOutcomeSum().toString());
    }
}
