package nyc.c4q.ashiquechowdhury.adoptme;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import nyc.c4q.ashiquechowdhury.adoptme.model.Contact;
import nyc.c4q.ashiquechowdhury.adoptme.model.PetInformationModel;

/**
 * Created by ashiquechowdhury on 12/2/16.
 */

public class AnimalViewHolder extends RecyclerView.ViewHolder {
    private ImageView petImageView;
    private TextView phoneTV;
    private TextView addressTV;
    private TextView emailTV;
    private TextView stateTV;
    private TextView cityTV;
    private TextView zipCodeTV;

    public AnimalViewHolder(View view) {
        super(view);
        petImageView = (ImageView) itemView.findViewById(R.id.petImageView);
        phoneTV = (TextView) itemView.findViewById(R.id.phoneTextView);
        addressTV = (TextView) itemView.findViewById(R.id.addressTextView);
        emailTV = (TextView) itemView.findViewById(R.id.emailTextView);
        stateTV = (TextView) itemView.findViewById(R.id.stateTextView);
        cityTV = (TextView) itemView.findViewById(R.id.cityTextView);
        zipCodeTV = (TextView) itemView.findViewById(R.id.zipTextView);
    }

    public void bind(PetInformationModel petInformationModel) {
        Contact getInfo = petInformationModel.getPetContact();
        Picasso.with(itemView.getContext()).load(petInformationModel.getPetPictureURL()).fit().into(petImageView);
        phoneTV.setText("Phone: "+getInfo.getPhone().getPhone());
        addressTV.setText("Address: "+getInfo.getAddress1().getAddress());
        emailTV.setText("Email: "+getInfo.getEmail().getEmail());
        stateTV.setText("State: "+getInfo.getState().getTheState());
        cityTV.setText("City: "+getInfo.getCity().getCity());
        zipCodeTV.setText("ZipCode: "+getInfo.getZip().getZipCode());
    }
}
