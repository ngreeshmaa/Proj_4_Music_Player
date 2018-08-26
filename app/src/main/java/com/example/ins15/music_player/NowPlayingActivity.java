package com.example.ins15.music_player;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class NowPlayingActivity extends AppCompatActivity {
    private int m = 0, current_postion;
    private ArrayList<song_view> list_songs = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.now_playing);
        Intent intent = getIntent();
        song_view exampleItem = intent.getParcelableExtra("songObject");
        int imageRes = exampleItem.getSongImage();
        int background = exampleItem.getbackgroundImage();
        String songName = exampleItem.getSongName();
        String songArtist = exampleItem.getSongAtrist();
        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        current_postion = Integer.parseInt(bundle.getString("position"));
        list_songs = bundle.getParcelableArrayList("list");

        final ImageView imageAlbum = findViewById(R.id.center_image);
        imageAlbum.setImageResource(imageRes);

        ImageView backButton = findViewById(R.id.back_to_list);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NowPlayingActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });

        final RelativeLayout backgroundImage = findViewById(R.id.background);
        backgroundImage.setBackgroundResource(background);

        final TextView songNamee = findViewById(R.id.song_namee);
        songNamee.setText(songName);

        final TextView artistName = findViewById(R.id.artist_name_playing);
        artistName.setText(songArtist);

        ImageView next = findViewById(R.id.btn_next);
        final ImageView pause_play = findViewById(R.id.play_pause_btn);
        ImageView previous = findViewById(R.id.btn_previous);
        pause_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (m == 1) {
                    pause_play.setImageResource(R.drawable.pause_image);
                    m = 0;
                } else if (m == 0) {
                    pause_play.setImageResource(R.drawable.play);
                    m = 1;
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (current_postion == list_songs.size() - 1) {
                    Toast.makeText(NowPlayingActivity.this, "End of list", Toast.LENGTH_SHORT).show();
                } else {
                    current_postion += 1;
                    artistName.setText(list_songs.get(current_postion).getSongAtrist());
                    songNamee.setText(list_songs.get(current_postion).getSongName());
                    imageAlbum.setImageResource(list_songs.get(current_postion).getSongImage());
                    backgroundImage.setBackgroundResource(list_songs.get(current_postion).getbackgroundImage());

                }
            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (current_postion == 0) {
                    Toast.makeText(getApplicationContext(), "First Song", Toast.LENGTH_SHORT).show();
                } else {
                    current_postion -= 1;
                    artistName.setText(list_songs.get(current_postion).getSongAtrist());
                    songNamee.setText(list_songs.get(current_postion).getSongName());
                    imageAlbum.setImageResource(list_songs.get(current_postion).getSongImage());
                    backgroundImage.setBackgroundResource(list_songs.get(current_postion).getbackgroundImage());
                }
            }
        });
    }
}