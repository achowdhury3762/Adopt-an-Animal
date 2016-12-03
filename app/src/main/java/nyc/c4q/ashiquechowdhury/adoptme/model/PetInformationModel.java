package nyc.c4q.ashiquechowdhury.adoptme.model;

/**
 * Created by ashiquechowdhury on 12/2/16.
 */
public class PetInformationModel {
    private String petPictureURL;
    private Contact petContact;

    public String getPetPictureURL() {
        return petPictureURL;
    }

    public Contact getPetContact() {
        return petContact;
    }
    public PetInformationModel(Contact contact, String petPictureURL){
        this.petPictureURL = petPictureURL;
        petContact = contact;
    }
}
