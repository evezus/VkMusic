package vne.vkmusic.services;

import android.content.Context;

import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKRequest;
import com.vk.sdk.api.VKResponse;
import com.vk.sdk.api.model.VKApiUser;

import java.util.List;

import vne.vkmusic.model.Audio;


public class AudioService extends VKRequest.VKRequestListener {

    public List<Audio> list;

    public void getAudio() {
        VKRequest request = VKApi.users().get();
        request.executeWithListener(this);
    }

    @Override
    public void onComplete(VKResponse response) {
        super.onComplete(response);
        list = Audio.parseJson(response);
    }
}
