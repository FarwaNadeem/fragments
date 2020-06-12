package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements TestInterface{

    Button firstFragment, secondFragment;
    sendToFrag sf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get the reference of button
        firstFragment = (Button)findViewById(R.id.b1);
        secondFragment = (Button)findViewById(R.id.b2);


        //perform setOnClickListener event on first Button
        firstFragment.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                loadFragment(new FirstFragment());
            }
        });

        //perform setOnClickListener event on second Button
        secondFragment.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
//                loadFragment(new SecondFragment());
                loadFragment(ItemLisstFragment.newInstance(20));
            }
        });


    }
    private void loadFragment(Fragment fragment)
    {
        FragmentManager fm = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }

    public void updateFragmentText(String text)
    {

//        Fragment f = getSupportFragmentManager().findFragmentById(R.id.tv1);
//        ((TextView)f.getView().findViewById(R.id.tv1)).setText("this is fragment"+text);



//            sf.updateText(text);
        Bundle bundle = new Bundle();
        bundle.putString("params", text);
// set MyFragment Arguments
        SecondFragment myObj = new SecondFragment();
        myObj.setArguments(bundle);

    }

//    @Override
//     public boolean onOptionItemSelected(MenuItem item)
//    {
//        int id = item.getItemId();
//
//        if(id == R.id.action_setting) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}


