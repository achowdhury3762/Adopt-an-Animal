package nyc.c4q.ashiquechowdhury.adoptme;

import nyc.c4q.ashiquechowdhury.adoptme.model.RealPetfinder;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ashiquechowdhury on 11/29/16.
 */

public interface PetFinderAPI {
    @GET("pet.find")
    Call<RealPetfinder> getPetsByZipCode(@Query("key") String apiKey, @Query("format") String formatType, @Query("location") String zipCode, @Query("count") String count);
}