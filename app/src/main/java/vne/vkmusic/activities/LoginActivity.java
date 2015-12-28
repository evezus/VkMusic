package vne.vkmusic.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.vk.sdk.VKSdk;

import vne.vkmusic.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(VKSdk.isLoggedIn()) {
            new Intent(this, ListActivity.class);
            finish();
        }

        setContentView(R.layout.activity_login);

    }
}
