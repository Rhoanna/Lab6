package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;
import android.os.Bundle;

public class Lab8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab8);

        // onCreate(savedInstanceState:Bundle) {
        // super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_lab8);

            // This gets the toolbar from the layout :)
            Toolbar myToolbar = (Toolbar)findViewById(R.id.my_toolbar);

            // This loads the toolbar, which calls the onCreateOptionsMenu
             setActionBar(myToolbar);
         // setSupportActionBar(myToolbar);

        ImageView right_icon1 = findViewById(R.id.right_icon1);
        ImageView right_icon2 = findViewById(R.id.right_icon2);
        TextView title = findViewById(R.id.toolbar_title);
        right_icon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Lab8.this, "right_icon1", Toast.LENGTH_SHORT).show();
                 }
            });
        right_icon2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                   Toast.makeText(Lab8.this, "right_icon2", Toast.LENGTH_SHORT).show();
                   }
             });
             title.setText("setting the title");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }
  //  @Override
  //  public boolean onOptionsItemSelected(MenuItem item) {

// Handle presses on the action bar items
      //  switch (item.getItemId()) {
      //      case R.id.HomeID:
                //show a Toast
        //        Toast.makeText(this, "pressed home", Toast.LENGTH_SHORT).show();
       //         break;
      //      case R.id.Dad_JokesID: //launch another Activity
      //          Toast.makeText(this, "pressed dad jokes", Toast.LENGTH_SHORT).show();
      //          break;

      //      case R.id.ExitID: //launch another Activity
      //          Toast.makeText(this, "pressed exit", Toast.LENGTH_SHORT).show();
       //         break;
        }

