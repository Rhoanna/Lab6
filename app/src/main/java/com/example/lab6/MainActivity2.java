package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        class StarWars extends AsyncTask< String, Integer, String> {
            String strUrlJSON = "https://swapi.dev/api/people/?format=json";

            public String doInBackground(String... args) {
                String jsonResponse = "";
                InputStream inputStream = null;

                ArrayList<String> starWarsList;
                try {
                    URL url = new URL(strUrlJSON);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("GET");
                    con.connect();

                    JSONObject jsonObject = new JSONObject(strUrlJSON);

                    for (int i = 0 ; i <jsonObject.length(); i++) {
                        Item item = new Item("", "", "");
                        item.putItemName(jsonObject.getString("name"));
                        item.putItemHeight(jsonObject.getString("height"));
                        item.putItemMass(jsonObject.getString("mass"));
                        }

                } catch (ProtocolException e) {
                    throw new RuntimeException(e);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


                return jsonResponse;
                // return starWarsList;

            }

            Context context;


            // we have the data, in the item object, so we need to get it into the listview
           // ArrayList<Item> starWarsList = new ArrayList<>();
            ArrayList<Item> starWarsList = new ArrayList<Item>();

          // *** can not seem to add to it***  starWarsList.add(new lv.getItemName(1));
            runListView adapter = new runListView(context, starWarsList);

            // get the view
            ListView itemsLv = (ListView) findViewById(R.id.listview);
            itemsLv.setAdapter(adapter);

            itemsLv.setOnItemClickListener(new ListView.OnClickListener() {
                // setup the button listener
                @Override
                public void onClick(View v) {


                    // method to do something here when button is pressed
                }
            };



        }}}