package com.example.petconnect;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShopFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShopFragment extends Fragment {

    RecyclerView shopRecyclerView;
    List<Item> itemList = new ArrayList<Item>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ShopFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShopFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShopFragment newInstance(String param1, String param2) {
        ShopFragment fragment = new ShopFragment();
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
        //enabling editing of options menu
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shop, container, false);

        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item(R.drawable.pet_food, "Product 1", 19));
        itemList.add(new Item(R.drawable.pet_food, "Product 2", 29));
        itemList.add(new Item(R.drawable.pet_food, "Product 3", 39));
        itemList.add(new Item(R.drawable.pet_food, "Product 4", 49));
        itemList.add(new Item(R.drawable.pet_food, "Product 5", 59));
        itemList.add(new Item(R.drawable.pet_food, "Product 6", 69));
        itemList.add(new Item(R.drawable.pet_food, "Product 7", 79));
        itemList.add(new Item(R.drawable.pet_food, "Product 8", 89));

        shopRecyclerView =  view.findViewById(R.id.shopRecyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        shopRecyclerView.setLayoutManager(layoutManager);
        shopRecyclerView.setAdapter(new ItemAdapter(getActivity(),itemList));

        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.top_nav_menu, menu);
        MenuItem addPost = menu.findItem(R.id.cart);
        addPost.setVisible(true);
    }
}