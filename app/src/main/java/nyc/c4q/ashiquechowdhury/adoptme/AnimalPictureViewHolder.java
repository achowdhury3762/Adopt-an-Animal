package nyc.c4q.ashiquechowdhury.adoptme;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by ashiquechowdhury on 12/2/16.
 */
public class AnimalPictureViewHolder extends RecyclerView.ViewHolder{
    ImageView animalImage;

    public AnimalPictureViewHolder(View itemView) {
        super(itemView);
        animalImage = (ImageView) itemView;
    }

    public void bind(PetImages petImages) {
        Picasso.with(itemView.getContext()).load(petImages.getPetImagesURL()).fit().into(animalImage);
    }


}
