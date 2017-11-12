package com.example.sayan.listviewcustom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //steps to follow when creating a custom listview
    //Prerequisite: get all the resources for the child data in one place
    //step 1: add a listview in your activity layout
    //step 2: find the listview by id in your activity java code
    //step 3: create a child layout without any context
    //step 4: define a custom adapter class
    //step 5: set the custom adapter object in the listview

    //Prerequisite
    private String[] textList = {"One", "Two", "Three", "Four", "Five", "Six"};
    private int[] imageList = {R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image, R.drawable.image};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //step 2
        ListView listView = (ListView) findViewById(R.id.listview_id);
        //step 5
        CustomAdapter adapter = new CustomAdapter();
        listView.setAdapter(adapter);
    }


    //step 4
    private class CustomAdapter extends BaseAdapter {

        //this method returns the number of child the listview will hold
        @Override
        public int getCount() {
            return textList.length;
        }

        //this method returns an item of one child
        @Override
        public Object getItem(int i) {
            return imageList[i];
        }

        //this method returns the particular id of a corresponding child item
        @Override
        public long getItemId(int i) {
            return i;
        }

        //this method returns the actual view corresponding to a particular child
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            //get the layout inflater object from the context
            LayoutInflater inflater = getLayoutInflater();
            //get the child view after inflating the child layout
            View rootView = inflater.inflate(R.layout.child_layout, null);
            //initialize all the views in the child layout
            ImageView imageView = rootView.findViewById(R.id.imageview_child_id);
            TextView textView = rootView.findViewById(R.id.textview_child_id);
            //set the view with dynamic data for each child
            imageView.setImageDrawable(getDrawable(imageList[i]));
            textView.setText(textList[i]);
            //return the child view
            return rootView;
        }
    }

}
