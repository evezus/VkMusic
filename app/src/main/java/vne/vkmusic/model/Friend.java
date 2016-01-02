package vne.vkmusic.model;

import android.util.Log;

import com.vk.sdk.api.VKResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Friend {

    //Friend`s ID (identification code)
    private int id;

    // friend`s first name
    private String first_name;

    //...last name
    private String last_name;

    private Boolean online;


    //...and URL to his profile photo
    private String photo_url;

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public static List<Friend> parseJson(VKResponse response) {
        ArrayList<Friend> list = new ArrayList<>();
        try {
            JSONArray arr = response.json.getJSONObject("response").getJSONArray("items");
            for (int i = 0; i < arr.length(); i++) {
                Friend friend = new Friend();
                JSONObject json = arr.getJSONObject(i);

                friend.setId(json.optInt("id"));
                friend.setFirst_name(json.optString("first_name"));
                friend.setLast_name(json.optString("last_name"));
                friend.setPhoto_url(json.optString("photo_100"));
                friend.setOnline(json.optBoolean("online"));
                list.add(friend);
            }
        } catch (JSONException e) {
            Log.d("JSONException", e.toString());
        }
        return list;
    }
}
