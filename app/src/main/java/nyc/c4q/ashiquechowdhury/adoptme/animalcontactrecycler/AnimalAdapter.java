package nyc.c4q.ashiquechowdhury.adoptme.animalcontactrecycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.ashiquechowdhury.adoptme.R;
import nyc.c4q.ashiquechowdhury.adoptme.model.PetInformationModel;

/**
 * Created by ashiquechowdhury on 12/2/16.
 */
public class AnimalAdapter extends RecyclerView.Adapter {
    List<PetInformationModel> petInformationList;

    public AnimalAdapter(List<PetInformationModel> petsInformationList) {
        this.petInformationList = petsInformationList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.animal_row, parent, false);
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        AnimalViewHolder viewHolder = (AnimalViewHolder) holder;
        viewHolder.bind(petInformationList.get(position));
    }

    @Override
    public int getItemCount() {
        return petInformationList.size();
    }
}
