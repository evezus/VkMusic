package vne.vkmusic.audio;

public class VkAudio {

    private int id;

    private int owner_id;

    private String artist;

    private String title;

    private int duration;

    private String url;

    private int lyrics_id;

    private int album_id;

    private int genre_id;

    private int date;


    public int getId() {
        return id;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public String getUrl() {
        return url;
    }

    public int getLyrics_id() {
        return lyrics_id;
    }

    public int getAlbum_id() {
        return album_id;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public int getDate() {
        return date;
    }


    public void setId(int id) {
            this.id = id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setLyrics_id(int lyrics_id) {
        this.lyrics_id = lyrics_id;
    }

    public void setAlbum_id(int album_id) {
        this.album_id = album_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

    public void setDate(int date) {
        this.date = date;
    }
}

