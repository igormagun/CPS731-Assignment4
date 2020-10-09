package com.example.recipesapp;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A fragment representing a single Recipe detail screen.
 * This fragment is either contained in a {@link RecipeListActivity}
 * in two-pane mode (on tablets) or a {@link RecipeActivity}
 * on handsets.
 */
public class RecipeDetailFragment extends Fragment {
    /**
     * The fragment argument representing the content to be displayed
     */
    public static final String RECIPE_DESCRIPTION = "recipe";
    public static final String IMAGE = "image";

    /**
     * The content to be displayed
     */
    private String recipe;
    private Integer imageID;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RecipeDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        assert getArguments() != null;
        if (getArguments().containsKey(RECIPE_DESCRIPTION) && getArguments().containsKey(IMAGE))
        {
            // Load the content specified in the arguments
            recipe = getArguments().getString(RECIPE_DESCRIPTION);
            imageID = getArguments().getInt(IMAGE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_recipe, container, false);

        // Show the dummy content as text in a TextView.
        if (recipe != null) {
            ((TextView)rootView.findViewById(R.id.recipeText)).setText(recipe);
        }
        // Show the recipe image
        if (imageID != null) {
            ((ImageView)rootView.findViewById(R.id.imageView)).setImageResource(imageID);
        }

        return rootView;
    }
}