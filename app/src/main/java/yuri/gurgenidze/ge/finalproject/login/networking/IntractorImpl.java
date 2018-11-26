package yuri.gurgenidze.ge.finalproject.login.networking;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import yuri.gurgenidze.ge.finalproject.login.contract.LoginContract;
import yuri.gurgenidze.ge.finalproject.model.login.Login;
import yuri.gurgenidze.ge.finalproject.network.Api;
import yuri.gurgenidze.ge.finalproject.network.RetrofitSingleton;

public class IntractorImpl implements LoginContract.LoginIntractor {
    @Override
    public void getInformation(final OnFinishedListener onFinishedListener, String username, String password) {
        Api api = RetrofitSingleton.getRetrofitInstance().create(Api.class);
        api.getLoginInfo(username, password).enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if(response.isSuccessful()){
                    onFinishedListener.onFinish(response.body());
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                    onFinishedListener.onFailure(t);
            }
        });
    }
}
