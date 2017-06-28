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

public class NumberLayout extends AppCompatActivity {
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
        word.add(new Word("one","one",R.drawable.number_one,R.raw.number_one));
        word.add(new Word("two","two",R.drawable.number_two,R.raw.number_two));
        word.add(new Word("three","three",R.drawable.number_three,R.raw.number_three));
        word.add(new Word("four","four",R.drawable.number_four,R.raw.number_four));
        word.add(new Word("five","five",R.drawable.number_five,R.raw.number_five));
        word.add(new Word("six","six",R.drawable.number_six,R.raw.number_six));
        word.add(new Word("seven","seven",R.drawable.number_seven,R.raw.number_seven));
        word.add(new Word("eight","eight",R.drawable.number_eight,R.raw.number_eight));
        word.add(new Word("nine","nine",R.drawable.number_nine,R.raw.number_nine));
        word.add(new Word("ten","ten",R.drawable.number_ten,R.raw.number_ten));

        WordAdapter array=new WordAdapter(this,word,R.color.orange);
        ListView listView=(ListView)findViewById(R.id.list);
        listView.setAdapter(array);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MediaPlayer media;
                Word words=word.get(position);
                media = MediaPlayer.create(NumberLayout.this,words.getMmusicid());
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