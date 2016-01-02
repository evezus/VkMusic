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
    private LayoutInflater layoutInflater;

    public PlayerListAdapter(Context aContext, ArrayList<Audio> listData) {
        super(aContext, 0, listData);
        layoutInflater = LayoutInflater.from(aContext);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewAudio viewAudio;

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.item_list_audio, null);
            viewAudio = new ViewAudio();
            viewAudio.song_tittle = (TextView) convertView.findViewById(R.id.song_tittle);
            viewAudio.song_author = (TextView) convertView.findViewById(R.id.song_author);
            viewAudio.song_duration = (TextView) convertView.findViewById(R.id.song_duration);
            convertView.setTag(viewAudio);
        } else {
            viewAudio = (ViewAudio) convertView.getTag();
        }

        Audio audio = (Audio) getItem(position);
        viewAudio.song_tittle.setText(audio.getTitle());
        viewAudio.song_author.setText(audio.getArtist());
        viewAudio.song_duration.setText(Duration.secondsToTimer(audio.getDuration()));

        return convertView;
    }

     static class ViewAudio {
         TextView song_tittle;
         TextView song_author;
         TextView song_duration;
     }
 }


