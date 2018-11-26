package yuri.gurgenidze.ge.finalproject.login.presenter;

import android.content.Context;

import yuri.gurgenidze.ge.finalproject.login.contract.LoginContract;
import yuri.gurgenidze.ge.finalproject.model.login.Login;
import yuri.gurgenidze.ge.finalproject.network.RetrofitSingleton;

public class PresenterImpl implements LoginContract.Presenter {

    private LoginContract.LoginIntractor intractor;
    private LoginContract.View view;
    private Context context;

    public PresenterImpl(LoginContract.LoginIntractor intractor, LoginContract.View view, Context context) {
        this.intractor = intractor;
        this.view = view;
    }

    @Override
    public void getInformation(String username, String password) {
        String error;

        if(username.length() < 3 && password.length() < 3){
            error = "მომხმარებლის სახელი და პაროლი არ უნდა იყოს 3 სიმბოლოზე ნაკლები";
            view.invalidInfo(error);
            return;
        } else if (username.length() < 3){
            error = "მომხმარებლის სახელი არ უნდა იყოს 3 სიმბოლოზე ნაკლები";
            view.invalidInfo(error);
            return;
        }
        else if (password.length() < 3){
            error = "პაროლი არ უნდა იყოს 3 სიმბოლოზე ნაკლები";
            view.invalidInfo(error);
            return;

        }



        LoginContract.LoginIntractor.OnFinishedListener listener = new LoginContract.LoginIntractor.OnFinishedListener() {
            @Override
            public void onFinish(Login login) {
                if (view != null){
                    RetrofitSingleton.setInterceptor(login.getSessionId());
                    view.onLoginSuccess(login);
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }

        };
        intractor.getInformation(listener, username, password);
    }

}
