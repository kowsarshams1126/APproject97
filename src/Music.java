
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.omg.PortableServer.THREAD_POLICY_ID;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



public class Music {
    private Mp3File mp3File;
    private String Title;
    private String album;
    private String Artist;
    private File music;
    private FileInputStream input=null;
    Player player=null;
    Thread t;
    private int passedTime;
    private int remainTime;
    private int time;



    public Music(File music) throws IOException, JavaLayerException, InvalidDataException, UnsupportedTagException {
        this.music = music;
        this.metaData();
        this.input=new FileInputStream(music);
        this.mp3File=new Mp3File(music.getAbsolutePath());

    }
    private void metaData() throws IOException {


        byte[] total=new byte[(int) music.length()];
        byte[] TAG=new byte[3];
        byte[] title=new byte[30];
        byte[] artist=new byte[30];
        byte[] album=new byte[30];

        FileInputStream temp=new FileInputStream(music);
        temp.read(total);
        int counter=0;
        for (int i=total.length-128;i<total.length-125;i++){
            TAG[counter]=total[i];
            counter++;
        }

        counter=0;
        for (int i=total.length-125;i<total.length-95;i++){
            title[counter]=total[i];
            counter++;
        }
        counter=0;
        for (int i=total.length-95;i<total.length-65;i++) {
            artist[counter] = total[i];
            counter++;
        }

        counter=0;
        for (int i=total.length-65;i<total.length-35;i++){
            album[counter]=total[i];
            counter++;
        }
        this.album = new String(album);
        this.Title=new String(title);
        this.Artist=new String(artist);

    }

    public String getTitle() {
        return Title;
    }

    public String getAlbum() {
        return album;
    }

    public String getArtist() {
        return Artist;
    }

    public void play() throws JavaLayerException {
        player=new Player(input);
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    player.play();
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }



    public void pause() throws JavaLayerException {


        t.stop();

    }


    public int getPassedTime() {
        return player.getPosition();
    }

    public int getRemainTime() {
        return time-this.getPassedTime();
    }

    public int getTime() {
        return ((int)mp3File.getLengthInMilliseconds())/1000;
    }
}
