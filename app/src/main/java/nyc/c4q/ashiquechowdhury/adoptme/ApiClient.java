package nyc.c4q.ashiquechowdhury.adoptme;

import nyc.c4q.ashiquechowdhury.adoptme.model.RealPetfinder;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ashiquechowdhury on 12/3/16.
 */
public class ApiClient {
    private static ApiClient instance;
    private PetFinderAPI petFinderService;
    private static final String BASE_URL = "http://api.petfinder.com/";

    public static ApiClient getInstance(){
        if(instance == null){
            instance = new ApiClient();
        }
        return instance;
    }

    private ApiClient(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        petFinderService = retrofit.create(PetFinderAPI.class);
    };



    public Call<RealPetfinder> getAllPetsInformation(int zipCode){
        return petFinderService.getPetsByZipCode("591201d638c591f60b82a65aaed3bffa", "json", String.valueOf(zipCode), "100");
    }

    public Call<RealPetfinder> getAllPetsInformation(int zipCode, String animalChoice){
        return petFinderService.getPetsByZipCode("591201d638c591f60b82a65aaed3bffa", "json", String.valueOf(zipCode), "100", animalChoice);
    }
}
