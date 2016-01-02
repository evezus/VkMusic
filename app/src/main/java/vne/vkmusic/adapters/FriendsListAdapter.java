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
import vne.vkmusic.model.Audio;
import vne.vkmusic.model.Friend;

public class FriendsListAdapter extends ArrayAdapter<Friend> {
    private LayoutInflater layoutInflater;

    public FriendsListAdapter(Context aContext, ArrayList<Friend> listData) {
        super(aContext, 0, listData);
        layoutInflater = LayoutInflater.from(aContext);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        ViewFriend viewFriend;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_list_friend, parent, false);
            viewFriend = new ViewFriend();
            viewFriend.all_friend = (TextView) convertView.findViewById(R.id.fullName);
            viewFriend.friend_photo = (ImageView) convertView.findViewById(R.id.friendPhoto);
            convertView.setTag(viewFriend);
        } else {
            viewFriend = (ViewFriend) convertView.getTag();
        }

        Friend friend = (Friend) getItem(position);
        viewFriend.all_friend
                .setText(String.format("%s %s", friend.getFirst_name(), friend.getLast_name()));
        Picasso.with(getContext())
                .load(friend.getPhoto_url())
                .resize(100, 100)
                .into(viewFriend.friend_photo);
        return convertView;
    }

    static class ViewFriend {
        TextView all_friend;
        ImageView friend_photo;
    }
}
