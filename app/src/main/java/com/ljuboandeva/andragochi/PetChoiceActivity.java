package com.ljuboandeva.andragochi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ljuboandeva.andragochi.model.pet.PetManager;
import com.ljuboandeva.andragochi.model.players.User;
import com.ljuboandeva.andragochi.model.players.UsersManager;

import com.ljuboandeva.andragochi.model.pet.PetManager;
import com.ljuboandeva.andragochi.model.players.User;

public class PetChoiceActivity extends AppCompatActivity {

    Button confirmPet;
<<<<<<< HEAD
    EditText namePet;
=======
>>>>>>> 7691d5eea1f77770154635b34b26dc8abfef691c
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_choice);

        namePet=(EditText)findViewById(R.id.editText_NamePet);
        confirmPet= (Button)findViewById(R.id.Button_confirmPet);
<<<<<<< HEAD
        user= (User) getIntent().getExtras().get("loggedUser");
        Log.e("USERNAME",user.getUsername());

=======
         user= (User) getIntent().getExtras().get("loggedUser");
>>>>>>> 7691d5eea1f77770154635b34b26dc8abfef691c

        confirmPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
<<<<<<< HEAD
                //choosing pet? creating reference and pet.setPetName(namePer.getText.toString);

               // PetManager.setUserPet(user, pet);
                Log.e("USERNAME",user.getUsername());
                Intent intеnt = new Intent(PetChoiceActivity.this, HomeActivity.class);
                intеnt.putExtra("loggedUser", UsersManager.getInstance(PetChoiceActivity.this).getUser(user.getUsername()));
=======
                //choosing pet?

               // PetManager.setUserPet(user, pet);
                Intent intеnt = new Intent(PetChoiceActivity.this, DifficultyActivity.class);
>>>>>>> 7691d5eea1f77770154635b34b26dc8abfef691c
                    startActivity(intеnt);
            }
        });
    }
}
