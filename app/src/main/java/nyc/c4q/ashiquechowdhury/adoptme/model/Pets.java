package nyc.c4q.ashiquechowdhury.adoptme.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashiquechowdhury on 11/30/16.
 */
public class Pets {
    private List<Pet> pet = new ArrayList<Pet>();

    public List<Pet> getPet() {
        return pet;
    }

    public void setPet(List<Pet> pet) {
        this.pet = pet;
    }
}
