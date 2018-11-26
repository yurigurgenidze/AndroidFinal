package yuri.gurgenidze.ge.finalproject.main.assets;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import yuri.gurgenidze.ge.finalproject.R;
import yuri.gurgenidze.ge.finalproject.model.assets.Assets;
import yuri.gurgenidze.ge.finalproject.network.Api;
import yuri.gurgenidze.ge.finalproject.network.RetrofitSingleton;

public class AssetsFragment extends Fragment {

    RecyclerView rcAssets;
    AssetsRecyclerViewAdapter assetsRecyclerViewAdapter;
    Api api;
    Retrofit retrofit;
    public static AssetsFragment newInstance() {

        Bundle args = new Bundle();

        AssetsFragment fragment = new AssetsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.assets_fragment, container, false);


        rcAssets = view.findViewById(R.id.assets_fragment_recycler_view);
        assetsRecyclerViewAdapter = new AssetsRecyclerViewAdapter();
        rcAssets.setLayoutManager(new LinearLayoutManager(view.getContext()));
        rcAssets.setAdapter(assetsRecyclerViewAdapter);

        retrofit = RetrofitSingleton.getRetrofitInstance();
        api = retrofit.create(Api.class);

        api.getAssets().enqueue(new Callback<Assets>() {
            @Override
            public void onResponse(Call<Assets> call, Response<Assets> response) {
                if (response.isSuccessful()){
                    assetsRecyclerViewAdapter.setData(response.body());
                }
            }

            @Override
            public void onFailure(Call<Assets> call, Throwable t) {

            }
        });
        return view;
    }

}
