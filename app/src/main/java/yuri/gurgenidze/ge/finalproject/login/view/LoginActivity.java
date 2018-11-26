package yuri.gurgenidze.ge.finalproject.login.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tapadoo.alerter.Alerter;

import java.util.Calendar;

import yuri.gurgenidze.ge.finalproject.R;
import yuri.gurgenidze.ge.finalproject.login.contract.LoginContract;
import yuri.gurgenidze.ge.finalproject.model.login.Login;
import yuri.gurgenidze.ge.finalproject.login.networking.IntractorImpl;
import yuri.gurgenidze.ge.finalproject.login.presenter.PresenterImpl;
import yuri.gurgenidze.ge.finalproject.main.MainActivity;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    EditText etUsername;
    EditText etPassword;
    Button buttonLogin;

    private LoginContract.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.activity_login_edit_text_username);

        etPassword = findViewById(R.id.activity_login_edit_text_password);

        buttonLogin = findViewById(R.id.activity_login_button_login);

        presenter = new PresenterImpl(new IntractorImpl(), this, this);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, etUsername.getText() + " " + etPassword.getText(), Toast.LENGTH_SHORT).show();
                presenter.getInformation(etUsername.getText().toString(), etPassword.getText().toString());

            }
        });


    }


    @Override
    public void onLoginSuccess(Login login) {
        Toast.makeText(this, login.getSessionId(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        Calendar rightNow = Calendar.getInstance();
        int hour = rightNow.get(Calendar.HOUR_OF_DAY);

        if ((hour >= 18) || (hour >= 0 && hour <= 5)){

            intent.putExtra("bg", "night");

        } else {

            intent.putExtra("bg", "day");

        }
        startActivity(intent);
    }

    @Override
    public void onLoginFailure() {

    }

    @Override
    public void invalidInfo(String message) {

        Alerter.create(this)
                .setText(message)
                .setBackgroundColorRes(R.color.red)
                .show();
       // Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
