package fr.epsi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import fr.epsi.R;

public class HomeActivity extends MainActivity  implements View.OnClickListener{


    public static void displayActivity(MainActivity activity){
        Intent intent = new Intent(activity,HomeActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        findViewById(R.id.buttonCategorie).setOnClickListener(this);
        findViewById(R.id.buttonGroup).setOnClickListener(this);
        setTitle("Home");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
             case R.id.buttonGroup:
                StudentsActivity.displayActivity(this);
                break;
            case R.id.buttonCategorie:
                break;
        }
    }
}
