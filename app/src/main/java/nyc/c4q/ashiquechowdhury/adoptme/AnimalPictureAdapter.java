package nyc.c4q.ashiquechowdhury.adoptme;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by ashiquechowdhury on 12/2/16.
 */
public class AnimalPictureAdapter extends RecyclerView.Adapter<AnimalPictureViewHolder> {
    List<PetImages> petImages;

    public AnimalPictureAdapter(List<PetImages> petImages) {
        this.petImages = petImages;
    }

    @Override
    public AnimalPictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View childView = inflater.inflate(R.layout.animalpicture_row, parent, false);
        return new AnimalPictureViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(AnimalPictureViewHolder holder, int position) {
        holder.bind(petImages.get(position));
    }

    @Override
    public int getItemCount() {
        return petImages.size();
    }
}
