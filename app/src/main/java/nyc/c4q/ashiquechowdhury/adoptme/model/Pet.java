package nyc.c4q.ashiquechowdhury.adoptme.model;

/**
 * Created by ashiquechowdhury on 11/30/16.
 */
public class Pet {
    public Contact getContact() {
        return contact;
    }

    private Contact contact;
    private Media media;

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }
}
