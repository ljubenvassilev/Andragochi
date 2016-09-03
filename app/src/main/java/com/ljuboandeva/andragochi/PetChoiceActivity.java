package com.ljuboandeva.andragochi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.ljuboandeva.andragochi.model.pet.Pet;
import com.ljuboandeva.andragochi.model.players.User;
import com.ljuboandeva.andragochi.model.players.UsersManager;

public class PetChoiceActivity extends AppCompatActivity {

    Button confirmPet;
    EditText namePet;
    ImageButton right;
    ImageButton left;
    String petType;
    ImageView petPic;
    int counter=0;

    User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_choice);

        namePet = (EditText) findViewById(R.id.editText_NamePet);
        confirmPet = (Button) findViewById(R.id.Button_confirmPet);
        right = (ImageButton) findViewById(R.id.button_right);
        left = (ImageButton) findViewById(R.id.button_left);
        petPic = (ImageView) findViewById(R.id.pet_picture);
        user = (User) getIntent().getExtras().get("loggedUser");
        changePet(counter);

        right.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                if (counter < 2) {
                  changePet(++counter);

                }
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (counter > 0) {
                    changePet(--counter);
                }
            }
        });


        confirmPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changePet(counter);
                String petName=namePet.getText().toString();

                if(!petName.isEmpty()) {
                    confirmPet.setError(null);
                    Pet userPet = new Pet(petType);
                    userPet.setName(petName);
                    user.setPet(userPet);
                }
                else{
                    namePet.setError("Pet name is empty!");
                    namePet.requestFocus();
                    return;
                }

                Intent intеnt = new Intent(PetChoiceActivity.this, HomeActivity.class);
                intеnt.putExtra("loggedUser", UsersManager.getInstance(PetChoiceActivity.this).getUser(user.getUsername()));

                // PetManager.setUserPet(user, pet); SAVE PET TO USER IN SHARED PREFS TODO

                startActivity(intеnt);
            }
        });
    }
        private void changePet(int counter){
        switch(counter){
            case 0:
                petType="Dino";
                petPic.setImageResource(R.drawable.drago);break;

            case 1:
                petType="Rex";
                petPic.setImageResource(R.drawable.rhina);break;
            //change ID TODO
            case 2:
                petType="Rex";
                petPic.setImageResource(R.drawable.rex);break;
            //change ID TODO
        }
    }
}
