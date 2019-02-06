package com.example.atirel.tp_indents_atirel;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void language(View view){
        Uri uri = Uri.parse(getString(R.string.link));
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(uri);
        startActivity(intent);
    }

    public void theDoor(View view) {
        int randomNum = ThreadLocalRandom.current().nextInt(1,4);
        Intent intent = new Intent(this, Main2Activity.class);
        int door = 0;
        switch (view.getId()){
            case R.id.door1:
                door = 1;
                break;
            case R.id.door2:
                door = 2;
                break;
            case R.id.door3:
                door = 3;
                break;
            default:
                throw new RuntimeException("Unknown button ID");
        }
        intent.putExtra("door", Integer.toString(door));
        intent.putExtra("car", Integer.toString(randomNum));
        startActivity(intent);
    }
    @Override
    public void onBackPressed(){
        Intent startOver = new Intent(this, MainActivity.class);
        startActivity(startOver);
    }
}
