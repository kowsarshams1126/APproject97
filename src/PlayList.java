import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import static java.awt.Image.SCALE_DEFAULT;

public class PlayList {
    private ArrayList<Music> songs = new ArrayList<>();
    private String title;
    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public PlayList(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addSong(Music m) {
        songs.add(m);

    }

    public void removeSong(String s) {
        Iterator<Music> iterator = songs.iterator();
        while (iterator.hasNext()) {
            Music music = iterator.next();
            if (music.getTitle().equals(s)) {
                songs.remove(music);
                break;
            }
        }
    }

    public void removeSong(Music m) throws IOException {
        Iterator<Music> iterator = songs.iterator();
        while (iterator.hasNext()) {
            Music music = iterator.next();
            if (music.equals(m)) {
                songs.remove(music);
            }
        }

    }


    public void rename(String s) {
        this.title = s;
    }

}