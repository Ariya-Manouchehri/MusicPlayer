package com.example.musicplayer;

public class AudioModel {
    private String music_name;
    private String music_artist;
    private long musicID;
    private long music_album_id;
    private long music_duration;

    public String getMusic_name() {
        return music_name;
    }

    public String getMusic_Artist() {
        return music_artist;
    }

    public long getMusicID() {
        return musicID;
    }

    public long getMusic_album_id() {
        return music_album_id;
    }

    public long getDuration() {
        return music_duration;
    }

    public void setMusic_name(String music_name) {
        this.music_name = music_name;
    }

    public void setMusic_Artist(String music_Artist) {
        this.music_artist = music_Artist;
    }

    public void setMusicID(long musicID) {
        this.musicID = musicID;
    }

    public void setMusic_album_id(long music_album_id) {
        this.music_album_id = music_album_id;
    }

    public void setDuration(long duration) {
        this.music_duration = duration;
    }
}
