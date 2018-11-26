package yuri.gurgenidze.ge.finalproject.main.card;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;

import yuri.gurgenidze.ge.finalproject.R;
import yuri.gurgenidze.ge.finalproject.model.cards.Card;

public class CardsCardHolder extends RecyclerView.ViewHolder {

    TextView tvCardType;
    TextView tvCardNumber;
    TextView tvValidThruDate;
    TextView tvCardHolderName;
    ImageView ivCardType;
    RelativeLayout rvRelative;
    String cardType;
    Drawable background;


    public CardsCardHolder(@NonNull View itemView) {
        super(itemView);
        tvCardType = itemView.findViewById(R.id.cards_recycler_card_view_card_type);
        tvCardNumber = itemView.findViewById(R.id.cards_recycler_card_view_card_number);
        tvValidThruDate = itemView.findViewById(R.id.cards_recycler_card_view_valid_thru_date);
        tvCardHolderName = itemView.findViewById(R.id.cards_recycler_card_view_card_holder);
        ivCardType = itemView.findViewById(R.id.cards_recycler_card_view_card_image_card_type);
        rvRelative = itemView.findViewById(R.id.cards_recycler_card_view_relative_layout);
    }

    public void setData(Card card){
        cardType = card.getCardType().substring(0,4);


        if (cardType.equals("SOLO")){
            background = itemView.getContext().getResources().getDrawable(R.drawable.account_background_solo);
            rvRelative.setBackground(background);
        } else if (cardType.equals("AMEX")){
            background = itemView.getContext().getResources().getDrawable(R.drawable.account_background_amex_green);
            rvRelative.setBackground(background);
        } else {
            background = itemView.getContext().getResources().getDrawable(R.drawable.account_background_visa_gold);
            rvRelative.setBackground(background);
        }
        tvCardType.setText(cardType);
        tvCardNumber.setText(card.getAcctKey().toString());
        tvValidThruDate.setText(new SimpleDateFormat("MM/YY").format(new Date(card.getExpDate())));
        tvCardHolderName.setText(card.getCardHolder());

        if (card.getCardClass().equals("VISA")){
            ivCardType.setImageResource(R.drawable.card_icon_visa_border_single);
        } else {
            ivCardType.setImageResource(R.drawable.card_icon_amex_single);
        }
    }


}
