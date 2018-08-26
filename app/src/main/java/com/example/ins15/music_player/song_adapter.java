package com.example.ins15.music_player;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class song_adapter extends ArrayAdapter {

    public song_adapter(Activity context, ArrayList<song_view> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_vew_structure, parent, false);
        }

        song_view currentSong = (song_view) getItem(position);

        TextView songName = (TextView) listItemView.findViewById(R.id.song_name);
        songName.setText(currentSong.getSongName());

        TextView songArtist = (TextView) listItemView.findViewById(R.id.artist);
        songArtist.setText(currentSong.getSongAtrist());

        TextView songLength = (TextView) listItemView.findViewById(R.id.song_length);
        songLength.setText(currentSong.getSongLength());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.music_image);
        imageView.setImageResource(currentSong.getSongImage());

        return listItemView;
    }
}