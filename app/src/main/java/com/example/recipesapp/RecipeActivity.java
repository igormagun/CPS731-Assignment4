package com.example.recipesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * An activity to present recipe image and text to the user
 */
public class RecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        TextView recipeText = findViewById(R.id.recipeText);
        Bundle intentExtras = getIntent().getExtras();
        // Check to make sure the extras are not null
        if (intentExtras == null) {
            recipeText.setText(R.string.recipe_not_found);
        }
        // If they are not null, get the image ID and recipe text to present to the user
        else {
            int imageID = intentExtras.getInt("image");
            String recipe = intentExtras.getString("recipe");
            ImageView recipeImage = findViewById(R.id.imageView);

            recipeText.setText(recipe);
            recipeImage.setImageResource(imageID);
        }

    }
}