package revanth.language;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Revanth on 19-03-2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private int mcolor;
    public WordAdapter(Activity context, ArrayList<Word> word,int color){
        super(context,R.layout.twotextview, (List<Word>)word);
        mcolor=color;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflate=LayoutInflater.from(getContext());
        View contextView=inflate.inflate(R.layout.twotextview,parent,false);
        Word str=getItem(position);
        TextView txt1=(TextView)contextView.findViewById(R.id.text1);
        TextView txt2=(TextView)contextView.findViewById(R.id.text2);
        ImageView image=(ImageView)contextView.findViewById(R.id.img);
        txt1.setText(str.getEnglish());
        txt2.setText(str.getmNumber());
        if(str.hasimage()) {
            image.setImageResource(str.getimgid());
        }
        else{
            image.setVisibility(View.GONE);
        }
        View text=contextView.findViewById(R.id.container);
        int col= ContextCompat.getColor(getContext(),mcolor);
        text.setBackgroundColor(col);
        return contextView;
    }
}
