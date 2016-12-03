package nyc.c4q.ashiquechowdhury.adoptme;

import nyc.c4q.ashiquechowdhury.adoptme.model.Petfinder;
import nyc.c4q.ashiquechowdhury.adoptme.model.RealPetfinder;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ashiquechowdhury on 11/29/16.
 */
//baseurl - http://api.petfinder.com/
//?key=591201d638c591f60b82a65aaed3bffa&location=11377&format=json
public interface PetFinderAPI {
    @GET("pet.find")
    Call<Petfinder> getPetsByZipCode(@Query("key") String apiKey, @Query("format") String formatType, @Query("location") String zipCode);

    @GET("pet.find?key=591201d638c591f60b82a65aaed3bffa&location=11377&format=json")
    Call<RealPetfinder> getPets();
}