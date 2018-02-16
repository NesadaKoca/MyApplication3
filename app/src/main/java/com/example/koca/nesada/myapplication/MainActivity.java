package com.example.koca.nesada.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.widget.EditText;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ConstraintLayout constraintLayout;
    private ConstraintSet constraintSet1 = new ConstraintSet();
    private ConstraintSet constraintSet2 = new ConstraintSet();
    EditText etIngred, etPrep, etNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_fragment);

        etIngred = (EditText) findViewById(R.id.ingred);
        etPrep = (EditText) findViewById(R.id.prep);
        etNote = (EditText) findViewById(R.id.note);

        constraintLayout = (ConstraintLayout) findViewById(R.id.addMain);
        constraintSet1.clone(constraintLayout);
        constraintSet2.clone(this, R.layout.prove1);

        etIngred.setOnClickListener(this);
        etPrep.setOnClickListener(this);
        etNote.setOnClickListener(this);
    }


    @Override
    public void onBackPressed() {

        TransitionManager.beginDelayedTransition(constraintLayout);
        constraintSet1.applyTo(constraintLayout);
        //super.onBackPressed();


        etIngred.setVisibility(View.VISIBLE);
        etPrep.setVisibility(View.VISIBLE);
        etNote.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View view) {

        TransitionManager.beginDelayedTransition(constraintLayout);
        constraintSet2.applyTo(constraintLayout);

        etIngred.setVisibility(View.INVISIBLE);
       etPrep.setVisibility(View.INVISIBLE);
        etNote.setVisibility(View.INVISIBLE);

        if(view.getId() == etIngred.getId()){
            etIngred.setVisibility(View.VISIBLE);
        }else if (view.getId() == etPrep.getId()){
            etPrep.setVisibility(View.VISIBLE);
        }else if (view.getId() == etNote.getId()){
          etNote.setVisibility(View.VISIBLE);

        }

    }
}



