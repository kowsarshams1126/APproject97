
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Music {
    private String adress;
    private String Title;
    private String album;
    private String Artist;
    private File music;
    private FileInputStream input=null;

    public Music(File music) throws IOException {
        this.music = music;
        this.metaData();
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
}
