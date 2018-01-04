package com.example.adambazzi.drurylane;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adambazzi.drurylane.JavaBeans.dessertPage;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MainFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

   public Button cake;
   public Button cookies;
   public Button pie;
   public Button donuts;
   public Button addToCart;


    TextView dessertDescription;
    ListView list;

    FragmentManager fm;

    private OnFragmentInteractionListener mListener;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
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
        View view = inflater.inflate(R.layout.fragment_main, container, false);


        dessertDescription = (TextView) view.findViewById(R.id.premadeDessertDescription);

        list = (ListView) view.findViewById(R.id.premadeDessertListView);

        final ArrayList<dessertPage> cakeTypeList = new ArrayList<dessertPage>();
        cakeTypeList.add(new dessertPage("Chocolate Cake", "Chocolate cake, available multiple versions",4, addToCart));
        cakeTypeList.add(new dessertPage("Vanilla Cake", "Vanilla cake, Basic",4, addToCart));
        cakeTypeList.add(new dessertPage("Black Forrest Cake", "Black Forrest Cake",4, addToCart));
        cakeTypeList.add(new dessertPage("Red Velvet Cake", "Red Velvet Cake",4, addToCart));
        cakeTypeList.add(new dessertPage("Pound Cake", "Pound Cake",4, addToCart));
        cakeTypeList.add(new dessertPage("Blue cake", "Blue Cake lol", 4,addToCart));

        final ArrayList<dessertPage>  donutTypeList= new ArrayList<dessertPage>();
        donutTypeList.add(new dessertPage("Chocolate", "Chocolate Dipped Donut",1, addToCart));
        donutTypeList.add(new dessertPage("Sprinkle", "Vanilla Dip Donut with Sprinkles",1, addToCart));
        donutTypeList.add(new dessertPage("Double Chocolate", "Chocolate Donut with Chocolate Dips",1, addToCart));
        donutTypeList.add(new dessertPage("Original Glazed", "Plain Donut dipped in Glaze",1, addToCart));
        donutTypeList.add(new dessertPage("Apple Fritter", "Apple Cinnamon stuffed donut",2, addToCart));
        donutTypeList.add(new dessertPage("Cheesecake", "Vanilla Donut stuffed with cheesecake filling", 3,addToCart));

        final ArrayList<dessertPage>  pieTypeList = new ArrayList<dessertPage>();
        pieTypeList.add(new dessertPage("Apple Pie", "Apple Pie",4, addToCart));
        pieTypeList.add(new dessertPage("Pumpkin Pie", "Pumpkin Pie",4, addToCart));
        pieTypeList.add(new dessertPage("Cherry Pie", "Cherry Pie",4, addToCart));
        pieTypeList.add(new dessertPage("Blueberry Pie", "Blueberry Pie",4, addToCart));
        pieTypeList.add(new dessertPage("Strawberry Rhubarb", "Strawberry Rhubarb Pie",4, addToCart));
        pieTypeList.add(new dessertPage("Key Lime Pie", "Key lime pie", 4,addToCart));

        final ArrayList<dessertPage>  cookieTypeList = new ArrayList<dessertPage>();
        cookieTypeList.add(new dessertPage("Oatmeal Raisin", "Oatmeal Raisin Cookie, the best kind",4, addToCart));
        cookieTypeList.add(new dessertPage("Chocolate Chip ", "Chocolate chip cookies ",4, addToCart));
        cookieTypeList.add(new dessertPage("Gingerbread", "Great for the holidays",4, addToCart));
        cookieTypeList.add(new dessertPage("Snickerdoodle", "I don't even know but they sound good",4, addToCart));

        fm = getActivity().getSupportFragmentManager();

        cake = (Button) view.findViewById(R.id.cake);
        donuts = (Button) view.findViewById(R.id.donuts);
        cookies = (Button) view.findViewById(R.id.cookies);
        pie = (Button) view.findViewById(R.id.pie);

        cake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.content, premadeMenu.newInstance(cakeTypeList));
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


        pie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.content, premadeMenu.newInstance(pieTypeList));
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


        cookies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.content,  premadeMenu.newInstance(cookieTypeList));
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


        donuts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.content, premadeMenu.newInstance(donutTypeList));
                transaction.addToBackStack(null);
                transaction.commit();
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
