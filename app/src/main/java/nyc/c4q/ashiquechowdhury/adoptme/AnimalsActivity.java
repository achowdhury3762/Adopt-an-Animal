package nyc.c4q.ashiquechowdhury.adoptme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.ashiquechowdhury.adoptme.animalcontactrecycler.AnimalAdapter;
import nyc.c4q.ashiquechowdhury.adoptme.animalpicturerecycler.AnimalPictureAdapter;
import nyc.c4q.ashiquechowdhury.adoptme.animalpicturerecycler.PetImages;
import nyc.c4q.ashiquechowdhury.adoptme.model.Contact;
import nyc.c4q.ashiquechowdhury.adoptme.model.PetInformationModel;
import nyc.c4q.ashiquechowdhury.adoptme.model.RealPetfinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ashiquechowdhury on 11/29/16.
 */
public class AnimalsActivity extends AppCompatActivity {
    RecyclerView mAnimalRecyclerView;
    RecyclerView mPictureRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);

        Intent intent = getIntent();
        int zipCode = intent.getIntExtra(MainActivity.ZIPCODE, 11377);
        String animalChoice = intent.getStringExtra(MainActivity.SELECTEDANIMAL);

        mAnimalRecyclerView = (RecyclerView) findViewById(R.id.animal_recycler);
        mAnimalRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mPictureRecyclerView = (RecyclerView) findViewById(R.id.animalpicture_recycler);
        mPictureRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


        switch(animalChoice){
            case "All Animals":
                callRetrofit(zipCode, "All Animals");
                break;
            case "Rabbit":
                callRetrofit(zipCode, "rabbit");
                break;
            case "Cat":
                callRetrofit(zipCode, "cat");
                break;
            case "Dog":
                callRetrofit(zipCode, "dog");
                break;
            case "Horse":
                callRetrofit(zipCode,"horse");
                break;
            case "Pig":
                callRetrofit(zipCode,"pig");
                break;
            case "Furry/Small":
                callRetrofit(zipCode,"smallfurry");
                break;
        }

    }

    private void callRetrofit(int zipCode, String animalChoice) {
        ApiClient petAPIClient = ApiClient.getInstance();
        Call<RealPetfinder> myPetfinderCall;
        if(animalChoice.equals("All Animals")){
            myPetfinderCall = petAPIClient.getAllPetsInformation(zipCode);
        }
        else
            myPetfinderCall = petAPIClient.getAllPetsInformation(zipCode, animalChoice);
        myPetfinderCall.enqueue(new Callback<RealPetfinder>() {
            @Override
            public void onResponse(Call<RealPetfinder> call, Response<RealPetfinder> response) {
                RealPetfinder petFinder = response.body();
                List<PetInformationModel> petNearbyList = new ArrayList<PetInformationModel>();
                List<PetImages> petImages = new ArrayList<PetImages>();
                for (int i = 0; i < petFinder.getPetfinder().getPets().getPet().size(); i++) {
                    String imageURL;
                    Contact petContact;
                    try{
                        imageURL = petFinder.getPetfinder().getPets().getPet().get(i).getMedia().getPhotos().getPhoto().get(1).get$t();
                        petContact = petFinder.getPetfinder().getPets().getPet().get(i).getContact();
                    }
                    catch(NullPointerException e){
                        continue;
                    }
                        petNearbyList.add(new PetInformationModel(petContact, imageURL));
                        petImages.add(new PetImages(imageURL));

                }
                if (petNearbyList != null) {
                    mAnimalRecyclerView.setAdapter(new AnimalAdapter(petNearbyList));
                    mPictureRecyclerView.setAdapter(new AnimalPictureAdapter(petImages));
                }
            }

            @Override
            public void onFailure(Call<RealPetfinder> call, Throwable t) {

            }
        });
    }
}
