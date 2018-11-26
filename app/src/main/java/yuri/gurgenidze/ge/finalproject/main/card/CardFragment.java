package yuri.gurgenidze.ge.finalproject.main.card;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import yuri.gurgenidze.ge.finalproject.R;
import yuri.gurgenidze.ge.finalproject.network.Api;
import yuri.gurgenidze.ge.finalproject.network.RetrofitSingleton;
import yuri.gurgenidze.ge.finalproject.model.cards.Card;

public class CardFragment extends Fragment {
    Retrofit retrofit;
    Api api;
    RecyclerView recyclerView;
    CardsRecyclerViewAdapter cardsRecyclerViewAdapter;

    public static CardFragment newInstance() {

        Bundle args = new Bundle();

        CardFragment fragment = new CardFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cards_fragment, container, false);
        recyclerView = view.findViewById(R.id.cards_fragment_recycler_view);
        retrofit = RetrofitSingleton.getRetrofitInstance();
        api = retrofit.create(Api.class);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        cardsRecyclerViewAdapter = new CardsRecyclerViewAdapter();
        recyclerView.setAdapter(cardsRecyclerViewAdapter);
        getCards();
        return view;
    }

    private void getCards(){
        api.getCards().enqueue(new Callback<List<Card>>() {
            @Override
            public void onResponse(Call<List<Card>> call, Response<List<Card>> response) {
                if (response.isSuccessful()){
                    Log.d("haime", "issaxsesful");
                    cardsRecyclerViewAdapter.setData(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Card>> call, Throwable t) {

            }
        });
    }
}
