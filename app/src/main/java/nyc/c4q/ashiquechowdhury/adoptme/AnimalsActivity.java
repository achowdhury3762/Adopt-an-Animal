package nyc.c4q.ashiquechowdhury.adoptme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by ashiquechowdhury on 11/29/16.
 */
public class AnimalsActivity extends AppCompatActivity{
    RecyclerView mAnimalRecyclerView;

    //baseurl - http://api.petfinder.com/
    //?key=591201d638c591f60b82a65aaed3bffa&location=11377&format=json

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);

        mAnimalRecyclerView = (RecyclerView) findViewById(R.id.animal_recycler);
        mAnimalRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}
