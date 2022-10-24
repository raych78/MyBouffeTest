package fr.isep.mybouffetest.AddFood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import fr.isep.mybouffetest.R;
import fr.isep.mybouffetest.Search.FoodModel;
import fr.isep.*;
import fr.isep.mybouffetest.Search.foood_RecyclerViewAdapter;

public class UserAddFoodActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_add_food);

        ImageButton backSearchFood = (ImageButton) findViewById(R.id.backSearchFood);
        backSearchFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        EditText inputFood = (EditText) findViewById(R.id.inputFoodText);

        Button addFoodValidation = (Button) findViewById(R.id.buttonValidation);

        addFoodValidation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validation(inputFood.getText().toString())==true){
                    Intent i = new Intent(UserAddFoodActivity.this, foood_RecyclerViewAdapter.class);
                    i.putExtra("new food",inputFood.getText().toString());
                    startActivity(i);
                };

            }
        });

        }

        public boolean validation(String inputFood){
            if (inputFood.isEmpty()){
                Toast.makeText(getApplicationContext(),"Il faut donner un nom à l'aliment!",Toast.LENGTH_SHORT).show();
                Log.d("Champ vide", "le champs est vide");
                return false;
            }
            else{
                FoodModel userFood =  new FoodModel(inputFood,R.mipmap.ic_plate);
                Log.d("Champs non vide","le nom de la bouffe" + inputFood);
                return true;
            }
        }
}

