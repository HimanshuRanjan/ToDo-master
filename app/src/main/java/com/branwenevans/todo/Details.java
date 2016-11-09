package com.branwenevans.todo;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Details extends FragmentActivity {
    private ViewPager mPager;
    ArrayList<String> list = new ArrayList<String>();
    private PagerAdapter mPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        String det = null;
        Intent intent = getIntent();
        String selectedClass = intent.getStringExtra(ListActivity.selectedClass);
        ArrayList<String> demo= new ArrayList <String>();
        String line;


        try {

            FileReader reader = new FileReader(getFilePath());
            BufferedReader bufferedReader = new BufferedReader(reader);

            while ((line = bufferedReader.readLine()) != null) {
                demo.add(line);
                System.out.println(line);
                int separator = line.indexOf(selectedClass);

                if (separator != -1) {

                    det = line.substring(line.indexOf(" "),line.lastIndexOf("-"));
                }
            }
            //Thread.sleep(5000);
            final TextView textViewToChange = (TextView) findViewById(R.id.item_name);
            final TextView textView = (TextView) findViewById(R.id.item_description);
            textViewToChange.setText(selectedClass);
            System.out.println(det);
            textView.setText(det);
            bufferedReader.close();
        } catch (IOException e) {
            //TODO: handle





        } /*catch (InterruptedException e) {
            e.printStackTrace();
        }*/

    }

   /* @Override
    public void onResume( )
    {
        super.onResume();
        String det = null;
        Intent intent = getIntent();
        String selectedClass = intent.getStringExtra(ListActivity.selectedClass);
        ArrayList<ListItem> lines = new ArrayList<>();
        String line;


        try {

            FileReader reader = new FileReader(getFilePath());
            BufferedReader bufferedReader = new BufferedReader(reader);

            while ((line = bufferedReader.readLine()) != null) {

                int separator = line.indexOf(selectedClass);

                if (separator != -1) {

                    det = line.substring(line.lastIndexOf(" "),line.indexOf("-"));
                }
            }
            //Thread.sleep(5000);
            final TextView textViewToChange = (TextView) findViewById(R.id.item_name);

            textViewToChange.setText(
                    selectedClass);
            final TextView textView = (TextView) findViewById(R.id.item_description);
            textView.setText(det);
            bufferedReader.close();
        } catch (IOException e) {
        }
    }*/

    private String getFilePath() {
        return getBaseContext().getFilesDir() + "/" + getString(R.string.file_name);
    }
}

