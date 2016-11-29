package nyc.c4q.ashiquechowdhury.adoptme;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    ImageView randomAnimalImageView;
    private static final int BUNNY = R.drawable.bunny;
    private static final int CAT = R.drawable.cat;
    private static final int DOG = R.drawable.dogs;
    private static final int HEDGEHOG = R.drawable.hedgehog;
    private static final int TIGER = R.drawable.tiger;
    private static final int[] animalArray;

    static {
        animalArray = new int[]{BUNNY, CAT, DOG, HEDGEHOG, TIGER};
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randomAnimalImageView = (ImageView) findViewById(R.id.animalpics_imageView);
        cycleThroughPictures(animalArray, randomAnimalImageView);

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

    }
}