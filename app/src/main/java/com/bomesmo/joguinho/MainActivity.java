package com.bomesmo.joguinho;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        final GameView gameView = new GameView(getApplicationContext());

        setContentView(gameView);
    }
}
