package musicPlayer;

import java.util.ArrayList;
import java.util.Objects;

public class User {
    private String username;
    private String password;
    private ArrayList<User> followerList;
    private ArrayList<User> followingList;
    private UserBehavior behavior;
    private ArrayList<Playlist> playlists;
    private static ArrayList<User> allUser;

    public User(String username, String password) {
        // validation
        if (!Objects.isNull(allUser)) {
            for (User usr : allUser)
                if (usr.getUsername().equals(username))
                    throw new InvalidOperationException("Username is already in use!");
            if (password.length() < 8)
                throw new InvalidOperationException("Password must be at least 8 characters!");
        }

        this.username = username;
        this.password = password;
        behavior = new RegularBehavior();
        followerList = new ArrayList<>();
        followingList = new ArrayList<>();
        playlists = new ArrayList<>();
        allUser = new ArrayList<>();
    }

    @Override
    public String toString() {
        return this.getUsername();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<User> getFollowerList() {
        return followerList;
    }

    public void setFollowerList(ArrayList<User> followerList) {
        this.followerList = followerList;
    }

    public ArrayList<User> getFollowingList() {
        return followingList;
    }

    public void setFollowingList(ArrayList<User> followingList) {
        this.followingList = followingList;
    }

    public UserBehavior getBehavior() {
        return behavior;
    }

    public void setBehavior(UserBehavior behavior) {
        this.behavior = behavior;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

    public void addPlaylist(Playlist playlist) {
        playlists.add(playlist);
    }

    public static ArrayList<User> getAllUser() {
        return allUser;
    }

    public static void setAllUser(ArrayList<User> allUser) {
        User.allUser = allUser;
    }

    public void follow(User user) {
        followerList.add(user);
        user.followingList.add(this);
    }

    public void creatPlayList(String title, User owner) {
        this.behavior.createPlaylist(title, owner);
    }

    public void playMusic(Music music) {
        this.behavior.playMusic(music);
    }

    public void buyPremium(User owner, int month) {
        this.behavior.buyPremium(owner, month);
    }
}
