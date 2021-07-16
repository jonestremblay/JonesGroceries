package ca.jonestremblay.jonesgroceries.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ca.jonestremblay.jonesgroceries.R;
import ca.jonestremblay.jonesgroceries.entities.Grocery;
import ca.jonestremblay.jonesgroceries.entities.Product;
import ca.jonestremblay.jonesgroceries.entities.Recipe;
import ca.jonestremblay.jonesgroceries.viewmodel.GroceriesFragmentViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecipesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecipesFragment extends Fragment {

    private TextView noProductsLabel;
    private GroceriesFragmentViewModel viewModel;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    public static Fragment newInstance() {
        RecipesFragment fragment = new RecipesFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View fragmentView = inflater.inflate(R.layout.fragment_recipes, container, false);

        findViews(fragmentView);

        initViewModel();
        initRecyclerView();

//        DatabaseHelper dbHelper = new DatabaseHelper(this.getContext());
//        Category cat = new Category("Fruits et légumes", 1244);
//        // TODO : Rendre les query de Room aSync, afin que ça s'execute dans le main thread.
//
//        // TODO : Apprendre le threading pour gérer les query de Room.
//        Product product = new Product("oranges", cat);
//        boolean success =  dbHelper.addProduct(product);
//
        return inflater.inflate(R.layout.fragment_recipes, container, false);
    }

    public void findViews(View v) {
        noProductsLabel  = v.findViewById(R.id.noProductLabel);
        recyclerView = v.findViewById(R.id.catalogRecyclerView);
    }

    private void initRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        //recyclerView.setAdapter();
    }

    private void initViewModel() {
        viewModel = new ViewModelProvider(this).get(GroceriesFragmentViewModel.class);
        viewModel.getListOfGroceryObserver().observe(getViewLifecycleOwner(), new Observer<List<Grocery>>() {
            @Override
            public void onChanged(List<Grocery> products) {
                if (products == null){
                    noProductsLabel.setVisibility(View.VISIBLE);
                } else {
                    /** Show in RecyclerView */
                    noProductsLabel.setVisibility(View.GONE);
                }
            }
        });
    }
}