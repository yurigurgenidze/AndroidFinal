package yuri.gurgenidze.ge.finalproject.main.profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import yuri.gurgenidze.ge.finalproject.R;
import yuri.gurgenidze.ge.finalproject.model.profile.ClientInfo;
import yuri.gurgenidze.ge.finalproject.network.Api;
import yuri.gurgenidze.ge.finalproject.network.RetrofitSingleton;

public class ProfileFragment extends Fragment {


    TextView tvFirstName;
    TextView tvLastName;
    TextView tvGender;
    TextView tvBirthDay;
    TextView tvClientCategory;
    TextView tvPhoneNumber;
    TextView tvAddress;
    TextView tvEmail;


    public static ProfileFragment newInstance() {

        Bundle args = new Bundle();

        ProfileFragment fragment = new ProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_info_fragment, container, false);
        tvFirstName = view.findViewById(R.id.profile_info_fragment_first_name);
        tvLastName = view.findViewById(R.id.profile_info_fragment_surname);
        tvGender = view.findViewById(R.id.profile_info_fragment_gender);
        tvBirthDay = view.findViewById(R.id.profile_info_fragment_birthday);
        tvClientCategory = view.findViewById(R.id.profile_info_fragment_category);;
        tvPhoneNumber = view.findViewById(R.id.profile_info_fragment_phone);
        tvAddress = view.findViewById(R.id.profile_info_fragment_address);
        tvEmail = view.findViewById(R.id.profile_info_fragment_email);
        Retrofit retrofit = RetrofitSingleton.getRetrofitInstance();
        Api api = retrofit.create(Api.class);

        api.getClientInfo().enqueue(new Callback<ClientInfo>() {
            @Override
            public void onResponse(Call<ClientInfo> call, Response<ClientInfo> response) {
                if(response.isSuccessful()){
                    setData(response.body());
                }
            }

            @Override
            public void onFailure(Call<ClientInfo> call, Throwable t) {

            }
        });

        return view;
    }

    public void setData(ClientInfo clientInfo){
        tvFirstName.setText(clientInfo.getClient().getFirstName());
        tvLastName.setText(clientInfo.getClient().getLastName());
        tvGender.setText(clientInfo.getClient().getSex());
        tvBirthDay.setText(new SimpleDateFormat("dd-mm-yyyy").format(new Date(clientInfo.getClient().getBirthDate())));
        tvClientCategory.setText(clientInfo.getClient().getClientCategory());
        tvPhoneNumber.setText(clientInfo.getClientPhones().get(0).getMobile());
        tvAddress.setText(clientInfo.getClientAddresses().get(0).getStreet());
        tvEmail.setText(clientInfo.getClientMails().get(0).getMail());
    }


}
