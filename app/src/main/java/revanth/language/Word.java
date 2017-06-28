package revanth.language;

/**
 * Created by Revanth on 19-03-2017.
 */

public class Word {
    private String mEnglis;
    private String mNumber;
    private int mimageid=M_HAS_IMAGE;
    private static final int M_HAS_IMAGE=-1;
    private int mmusicid;
    public Word(String Englis,String Number,int musicid)
    {
        mEnglis=Englis;
        mNumber=Number;
        mmusicid=musicid;
    }
    public Word(String English,String Number,int img,int musicid)
    {
        mEnglis=English;
        mNumber=Number;
        mimageid=img;
        mmusicid=musicid;
    }
    public String getEnglish()
    {
        return mEnglis;
    }
    public String getmNumber()
    {
        return mNumber;
    }
    public int getimgid()
    {
        return mimageid;
    }
    public boolean hasimage()
    {
        return mimageid!=M_HAS_IMAGE;
    }
    public int getMmusicid() { return mmusicid;}

}
