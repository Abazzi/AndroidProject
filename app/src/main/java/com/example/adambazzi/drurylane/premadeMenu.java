package com.example.adambazzi.drurylane;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.adambazzi.drurylane.JavaBeans.dessertPage;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link premadeMenu.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link premadeMenu#newInstance} factory method to
 * create an instance of this fragment.
 */
public class premadeMenu extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TextView dessertDescription;
    ListView list;
    Button addToCart;

    private OnFragmentInteractionListener mListener;

    public premadeMenu() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment premadeMenu.
     */
    // TODO: Rename and change types and number of parameters
    public static premadeMenu newInstance(String param1, String param2) {
        premadeMenu fragment = new premadeMenu();
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

    public class CustomAdapter extends ArrayAdapter<dessertPage>{

        //Create a construct that only requires context and the arraylist
        public CustomAdapter(Context context, ArrayList<dessertPage> items){
            //give ArrayAdapter class the context, no view and the list of items
            super(context, 0, items);
        }
        //We override the getView method so that we can provide our own view
        //for each item in the list
        public View getView(int position, View convertView,  ViewGroup parent) {
            //we do this by checking if the item already has a view
            //and if it does not we provide it with one
            if(convertView == null){
                //providing the view
                convertView =
                        LayoutInflater.from(
                                getContext()).inflate(R.layout.item_view, parent, false);
            }
            //We can then access each item in item_view.xml by using converView.findViewById()
            TextView name = (TextView) convertView.findViewById(R.id.name);
            //we can also use getItem() to access each item in the ListView
            dessertPage item = getItem(position);

            name.setText(item.getName());

            return convertView;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_premade_menu, container, false);

        dessertDescription = (TextView) view.findViewById(R.id.premadeDessertDescriptoin);

        list = (ListView) view.findViewById(R.id.premadeDessertListView);

        ArrayList<dessertPage>  cakeTypeList = new ArrayList<dessertPage>();
        cakeTypeList.add(new dessertPage("Chocolate Cake", "Chocolate cake, avaliable multiple versions", addToCart));
        cakeTypeList.add(new dessertPage("Vanilla Cake", "Vanilla cake, avaliable multiple versions", addToCart));
        cakeTypeList.add(new dessertPage("Red Velvet Cake", "Red Velvet cake, Overhyped Chocolate cake", addToCart));
        cakeTypeList.add(new dessertPage("Black Forrest Cake", "Basically Chocolate cake", addToCart));
        cakeTypeList.add(new dessertPage("White Cake", "Rich people vanilla cake", addToCart));

        ArrayAdapter adapter =  new ArrayAdapter(getContext(),
                android.R.layout.simple_list_item_1, cakeTypeList);
        CustomAdapter adapter1 = new CustomAdapter(getContext(),cakeTypeList);
        list.setAdapter(adapter1);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int  i, long id) {
                dessertDescription.setText(((dessertPage)list.getItemAtPosition(i)).getDefinition());
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
