package com.ipda3.newsofraapp.ui.activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.ipda3.newsofraapp.R;
import com.ipda3.newsofraapp.helper.SharedPreferencesManger;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AskLoginActivity extends AppCompatActivity {

    @BindView(R.id.Ask_Login_logo)
    ImageView AskLoginLogo;
    @BindView(R.id.Ask_Login_Client_Btn)
    Button AskLoginClientBtn;
    @BindView(R.id.Ask_Login_Restaurant_Btn)
    Button AskLoginRestaurantBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.Ask_Login_Client_Btn, R.id.Ask_Login_Restaurant_Btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.Ask_Login_Client_Btn:
                SharedPreferencesManger.SaveData(this,"Key","Client");
                startActivity(new Intent(AskLoginActivity.this, ClientHomeActivity.class));
                break;

            case R.id.Ask_Login_Restaurant_Btn:
                SharedPreferencesManger.SaveData(this,"Key","Restaurant");
                startActivity(new Intent(AskLoginActivity.this, RestaurantHomeActivity.class));
                break;
        }
    }
}
