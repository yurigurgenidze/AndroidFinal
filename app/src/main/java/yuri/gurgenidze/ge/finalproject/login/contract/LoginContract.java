package yuri.gurgenidze.ge.finalproject.login.contract;

import yuri.gurgenidze.ge.finalproject.model.login.Login;

public interface LoginContract  {



    interface View {
        void onLoginSuccess(Login login);
        //es ar gvchirdeba mara iyos mainc
        void onLoginFailure();

        void invalidInfo(String message);

    }

    interface Presenter {
        void getInformation(String username, String password);

    }

    interface LoginIntractor{
        interface OnFinishedListener{
            void onFinish(Login login);
            void onFailure(Throwable t);
        }

        void getInformation(OnFinishedListener onFinishedListener, String username, String password);
    }



}
