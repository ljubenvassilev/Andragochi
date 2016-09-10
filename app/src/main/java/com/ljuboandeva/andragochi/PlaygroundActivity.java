package com.ljuboandeva.andragochi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.ljuboandeva.andragochi.model.players.User;
import com.ljuboandeva.andragochi.model.players.UsersManager;

public class PlaygroundActivity extends AppCompatActivity {

    String outChoice;
    Button home;
    Button shop;
    ImageButton inventory;
    ImageButton settings;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playground);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.layout_playground);
        home = (Button) findViewById(R.id.button_home);
        user=(User) getIntent().getExtras().get("loggedUser");
        shop=(Button)findViewById(R.id.button_shop_playground);
        inventory= (ImageButton) findViewById(R.id.button_inventory_playground);
        settings= (ImageButton) findViewById(R.id.button_settings_playground);

        outChoice = getIntent().getStringExtra("outChoice");
        switch (outChoice){
            case "park":
                relativeLayout.setBackground(getResources().getDrawable(R.drawable.background_park));
                break;
            case "pool":
                relativeLayout.setBackground(getResources().getDrawable(R.drawable.background_pool));
                break;
            case "sandbox":
                relativeLayout.setBackground(getResources().getDrawable(R.drawable.background_sandbox));
                break;
        }



        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlaygroundActivity.this,HomeActivity.class);
                intent.putExtra("loggedUser", UsersManager.getInstance(PlaygroundActivity.this).getUser(user.getUsername()));
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(PlaygroundActivity.this, ShopActivity.class);
                intent.putExtra("loggedUser", UsersManager.getInstance(PlaygroundActivity.this).getUser(user.getUsername()));
                startActivity(intent);
            }
        });

        inventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(PlaygroundActivity.this, InventoryActivity.class);
                intent.putExtra("loggedUser", UsersManager.getInstance(PlaygroundActivity.this).getUser(user.getUsername()));
                startActivity(intent);
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(PlaygroundActivity.this, SettingsActivity.class);
                intent.putExtra("loggedUser", UsersManager.getInstance(PlaygroundActivity.this).getUser(user.getUsername()));
                startActivity(intent);
            }
        });
    }
}
