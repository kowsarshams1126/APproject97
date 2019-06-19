import com.mpatric.mp3agic.Mp3File;

import java.awt.*;
import java.util.ArrayList;

public class Album {
    private String Title;
    private int counter;
    private Image image;
    private String artist;
    private ArrayList<Music> songs=new ArrayList<>();
    private Music Sample;

    public Album() {
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
    public void addSong(Music music){
        songs.add(music);
        this.setTitle(music.getTitle());
        this.setImage(music.getArtWork());
        this.setArtist(music.getArtist());
        counter=songs.size();
    }
}
