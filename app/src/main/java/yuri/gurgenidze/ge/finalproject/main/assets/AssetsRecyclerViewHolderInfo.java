package yuri.gurgenidze.ge.finalproject.main.assets;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import yuri.gurgenidze.ge.finalproject.R;
import yuri.gurgenidze.ge.finalproject.model.assets.AssetInterface;

public class AssetsRecyclerViewHolderInfo extends RecyclerView.ViewHolder {

    TextView tvEntryType;
    TextView tvAmount;


    public AssetsRecyclerViewHolderInfo(@NonNull View itemView) {
        super(itemView);
        tvEntryType = itemView.findViewById(R.id.assets_recycler_view_holder_entry_type);
        tvAmount = itemView.findViewById(R.id.assets_recycler_view_holder_amount);
    }


    public void setData(AssetInterface asset){
        tvEntryType.setText(asset.getProdName());
        tvAmount.setText(asset.getAmmount());
    }
}
