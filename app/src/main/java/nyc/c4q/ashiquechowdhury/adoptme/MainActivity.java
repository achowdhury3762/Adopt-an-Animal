package nyc.c4q.ashiquechowdhury.adoptme;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity{
    ImageView randomAnimalImageView;
    EditText zipCodeEditText;
    Spinner spinner;
    private static final int BUNNY = R.drawable.bunny;
    private static final int CAT = R.drawable.cat;
    private static final int DOG = R.drawable.dogs;
    private static final int HEDGEHOG = R.drawable.hedgehog;
    private static final int TIGER = R.drawable.tiger;
    private static final int[] animalArray;
    String selectedAnimal = "All Animals";
    public static final String ZIPCODE = "nyc.c4q.ashiquechowdhury.adoptme.ZIPCODE";
    public static final String SELECTEDANIMAL = "nyc.c4q.ashiquechowdhury.adoptme.SELECTEDANIMAL";

    static {
        animalArray = new int[]{BUNNY, CAT, DOG, HEDGEHOG, TIGER};
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randomAnimalImageView = (ImageView) findViewById(R.id.animalpics_imageView);
        zipCodeEditText = (EditText) findViewById(R.id.zipcode_editText);
        if(savedInstanceState!=null){
            zipCodeEditText.setText(String.valueOf(savedInstanceState.getInt(ZIPCODE)));
        }
        cycleThroughPictures(animalArray, randomAnimalImageView);
        spinner = (Spinner) findViewById(R.id.animal_spinner);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.animals_array, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
    }

    //PictureArray should be drawable
    void cycleThroughPictures(final int pictureArray[], final ImageView imageView) {
        for (int i = 0; i < pictureArray.length; i++) {
            final int x = i;
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    loadPicassoImage(pictureArray[x], imageView);
                }
            }, i * 5000);
        }
    }

    void loadPicassoImage(int resId, ImageView imageView) {
        Picasso.with(this).load(resId).fit().into(imageView);
    }

    public void onClickSubmit(View view) {
        int zipCode = Integer.parseInt(zipCodeEditText.getText().toString());
        selectedAnimal = spinner.getSelectedItem().toString();
        Intent intent = new Intent(this, AnimalsActivity.class);
        intent.putExtra(ZIPCODE, zipCode);
        intent.putExtra(SELECTEDANIMAL, selectedAnimal);
        startActivity(intent);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        if(zipCodeEditText.getText().toString().equals("")){
            savedInstanceState.putInt(ZIPCODE, 11377);
        }
        else {
            savedInstanceState.putInt(ZIPCODE, Integer.parseInt(zipCodeEditText.getText().toString()));
        }
        super.onSaveInstanceState(savedInstanceState);
    }
}