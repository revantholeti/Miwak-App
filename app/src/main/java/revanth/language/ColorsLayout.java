package revanth.language;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Revanth on 17-03-2017.
 */

public class ColorsLayout extends AppCompatActivity {

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
        setContentView(R.layout.word_list);


        final ArrayList<Word> word=new ArrayList<Word>();
        word.add(new Word("black","black",R.drawable.color_black,R.raw.color_black));
        word.add(new Word("brown","brown",R.drawable.color_brown,R.raw.color_brown));
        word.add(new Word("yellow","yellow",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        word.add(new Word("gray","gray",R.drawable.color_gray,R.raw.color_gray));
        word.add(new Word("green","green",R.drawable.color_green,R.raw.color_green));
        word.add(new Word("mustard yellow","mustard yellow",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));
        word.add(new Word("red","red",R.drawable.color_red,R.raw.color_red));
        word.add(new Word("white","white",R.drawable.color_white,R.raw.color_white));


        WordAdapter array=new WordAdapter(this,word,R.color.green);
        ListView listView=(ListView)findViewById(R.id.list);
        listView.setAdapter(array);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word words = word.get(position);
                media = MediaPlayer.create(ColorsLayout.this, words.getMmusicid());
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
