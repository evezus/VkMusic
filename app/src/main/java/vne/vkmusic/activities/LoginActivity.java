package vne.vkmusic.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

import vne.vkmusic.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (VKSdk.isLoggedIn()) {
            startActivity(new Intent(this, ListActivity.class));
            finish();
        }

        setContentView(R.layout.activity_login);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VKSdk.login(LoginActivity.this, VKScope.AUDIO);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                startActivity(new Intent(LoginActivity.this, ListActivity.class));
                finish();
            }

            @Override
            public void onError(VKError error) {

            }

        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
