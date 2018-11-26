package yuri.gurgenidze.ge.finalproject.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import yuri.gurgenidze.ge.finalproject.model.assets.Assets;
import yuri.gurgenidze.ge.finalproject.model.cards.Card;
import yuri.gurgenidze.ge.finalproject.model.login.Login;
import yuri.gurgenidze.ge.finalproject.model.profile.ClientInfo;
import yuri.gurgenidze.ge.finalproject.model.transactions.Transactions;

public interface Api {

    @GET("api/Clients/Login/{username}/{password}")
    Call<Login> getLoginInfo(@Path("username") String username, @Path("password") String password);

    @GET("api/Clients/ClientInfo/")
    Call<ClientInfo> getClientInfo();

    @GET("api/Products/Transactions/")
    Call<Transactions> getTransactionsInfo();

    @GET("api/Products/AssetsAndLiabilities/")
    Call<Assets> getAssets();

    @GET("api/Products/Cards/")
    Call<List<Card>> getCards();

}
