package revanth.language;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static revanth.language.R.*;
import static revanth.language.R.raw.family_grandfather;

/**
 * Created by Revanth on 17-03-2017.
 */

public class FamilyLayout extends AppCompatActivity {
    private MediaPlayer media;
    private MediaPlayer.OnCompletionListener mcompletelistiner=new MediaPlayer.OnCompletionListener(){
        @Override
        public void onCompletion(MediaPlayer mp){
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.word_list);

        final ArrayList<Word> word=new ArrayList<Word>();
        word.add(new Word("grandfather","grandfather", drawable.family_grandfather, family_grandfather));
        word.add(new Word("grandmother","grandmother", drawable.family_grandmother, raw.family_grandmother));
        word.add(new Word("father","father", drawable.family_father, raw.family_father));
        word.add(new Word("four","four", drawable.family_mother, raw.family_mother));
        word.add(new Word("son","son", drawable.family_son, raw.family_son));
        word.add(new Word("daughter","daughter", drawable.family_daughter, raw.family_daughter));
        word.add(new Word("younger brother","younger brother", drawable.family_younger_brother, raw.family_younger_brother));
        word.add(new Word("younger sister","younger sister", drawable.family_younger_sister, raw.family_younger_sister));
        word.add(new Word("older brother","older brother", drawable.family_older_brother, raw.family_older_brother));
        word.add(new Word("older sister","older sister", drawable.family_older_sister, raw.family_older_sister));

        WordAdapter array=new WordAdapter(this,word, color.holobluelight);
        ListView listView=(ListView)findViewById(id.list);
        listView.setAdapter(array);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MediaPlayer media;
                Word words=word.get(position);
                media = MediaPlayer.create(FamilyLayout.this,words.getMmusicid());
                media.start();
                media.setOnCompletionListener(mcompletelistiner);
            }
        });
    }
    private void releaseMediaPlayer()
    {
        if(media!=null)
        {
            media.release();
            media=null;
        }
    }
    @Override
    protected void onPause() {
        releaseMediaPlayer();
        super.onPause();
    }

    @Override
    protected void onStop() {
        releaseMediaPlayer();
        super.onStop();
    }
}
