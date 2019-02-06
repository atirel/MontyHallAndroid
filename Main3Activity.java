package com.example.atirel.tp_indents_atirel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        String door = bundle.getString("door");
        String car = bundle.getString("car");
        TextView et = findViewById(R.id.text);
        ImageView imageView = findViewById(R.id.result);
        if((Integer.parseInt(car) != Integer.parseInt(door))){
            imageView.setBackgroundResource(R.drawable.goat);
            et.setText(getString(R.string.lose));
        }
        else{
            imageView.setBackgroundResource(R.drawable.car);
            et.setText(getString(R.string.win));
        }
    }

    @Override
    public void onBackPressed(){
        Intent startOver = new Intent(this, MainActivity.class);
        startActivity(startOver);
    }

    public void endGame(View view){
        if(view.getId() == R.id.playAgain){
            Intent startOver = new Intent(this, MainActivity.class);
            startActivity(startOver);
        }
    }

}
