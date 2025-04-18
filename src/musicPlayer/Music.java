package musicPlayer;

import java.util.ArrayList;

public class Music {
    private String title;
    private User singer;
    private int numberOfStream = 0;
    private static ArrayList<Music> allMusic = new ArrayList<Music>();

    public Music(String title, User singer) {
        this.title = title;
        this.singer = singer;
        allMusic.add(this);
    }

    public void play() {
        numberOfStream++;
        System.out.println("Playing " + title + " singer " + singer + " stream "
                + numberOfStream);
    }

    public static ArrayList<Music> search(String title) {
        ArrayList<Music> musicList = new ArrayList<Music>();
        for (Music music : allMusic) {
            if (music.title.equals(title)) {
                musicList.add(music);
            }
        }
        if (musicList.isEmpty())
            return null;
        else
            return musicList;
    }

    public static ArrayList<Music> search(String title, User singer) {
        ArrayList<Music> musicList = new ArrayList<Music>();
        for (Music music : allMusic) {
            if (music.title.equals(title) && music.singer.getUsername().equals(singer.getUsername())) {
                musicList.add(music);
            }
        }
        if (musicList.isEmpty())
            return null;
        else
            return musicList;
    }

    @Override
    public String toString() {
        return String.format("title: %s-singer: %s", this.title, this.singer.getUsername());
    }

    public String getTitle() {
        return title;
    }

    public User getSinger() {
        return singer;
    }

    public int getNumberOfStream() {
        return numberOfStream;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSinger(User singer) {
        this.singer = singer;
    }

    public static ArrayList<Music> getAllMusic() {
        return allMusic;
    }
}
