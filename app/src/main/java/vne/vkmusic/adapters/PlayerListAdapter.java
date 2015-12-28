package vne.vkmusic.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import vne.vkmusic.audio.Duration;
import vne.vkmusic.audio.VkAudio;
import vne.vkmusic.R;


public class PlayerListAdapter extends BaseAdapter {
    private ArrayList<VkAudio> listData;
    private LayoutInflater layoutInflater;

    public PlayerListAdapter(Context aContext, ArrayList<VkAudio> listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewAudio audio;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_list_audio, null);
            audio = new ViewAudio();
            audio.title = (TextView) convertView.findViewById(R.id.song_tittle);
            audio.artist = (TextView) convertView.findViewById(R.id.song_author);
            audio.duration = (TextView) convertView.findViewById(R.id.song_duration);
            convertView.setTag(audio);
        } else {
            audio = (ViewAudio) convertView.getTag();
        }

        audio.title.setText(listData.get(position).getTitle());
        audio.artist.setText(listData.get(position).getArtist());
        audio.duration.setText(Duration.secondsToTimer(listData.get(position).getDuration()));
        return convertView;
    }

    static class ViewAudio {
        TextView title;
        TextView artist;
        TextView duration;
    }
}
