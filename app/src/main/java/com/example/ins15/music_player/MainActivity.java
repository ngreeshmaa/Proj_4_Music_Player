package com.example.ins15.music_player;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        final ArrayList<song_view> songs = new ArrayList<>();
        songs.add(new song_view("Closer", "The Chainsmokers", "3:14", R.drawable.chain, R.drawable.chain));
        songs.add(new song_view("All of me", "John Legend", "3:27", R.drawable.legend,R.drawable.legend));
        songs.add(new song_view("Let her go", "Passenger", "3:18", R.drawable.passenger,R.drawable.passenger));
        songs.add(new song_view("Blank space", "Taylor Swift", "3:23", R.drawable.taylor,R.drawable.taylor));
        songs.add(new song_view("Starlight", "Jai Wolf", "4:30", R.drawable.jai,R.drawable.jai));
        songs.add(new song_view("Work from home", "Fifth Harmony", "3:18", R.drawable.work,R.drawable.work));
        songs.add(new song_view("Fursat", "Arjun Kanungo", "3:56", R.drawable.fursat,R.drawable.fursat));
        songs.add(new song_view("Blue Eyes", "Yo Yo Honey Singh", "2:14", R.drawable.blue,R.drawable.blue));
        songs.add(new song_view("Something Like This", "The Chainsmokers", "4:07", R.drawable.chain,R.drawable.chain));
        songs.add(new song_view("Raabta", "Arijit Singh", "3:24", R.drawable.rabaata,R.drawable.rabaata));
        songs.add(new song_view("Ilahi", "Mohit Chauhan", "3:04", R.drawable.ilahi,R.drawable.ilahi));
        songs.add(new song_view("The breakup song", "Arijit Singh", "4:24", R.drawable.breakup,R.drawable.breakup));
        song_adapter adapter = new song_adapter(this, songs);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, NowPlayingActivity.class);
                intent.putExtra("songObject", songs.get(position));
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("list",songs);
                String position_of_item = "" + position;
                bundle.putString("position",position_of_item);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


    }
}

