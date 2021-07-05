package com.example.rpgsurvivalgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/Enchanted_Land.otf");
        TextView textView = (TextView)findViewById(R.id.textView);
        Button button = (Button)findViewById(R.id.button);
        textView.setTypeface(type);
        button.setTypeface(type);
    }


    public void startGame(View view) {
        /*
        Called when user presses the 'PLAY GAME' button. Calls the GameActivity Activity.
         */
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}