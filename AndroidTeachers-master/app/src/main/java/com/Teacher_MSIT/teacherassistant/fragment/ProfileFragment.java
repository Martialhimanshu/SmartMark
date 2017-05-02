package com.Teacher_MSIT.teacherassistant.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.Teacher_MSIT.teacherassistant.LoginActivity;
import com.Teacher_MSIT.teacherassistant.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.zip.Inflater;

/**
 * Created by Kashyap on 3/21/2017.
 */


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProfileFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
   private  ImageView imageView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FirebaseAuth firebaseAuth;
    private OnFragmentInteractionListener mListener;

    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        firebaseAuth=FirebaseAuth.getInstance();
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile,container);

        ImageView imageView = (ImageView)v.findViewById(R.id.imageView);
        TextView textView3 = (TextView)v.findViewById(R.id.textView3);
        TextView textView4 = (TextView)v.findViewById(R.id.textView4);
        TextView textView6 = (TextView)v.findViewById(R.id.textView6);

        FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user==null){
            Toast.makeText(getContext(),"User Null",Toast.LENGTH_SHORT).show();
        }else if(user.getUid().equals("oSkFngjzGPUpeBafpskNzY4l1ul1")) {
            Toast.makeText(getContext(),"hi",Toast.LENGTH_SHORT).show();
            imageView.setImageResource(R.drawable.prabhjot1);
            textView3.setText("Dr. Prabhjot Kaur");
            textView3.setTextColor(Color.RED);
            textView3.setTextSize(getResources().getDimension(R.dimen.textSize_big));

            textView4.setText("Associate Professor");
            textView4.setTextColor(Color.BLACK);

            textView6.setText("B.Tech,M.Tech,Ph.D");
            textView6.setTextColor(Color.BLACK);

        }
        else if(user.getUid().equals("YD8L4UKZEhdb6MWzTORQmTHh0H03")) {
            imageView.setImageResource(R.drawable.surender);
            textView3.setText("Dr. Surender Bhanwala");
            textView3.setTextColor(Color.RED);
            textView3.setTextSize(getResources().getDimension(R.dimen.textSize_big));

            textView4.setText("Assistant Professor");
            textView4.setTextColor(Color.BLACK);
            textView6.setText("B.Tech,M.Tech");
            textView6.setTextColor(Color.BLACK);

        }

        if(user.getUid().equals("ZeglAGrkbLdE72OBObuunM1EI2T2")) {

            imageView.setImageResource(R.drawable.sonika);
            textView3.setText("Sonika Malik");
            textView3.setTextColor(Color.RED);
            textView3.setTextSize(getResources().getDimension(R.dimen.textSize_big));

            textView4.setText("Assistant Professor");
            textView4.setTextColor(Color.BLACK);

            textView6.setText("B.Tech(CSE),M.Tech(IT)");
            textView6.setTextColor(Color.BLACK);

        }
            else if(user.getUid().equals("Hw5DqN2UeDaUBtPRLrwRHm35X5N2")) {
            imageView.setImageResource(R.drawable.anupma);
            textView3.setText("Dr. Anupama Kaushik ");
            textView3.setTextColor(Color.RED);
            textView3.setTextSize(getResources().getDimension(R.dimen.textSize_big));

            textView4.setText("Assistant Professor");
            textView4.setTextColor(Color.BLACK);

            textView6.setText("B.Tech,M.Tech,Ph.D");
            textView6.setTextColor(Color.BLACK);

        }


                return v;
            }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
