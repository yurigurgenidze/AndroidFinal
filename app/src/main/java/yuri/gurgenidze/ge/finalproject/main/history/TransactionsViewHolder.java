package yuri.gurgenidze.ge.finalproject.main.history;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import yuri.gurgenidze.ge.finalproject.R;
import yuri.gurgenidze.ge.finalproject.model.transactions.MyOperation;

public class TransactionsViewHolder extends RecyclerView.ViewHolder {

    TextView tvCompanyName;
    TextView tvDate;
    TextView tvEntryType;
    TextView tvAmount;

    public TransactionsViewHolder(@NonNull View itemView) {
        super(itemView);
        tvCompanyName = itemView.findViewById(R.id.transactions_view_holder_company_name);
        tvDate = itemView.findViewById(R.id.transactions_view_holder_date);
        tvEntryType = itemView.findViewById(R.id.transactions_view_holder_entry_type);
        tvAmount = itemView.findViewById(R.id.transactions_view_holder_amount);
    }

    public void setData(MyOperation myOperation){
        if (myOperation.getEntryGroupNameId() == 7){
            tvCompanyName.setText(myOperation.getMerchantName());
            tvAmount.setText("-" + myOperation.getAmount() + " ლარი");
        } else if (myOperation.getEntryGroupNameId() == 6){
            tvCompanyName.setText(myOperation.getBeneficiary());
            tvAmount.setText("-" + myOperation.getAmount() + " ლარი");
        } else if (myOperation.getEntryGroupNameId() == 9) {
            tvCompanyName.setText("ჩემი სესხი");
            tvAmount.setText("-" + myOperation.getAmount() + "ლარი");
        } else if (myOperation.getEntryGroupNameId() == 5) {
            tvCompanyName.setText(myOperation.getBeneficiary());
            tvAmount.setText("+" + myOperation.getAmount() + "ლარი");
        }


        Date transactionDate = new Date(myOperation.getDate());
        long theDay = (myOperation.getDate() / (60*60*24*1000));
        Date currentDate = new Date();
        long theCurrentDay = (currentDate.getTime() / (60*60*24*1000));

        if (theDay == theCurrentDay){
            tvDate.setText("დღეს");
        } else if (theDay == (theCurrentDay - 1)){
            tvDate.setText("გუშინ");
        } else {
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");

            tvDate.setText(df.format(transactionDate).toString());
        }

        tvEntryType.setText(myOperation.getEntryGroupName());
    }
}
