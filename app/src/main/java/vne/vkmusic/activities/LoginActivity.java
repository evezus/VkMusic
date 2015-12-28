package vne.vkmusic.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import com.vk.sdk.VKScope;
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
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VKSdk.login(LoginActivity.this, VKScope.AUDIO);
            }
        });


    }
}
