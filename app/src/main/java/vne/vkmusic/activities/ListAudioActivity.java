package vne.vkmusic.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.squareup.picasso.Picasso;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.model.VKApiUser;

import java.util.ArrayList;

import vne.vkmusic.R;
import vne.vkmusic.adapters.FriendsListAdapter;
import vne.vkmusic.adapters.PlayerListAdapter;
import vne.vkmusic.model.Audio;
import vne.vkmusic.model.Friend;
import vne.vkmusic.services.UserService;
import vne.vkmusic.utils.DownloadImageTask;

public class ListAudioActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_list);
        ViewFlipper viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Next screen comes in from left.
        viewFlipper.setInAnimation(this, R.anim.slide_in_from_left);
        // Current screen goes out from right.
        viewFlipper.setOutAnimation(this, R.anim.slide_out_to_right);

        new UserService().getCurrentUser(new UserService.Listener() {
            @Override
            public void onFinished(VKApiUser user) {
                Picasso.with(ListAudioActivity.this)
                        .load(user.photo_100)
                        .resize(100, 100)
                        .into((ImageView)findViewById(R.id.userImg));
                ((TextView) findViewById(R.id.userName)).setText(user.first_name + " " + user.last_name);
                ((TextView) findViewById(R.id.userLink)).setText(UserService.USER_LINK + String.valueOf(user.id));
            }
        });


        VKRequest request = VKApi.audio().get();
        request.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                ((ListView) findViewById(R.id.listAudioView))
                        .setAdapter(new PlayerListAdapter(ListAudioActivity.this, (ArrayList) Audio.parseJson(response)));
            }
        });



        VKRequest request_friends = new VKRequest("friends.get", VKParameters.from(VKApiConst.FIELDS, "id, first_name, last_name, photo_100",
                VKParameters.from(VKApiConst.NAME_CASE, "nom")));

        request_friends.executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                ((ListView) findViewById(R.id.listFriendsView))
                        .setAdapter(new FriendsListAdapter(ListAudioActivity.this, (ArrayList) Friend.parseJson(response)));
            }
        });
        //(ListView) findViewById(R.id.listAudioView).setOnTouchListener();
    }

    @Override
    public void onBackPressed() {
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (viewFlipper.getDisplayedChild() == 1) {
            viewFlipper.setDisplayedChild(0);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        ViewFlipper flipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        int id = item.getItemId();

        switch (id) {
            case R.id.side_my_audio:
                this.setTitle("My music");
                flipper.setDisplayedChild(0);
                break;
            case R.id.side_friends:
                this.setTitle("Friends");
                flipper.setDisplayedChild(1);
                break;
            case R.id.side_cached:
                this.setTitle("My music");
                break;
            case R.id.side_favorite:
                this.setTitle("Favorite");
                break;
            case R.id.side_settings:
                this.setTitle("Settings");
                break;
            case R.id.side_logout:
                VKSdk.logout();
            case R.id.side_exit:
                finish();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}



