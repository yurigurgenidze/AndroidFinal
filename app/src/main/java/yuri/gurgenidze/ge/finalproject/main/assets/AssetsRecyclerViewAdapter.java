package yuri.gurgenidze.ge.finalproject.main.assets;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import yuri.gurgenidze.ge.finalproject.R;
import yuri.gurgenidze.ge.finalproject.model.assets.AssetInterface;
import yuri.gurgenidze.ge.finalproject.model.assets.Assets;

public class AssetsRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Object> data = new ArrayList<>();

    public static final int CELL_MAIN = 0;
    public static final int CELL_INFO = 1;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if ( i == CELL_MAIN ){
            return new AssetsRecyclerViewHolderMain(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.assets_recycler_view_holder_main, viewGroup, false));
        } else {
            return new AssetsRecyclerViewHolderInfo(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.assets_recycler_view_holder_info, viewGroup, false));
        }
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        if (data.get(i) instanceof String){
            ((AssetsRecyclerViewHolderMain) viewHolder).setData(data.get(i).toString());
        } else {
            ((AssetsRecyclerViewHolderInfo) viewHolder).setData((AssetInterface)data.get(i));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (data.get(position) instanceof String){
            return CELL_MAIN;
        } else {
            return CELL_INFO;
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(Assets newData) {
        data.clear();
        if (newData.getAssets().size() > 0){
            data.add("ანგარიშები");
            data.addAll(newData.getAssets());
        }

        if (newData.getAvailableAmounts().size() > 0){
            data.add("თანხები");
            data.addAll(newData.getAvailableAmounts());
        }

        if (newData.getLiabilities().size() > 0){
            data.add("ვალდებულებები");
            data.addAll(newData.getLiabilities());
        }

        if (newData.getPoints().size() > 0){
            data.add("ქულები");
            data.addAll(newData.getPoints());
        }

        notifyDataSetChanged();
    }
}
