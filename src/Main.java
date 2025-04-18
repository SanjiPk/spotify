import musicPlayer.*;

import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        // create Users
        User matin = null, pariya = null, mina = null;
        try {
            matin = new User("Sanji", "matin1385");
            pariya = new User("cat", "pariya1384");
            mina = new User("mina chibi", "mina");
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }

        if (!Objects.isNull(matin)) {
            matin.follow(pariya);
            System.out.println("matin follower list: " + matin.getFollowerList().getFirst());
        }

        Music sucker = null, sholeshKon = null, song = null;
        try {
            sucker = new Music("Sucker", new User("Marcus king", "123456789"));
            sholeshKon = new Music("sholesh kon", new User("Shaye", "12346578"));
            song = new Music("Sucker", pariya);
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Search for sucker: ");
        ArrayList<Music> result1 = Music.search("Sucker");
        try {
            for (Music music : result1)
                System.out.println(music.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Search for sucker with singer 'pariya' : ");
        ArrayList<Music> result2 = Music.search("Sucker", pariya);
        try {
            for (Music music : result2)
                System.out.println(music.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            matin.playMusic(sucker);
            matin.playMusic(sholeshKon);
            matin.playMusic(sucker);
            System.out.println("Stream count for song1: " + sucker.getNumberOfStream());
            RegularBehavior test =(RegularBehavior) matin.getBehavior();
            System.out.println("playing limit for matin is :" + test.getPlayingLimit());
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }

        matin.buyPremium(matin, 4);
        matin.creatPlayList("Favorites", matin);
        for (int i = 0; i < 10; i++) {
            matin.playMusic(sholeshKon);
        }
        System.out.println("Stream count for song1: " + sholeshKon.getNumberOfStream());

        Playlist playlist = matin.getPlaylists().getFirst();
        playlist.addMusic(sucker, "matin1385");
        playlist.addMusic(sholeshKon, "matin1385");

        try {
            playlist.addMusic(sucker, "matin1385");
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }

        try {
            playlist.addMusic(song, "wrongpass");
        } catch (InvalidOperationException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("search in playlist for sucker: ");
        ArrayList<Music> test1 = matin.getPlaylists().getFirst().searchInPlaylist("Sucker");
        for (Music music : test1)
            System.out.println(music.toString());

        Playlist playlist1 = matin.getPlaylists().getFirst();
        playlist1.playPlaylist();
        playlist1.shuffelPlay();
    }
}