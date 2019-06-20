
import com.mpatric.mp3agic.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.AudioDevice;
import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;

import javax.sound.sampled.AudioSystem;
import javax.swing.*;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;



public class Music {
     Mp3File mp3File;
    private String Title;
    private String album;
    private String Artist;
    private File music;
    private FileInputStream input=null;
    Player player=null;
    Thread t;
    private int count;
    private int passedTime;
    private int remainTime;
    private int time;
  AdvancedPlayer advancedPlayer=null;



    public Music(File music) throws IOException, JavaLayerException, InvalidDataException, UnsupportedTagException {
        this.music = music;
        this.metaData();
        this.input=new FileInputStream(music);
        this.mp3File=new Mp3File(music.getAbsolutePath());
        this.count=mp3File.getFrameCount();
        metaData();

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

    public void play(int a) throws JavaLayerException {
        advancedPlayer=new AdvancedPlayer(input);
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (a>getTime()){
                        System.out.println("PAUSE");
                        return;}
                    advancedPlayer.play((a*count/getTime())%getTime(),count);
                    System.out.println(mp3File.getFrameCount());
                } catch (JavaLayerException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

    }
    public void play() throws JavaLayerException {
        player=new Player(input);
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    player.play();
                    System.out.println(mp3File.getFrameCount());

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
        return player.getPosition()/1000;
    }

    public int getRemainTime() {
        return (getTime()-this.getPassedTime())/1000;
    }

    public int getTime() {
        return ((int)mp3File.getLengthInMilliseconds())/1000;
    }

    public String timetoString(int time){
        String min=""+time/60;
        String sec=""+time%60;
        if (min.length()==1)
            min="0"+min;
        if (sec.length()==1)
            sec="0"+sec;
        return min+":"+sec;
    }
    public Image getArtWork(){
        byte[] bytes;
        try {

            bytes = mp3File.
                    getId3v2Tag().
                    getAlbumImage();
            ImageIcon image=new ImageIcon(bytes);
            return getScaledImage(image.getImage(),100,100);

        }
        catch (NullPointerException e){
            ImageIcon imageIcon=new ImageIcon("baseMusicArtwork.jpeg");
            return getScaledImage(imageIcon.getImage(),100,100);
        }

    }
    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }
    public void getLyric() throws JavaLayerException {
        ID3v2 id3v22Tag = mp3File.getId3v2Tag();
        String s = mp3File.getId3v2Tag()
                .getLyrics();
        System.out.println(s);
    }
    public int timeToFrame(int time){
        return mp3File.getFrameCount()/getTime();

    }
   }