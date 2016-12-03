package nyc.c4q.ashiquechowdhury.adoptme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.ashiquechowdhury.adoptme.model.Contact;
import nyc.c4q.ashiquechowdhury.adoptme.model.PetInformationModel;
import nyc.c4q.ashiquechowdhury.adoptme.model.RealPetfinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

        mAnimalRecyclerView = (RecyclerView) findViewById(R.id.animal_recycler);
        mAnimalRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mPictureRecyclerView = (RecyclerView) findViewById(R.id.animalpicture_recycler);
        mPictureRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        callRetrofit();
    }

    private void callRetrofit() {
        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("http://api.petfinder.com/").build();
        PetFinderAPI petAPI = retrofit.create(PetFinderAPI.class);

//        Call<Petfinder> myPetfinder = petAPI.getPetsByZipCode("591201d638c591f60b82a65aaed3bffa", "json" , "11377");
        Call<RealPetfinder> myPetfinder = petAPI.getPets();
        myPetfinder.enqueue(new Callback<RealPetfinder>() {
            @Override
            public void onResponse(Call<RealPetfinder> call, Response<RealPetfinder> response) {
                RealPetfinder petFinder = response.body();
                List<PetInformationModel> petNearbyList = new ArrayList<PetInformationModel>();
                List<PetImages> petImages = new ArrayList<PetImages>();
                for (int i = 0; i < petFinder.getPetfinder().getPets().getPet().size(); i++) {
                    String imageURL = petFinder.getPetfinder().getPets().getPet().get(i).getMedia().getPhotos().getPhoto().get(0).get$t();
                    Contact petContact = petFinder.getPetfinder().getPets().getPet().get(i).getContact();
                    if (imageURL != null && petContact != null) {
                        petNearbyList.add(new PetInformationModel(petContact, imageURL));
                        petImages.add(new PetImages(imageURL));
                    }
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
