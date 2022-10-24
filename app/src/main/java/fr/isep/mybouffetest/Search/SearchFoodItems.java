package fr.isep.mybouffetest.Search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import fr.isep.mybouffetest.AddFood.AddFoodItem;
import fr.isep.mybouffetest.AddFood.UserAddFoodActivity;
import fr.isep.mybouffetest.MainActivity;
import fr.isep.mybouffetest.R;

public class SearchFoodItems extends AppCompatActivity {


     SearchView foodSearchView;


    ArrayList<FoodModel> mFoodModels = new ArrayList<>();
    int[] foodImages = {
            R.mipmap.ic_riz,
            R.mipmap.ic_quinoa,
            R.mipmap.ic_lentilles,
            R.mipmap.ic_lentilles,
            R.mipmap.ic_pain,
            R.mipmap.ic_pain,
            R.mipmap.ic_plate,
            R.mipmap.ic_pomme
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_food_items);

        foodSearchView = findViewById(R.id.foodSearchView);


        ImageButton toAddFoodButton = (ImageButton) findViewById(R.id.toAddFood);
        ImageButton backbutton = (ImageButton) findViewById(R.id.backButton);

        RecyclerView recyclerView = findViewById(R.id.foodRecyclerView);

        setUpFoodModels();

        foood_RecyclerViewAdapter adapter = new foood_RecyclerViewAdapter(this,mFoodModels);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        toAddFoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentAddFooditem = new Intent(SearchFoodItems.this, UserAddFoodActivity.class);
                startActivity(intentAddFooditem);
            }
        });
        

    }

    private void setUpFoodModels(){
        String[] foodNames = getResources().getStringArray(R.array.food_array);

        for (int i = 0; i < foodNames.length; i++)
        {

            mFoodModels.add(new FoodModel(foodNames[i],foodImages[i]));

        }
    }

    }