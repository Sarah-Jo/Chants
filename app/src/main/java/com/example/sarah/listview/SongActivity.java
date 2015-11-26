package com.example.sarah.listview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SongActivity extends AppCompatActivity {

    TextView lyricView;
    ListItem listItem;
    TextView songName;
    TextView songNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        Intent intent = getIntent();
        listItem = (ListItem)intent.getSerializableExtra("sarah");
        getSupportActionBar().setTitle(listItem.getName());

        songNumber =(TextView)findViewById(R.id.numero);
        songNumber.setText("" + listItem.getNumber());
        songName = (TextView)findViewById(R.id.name1);
        songName.setText(listItem.getName());
        lyricView = (TextView)findViewById(R.id.song1);
        lyricView.setText(listItem.getLyrics());
           }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_song, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
