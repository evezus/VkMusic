package vne.vkmusic.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import vne.vkmusic.R;
import vne.vkmusic.model.Audio;
import vne.vkmusic.utils.Duration;

public class PlayerListAdapter extends ArrayAdapter<Audio> {
    private ArrayList<Audio> listData;
    private LayoutInflater layoutInflater;

    public PlayerListAdapter(Context aContext, ArrayList<Audio> listData) {
        super(aContext, 0, listData);
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewAudio audio;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_list_audio, null);
            audio = new ViewAudio();
            audio.song_tittle = (TextView) convertView.findViewById(R.id.song_tittle);
            audio.song_author = (TextView) convertView.findViewById(R.id.song_author);
            audio.song_duration = (TextView) convertView.findViewById(R.id.song_duration);
            convertView.setTag(audio);
        } else {
            audio = (ViewAudio) convertView.getTag();
        }
        audio.song_tittle.setText(listData.get(position).getTitle());
        audio.song_author.setText(listData.get(position).getArtist());
        audio.song_duration.setText(Duration.secondsToTimer(listData.get(position).getDuration()));
        return convertView;
    }

     static class ViewAudio {
         TextView song_tittle;
         TextView song_author;
         TextView song_duration;
     }
 }


