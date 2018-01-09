package com.example.adambazzi.drurylane;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link createCakeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link createCakeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class createCakeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    String orderText;

    boolean  chochoChecked, vanillaChecked, orangeChecked, chocoIcingChecked, vanillaIcingChecked;
    String quantityOfCupCake;



    private OnFragmentInteractionListener mListener;

    public createCakeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment createCakeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static createCakeFragment newInstance(String param1, String param2) {
        createCakeFragment fragment = new createCakeFragment();
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
        View view = inflater.inflate(R.layout.fragment_create_cake, container, false);
        final Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.fade);

        Button submitOrder = (Button) view.findViewById(R.id.customCakebutton);
        final ImageView cupCakeImage = (ImageView) view.findViewById(R.id.cupCakeImage);

        RadioButton chocoBatter = view.findViewById(R.id.chocoloateCakeRadio);
        RadioButton vanillaBatter = view.findViewById(R.id.vanillaCakeRadio);
        RadioButton orangeBatter = view.findViewById(R.id.orangeCakeRadio);
        final RadioButton chocoIcing = view.findViewById(R.id.chocoIcingRadio);
        final RadioButton vanillaIcing = view.findViewById(R.id.vanillaIcingRadio);

        final TextView quantity = (TextView) view.findViewById(R.id.cupCakeNumber);


        RadioGroup batter = (RadioGroup) view .findViewById(R.id.batter);
        RadioGroup icing = (RadioGroup) view .findViewById(R.id.icing);

        /**
         *  batter radio group OnCheckedChangeListener handler
         */
        batter.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected

                chocoIcing.setChecked(false);
                vanillaIcing.setChecked(false);
                switch(checkedId) {
                    case R.id.chocoloateCakeRadio:
                        cupCakeImage.setImageResource(R.drawable.chocolatecake);
                        cupCakeImage.startAnimation(animation);
                        chochoChecked = true;
                        vanillaChecked = false;
                        orangeChecked = false;
                        break;
                    case R.id.vanillaCakeRadio:
                        cupCakeImage.setImageResource(R.drawable.vanillacake);
                        cupCakeImage.startAnimation(animation);
                        vanillaChecked = true;
                        chochoChecked = false;
                        orangeChecked = false;
                        break;
                    case R.id.orangeCakeRadio:
                        cupCakeImage.setImageResource(R.drawable.orangecake);
                        cupCakeImage.startAnimation(animation);
                        orangeChecked = true;
                        chochoChecked = false;
                        vanillaChecked = false;
                        break;
                }
            }
        });


        /**
         *  icing radio group OnCheckedChangeListener handler
         */
        icing.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                switch(checkedId) {
                    case R.id.chocoIcingRadio:
                        chocoIcingChecked = true;
                        vanillaIcingChecked = false;
                        if(chochoChecked){
                            cupCakeImage.setImageResource(R.drawable.choco_choco);
                            cupCakeImage.startAnimation(animation);
                            break;
                        }
                        if(vanillaChecked){
                            cupCakeImage.setImageResource(R.drawable.vanilla_choco);
                            cupCakeImage.startAnimation(animation);
                            break;
                        }
                        if(orangeChecked){
                            cupCakeImage.setImageResource(R.drawable.orange_choco);
                            cupCakeImage.startAnimation(animation);
                            break;
                        }
                        break;
                    case R.id.vanillaIcingRadio:
                        chocoIcingChecked = false;
                        vanillaIcingChecked = true;
                        if(chochoChecked){
                            cupCakeImage.setImageResource(R.drawable.choco_vanilla);
                            cupCakeImage.startAnimation(animation);
                            break;
                        } else if(vanillaChecked){
                            cupCakeImage.setImageResource(R.drawable.vanilla_vanilla);
                            cupCakeImage.startAnimation(animation);
                            break;
                        } else if(orangeChecked){
                            cupCakeImage.setImageResource(R.drawable.orange_vanilla);
                            cupCakeImage.startAnimation(animation);
                            break;
                        }
                        break;
                }
            }
        });

        quantity.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                quantityOfCupCake = quantity.getText().toString();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        submitOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderToString();
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"recipient@example.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "Custom Cake Order");
                i.putExtra(Intent.EXTRA_TEXT   , orderText);
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    //Toast.makeText(MyActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();

                }
            }

            private void orderToString() {
                orderText = "cake batter: ";
                if(chochoChecked){
                    orderText += "Chocolate";
                } else if(vanillaChecked){
                    orderText += "Vanilla";
                } else if(orangeChecked){
                    orderText += "Orange";
                }

                if(chocoIcingChecked){
                    orderText += "\nIcing: Chocolate";
                } else if(vanillaIcingChecked){
                    orderText += "\nIcing: Vanilla";
                }

                orderText += "\nQuantity: " + quantityOfCupCake;


            }
        });
        return view;

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
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
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
