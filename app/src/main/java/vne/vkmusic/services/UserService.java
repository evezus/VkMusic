package vne.vkmusic.services;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.VKParameters;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.model.VKApiUser;

import org.json.JSONException;

/**
 * Created by evezus on 28.12.2015.
 */
public class UserService {

    public static final String USER_LINK = "http://vk.com/id";
    private static final String USER_ID = "user_id";
    private static final String USER_FIRST_NAME = "user_first_name";
    private static final String USER_SECOND_NAME = "user_second_name";
    private static final String USER_PHOTO_URL = "user_photo_url";


    public void getCurrentUser(final Listener listener) {
        VKApiUser user = new VKApiUser();
        VKApi.users().get(VKParameters.from(VKApiConst.FIELDS, "photo_100")).executeWithListener(new VKRequest.VKRequestListener() {
            @Override
            public void onComplete(VKResponse response) {
                super.onComplete(response);
                try {
                    VKApiUser user = new VKApiUser().parse(response.json.getJSONArray("response").getJSONObject(0));
                    listener.onFinished(user);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public interface Listener {
        void onFinished(VKApiUser user);
    }
}
