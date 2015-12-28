package vne.vkmusic.friend;

/**
 * Created by volke on 28.12.2015.
 */
public class Friend {
    //Friend`s ID (identificator)
    private int id;

    private String
            //friend`s first name
            first_name,
            //...last name
            last_name,
            //...and URL to his profile photo
            photo_url;


    public void setId(int id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPhoto_url() {
        return photo_url;
    }
}
