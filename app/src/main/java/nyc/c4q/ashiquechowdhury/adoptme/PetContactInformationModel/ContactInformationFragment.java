package nyc.c4q.ashiquechowdhury.adoptme.PetContactInformationModel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nyc.c4q.ashiquechowdhury.adoptme.R;

/**
 * Created by ashiquechowdhury on 12/3/16.
 */
public class ContactInformationFragment extends Fragment {
    RecyclerView mPetContactRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mPetContactRecyclerView = (RecyclerView) getActivity().findViewById(R.id.pet_contact_recycler);
        mPetContactRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        return inflater.inflate(R.layout.petcontact_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

    }
}
