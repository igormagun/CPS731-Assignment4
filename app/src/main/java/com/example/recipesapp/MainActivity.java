package com.example.recipesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the ArrayLists
        ArrayList<String> recipeNames = new ArrayList<>(Arrays.asList("Recipe Test", "Recipe One",
                "Recipe Two", "Recipe Three", "Recipe Four", "Recipe Five", "Recipe Six",
                "Recipe Seven", "Recipe Eight", "Recipe Nine", "Recipe Ten", "Recipe Eleven",
                "Recipe Twelve", "Recipe Thirteen", "Recipe Fourteen", "Recipe Fifteen",
                "Recipe Sixteen"));
        ArrayList<String> recipeShortDescriptions = new ArrayList<>();
        ArrayList<String> recipes = new ArrayList<>();
        ArrayList<Integer> images = new ArrayList<>();

        // Fill the lists of short descriptions, recipes, and images
        for (int i = 0; i < recipeNames.size(); i++) {
            recipeShortDescriptions.add("This is a short description for this delicious recipe");
            recipes.add("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ultrices, " +
                    "ante in pellentesque faucibus, diam ante lacinia tellus, a maximus eros " +
                    "elit vel erat. Proin risus risus, mattis sit amet sem ut, porttitor pretium " +
                    "arcu. Cras in faucibus eros. Etiam nec porttitor ligula. Praesent " +
                    "ullamcorper metus vel consequat faucibus. Aenean erat est, interdum quis " +
                    "libero vitae, ultricies sagittis lectus. Aliquam eleifend feugiat velit, " +
                    "eget fermentum odio ultricies eu. Donec non dignissim ex, eget pulvinar " +
                    "augue. Sed mauris lorem, aliquet eget malesuada sed, eleifend vitae sapien." +
                    " Fusce pulvinar tristique diam, quis aliquam felis viverra id.\n\n" +
                    "Nam elementum interdum posuere. Pellentesque habitant morbi tristique " +
                    "senectus et netus et malesuada fames ac turpis egestas. Aenean a erat sit " +
                    "amet quam euismod ultricies. Maecenas dapibus nibh non sem ornare, ac " +
                    "euismod purus sagittis. Maecenas viverra ipsum lacinia risus malesuada " +
                    "fermentum. Curabitur varius et sem quis mattis. Sed id leo sed erat " +
                    "eleifend tincidunt. Duis sollicitudin vehicula sapien, ac aliquam eros " +
                    "eleifend sed. Sed ullamcorper quis nunc quis ultricies. Vivamus ullamcorper " +
                    "neque vel dui condimentum scelerisque. Curabitur ac ultrices tellus, a " +
                    "mollis dolor. Vestibulum et odio elementum, gravida eros id, sodales purus. " +
                    "Donec erat felis, finibus eget sollicitudin vel, eleifend vitae nulla. " +
                    "Aenean a urna ac risus consequat facilisis in id nibh.\n\n" +
                    "Pellentesque vulputate, velit nec ullamcorper maximus, mauris massa " +
                    "vestibulum est, sed finibus diam nisl vel ipsum. Nulla euismod magna diam, " +
                    "a bibendum lectus iaculis ac. Nulla eleifend pellentesque risus eu porta. " +
                    "In aliquet luctus semper. Donec in egestas quam, ac cursus ex. Suspendisse " +
                    "lacinia felis euismod lectus dictum, at tempus est iaculis. Ut augue leo, " +
                    "dictum ut dui vel, ultricies elementum velit. Pellentesque ultricies ex nec " +
                    "velit maximus pretium. In consectetur efficitur viverra. Suspendisse " +
                    "imperdiet purus sit amet nibh rutrum convallis. Nulla eget orci fringilla, " +
                    "feugiat nunc quis, maximus massa.\n\n" +
                    "Aenean iaculis elementum erat et tincidunt. Nunc vitae ullamcorper urna. " +
                    "Donec ante lectus, bibendum eu massa eu, bibendum lobortis erat. Nam " +
                    "venenatis nisl non ante pellentesque, eget congue justo vulputate. Quisque " +
                    "eget venenatis nisl. Mauris in purus gravida erat condimentum maximus. " +
                    "Suspendisse potenti. Mauris volutpat tincidunt est, in placerat arcu " +
                    "lobortis ut. Suspendisse in pretium quam. Cras viverra, nisi sit amet " +
                    "ultrices fringilla, ante enim cursus ex, ut pulvinar sapien lectus ac nibh. " +
                    "Maecenas suscipit enim sed pulvinar congue.");
            images.add(R.drawable.banana);
        }

        // Create the RecylerView and corresponding adapter
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecipeListAdapter listAdapter = new RecipeListAdapter(recipeNames, recipeShortDescriptions,
                recipes, images, this);

        // Set the adapter and layout manager for the RecyclerView
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}