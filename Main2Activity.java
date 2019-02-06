package com.example.atirel.tp_indents_atirel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.concurrent.ThreadLocalRandom;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        String door = bundle.getString("door");
        String car = bundle.getString("car");
        TextView et = findViewById(R.id.door);
        String res = getString(R.string.choice) + door + "\n";
        int wrongDoor = 0;
        switch (Integer.parseInt(door)){
            case 1:
                switch (Integer.parseInt(car)){
                    case 1:
                        wrongDoor = ThreadLocalRandom.current().nextInt(2,4);
                        break;
                    case 2:
                        wrongDoor = 3;
                        break;
                    case 3:
                        wrongDoor = 2;
                }
                break;
            case 2:
                switch (Integer.parseInt(car)){
                    case 1:
                        wrongDoor = 3;
                        break;
                    case 2:
                        if (ThreadLocalRandom.current().nextInt(0,2) == 1) {
                            wrongDoor = 1;
                        }
                        else {
                            wrongDoor = 3;
                        }
                        break;
                    case 3:
                        wrongDoor = 1;
                }
                break;
            case 3:
                switch (Integer.parseInt(car)){
                    case 1:
                        wrongDoor = 2;
                        break;
                    case 2:
                        wrongDoor = 1;
                        break;
                    case 3:
                        wrongDoor = ThreadLocalRandom.current().nextInt(1,3);
                }
        }
        res+= getString(R.string.wrongdoor) + wrongDoor + " " + getString(R.string.SecondChoiceDoor) + "\n" + getString(R.string.SecondChoiceDecision);
        et.setTextSize(25);
        et.setText(res);
    }

    public void theDoor(View view){
        TextView et = (TextView) findViewById(R.id.end);
        et.setTextSize(25);
        Intent intent2 = this.getIntent();
        Bundle bundle = intent2.getExtras();
        String car = bundle.getString("car");
        int choice = 0;
        switch (view.getId()){
            case R.id.door21:
                choice = 1;
                break;
            case R.id.door22:
                choice = 2;
                break;
            default:
                choice = 3;
        }
        Intent intent3 = new Intent(this, Main3Activity.class);
        intent3.putExtra("door", Integer.toString(choice));
        intent3.putExtra("car", car);
        startActivity(intent3);
    }
}
