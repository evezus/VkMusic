package vne.vkmusic.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import vne.vkmusic.model.Friend;

/**
 * Created by volke on 28.12.2015.
 */
// TODO ДОДЕЛАТ НАДО КУРВЕ //
public class FriendsListAdapter extends BaseAdapter{
    private ArrayList<Friend> listData;
    private LayoutInflater layoutInflater;

    public FriendsListAdapter(Context aContext, ArrayList<Friend> listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
