package yuri.gurgenidze.ge.finalproject.main.assets;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import yuri.gurgenidze.ge.finalproject.R;

public class AssetsRecyclerViewHolderMain extends RecyclerView.ViewHolder {
    TextView tvMainTitle;
    public AssetsRecyclerViewHolderMain(@NonNull View itemView) {
        super(itemView);
        tvMainTitle = itemView.findViewById(R.id.assets_recycler_view_holder_main_title);
    }

    public void setData(String title){
        tvMainTitle.setText(title);
    }
}
