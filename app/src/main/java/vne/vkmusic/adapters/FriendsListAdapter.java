package vne.vkmusic.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import vne.vkmusic.R;
import vne.vkmusic.model.Friend;

public class FriendsListAdapter extends ArrayAdapter<Friend>{
    private ArrayList<Friend> listData;
    private LayoutInflater layoutInflater;

    public FriendsListAdapter(Context aContext, ArrayList<Friend> listData) {
        super(aContext, 0, listData);
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }
    /* Адаптер, зроблений на основі PlayerListAdapter */
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewFriend friend;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_list_friend, null);
            friend = new ViewFriend();
            friend.friend_first_name = (TextView) convertView.findViewById(R.id.friendName);
            friend.friend_last_name = (TextView) convertView.findViewById(R.id.friendSurname);
            friend.friend_photo = (ImageView) convertView.findViewById(R.id.friendPhoto);
            convertView.setTag(friend);
        } else {
            friend = (ViewFriend) convertView.getTag();
        }
        friend.friend_first_name.setText(listData.get(position).getFirst_name());
        friend.friend_last_name.setText(listData.get(position).getLast_name());
        Picasso.with(getContext())
                .load(listData.get(position).getPhoto_url())
                .resize(100,100)
                .into(friend.friend_photo);
        return convertView;
    }

    static class ViewFriend {
        TextView friend_first_name;
        TextView friend_last_name;
        ImageView friend_photo;
    }
}
