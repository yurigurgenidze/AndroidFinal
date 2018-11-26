package yuri.gurgenidze.ge.finalproject.main.card;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import yuri.gurgenidze.ge.finalproject.R;
import yuri.gurgenidze.ge.finalproject.model.cards.Card;

public class CardsRecyclerViewAdapter extends RecyclerView.Adapter<CardsCardHolder> {
    private List<Card> data = new ArrayList<>();

    @NonNull
    @Override
    public CardsCardHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cards_recycler_card_view, viewGroup, false);
        return new CardsCardHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardsCardHolder cardsCardHolder, int i) {

        cardsCardHolder.setData(data.get(i));

    }

    @Override
    public int getItemCount() {
        Log.d("haime", data.size() + "");
        return data.size();
    }

    public void setData(List<Card> cards){
        data.clear();

        data.addAll(cards);

        notifyDataSetChanged();

    }
}
