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

public class PhrasesLayout  extends AppCompatActivity {
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
        word.add(new Word("one","one",R.raw.phrase_are_you_coming));
        word.add(new Word("two","two",R.raw.phrase_come_here));
        word.add(new Word("three","three",R.raw.phrase_how_are_you_feeling));
        word.add(new Word("four","four",R.raw.phrase_im_coming));
        word.add(new Word("five","five",R.raw.phrase_im_feeling_good));
        word.add(new Word("six","six",R.raw.phrase_lets_go));
        word.add(new Word("seven","seven",R.raw.phrase_my_name_is));
        word.add(new Word("eight","eight",R.raw.phrase_what_is_your_name));
        word.add(new Word("nine","nine",R.raw.phrase_where_are_you_going));
        word.add(new Word("ten","ten",R.raw.phrase_yes_im_coming));

        WordAdapter array=new WordAdapter(this,word,R.color.red);
        ListView listView=(ListView)findViewById(R.id.list);
        listView.setAdapter(array);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MediaPlayer media;
                Word words=word.get(position);
                media = MediaPlayer.create(PhrasesLayout.this,words.getMmusicid());
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
