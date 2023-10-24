package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import com.example.megido.myapplication.HttpRequest;
import java.net.http.HttpClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyHTTPRequest req = new MyHTTPRequest();
        req.execute("https://cataas.com/cat?json=true"); // Type 1
    }

    private class CatImages extends AsyncTask< String, Integer, String>

    {
        Bitmap currentBitmap;

        public String doInBackground(String ... args) {

            publishProgress(25);
            publishProgress(50);
            publishProgress(75);
            while (true) {  MyHTTPRequest req = new MyHTTPRequest();
                req.execute("https://cataas.com/cat?json=true"); // Type 1

                // Build entire String response
                BufferedReader reader = new BufferedReader(newInputStreamReader(inputStream, "UTF-8"), 8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                try { while ((line = reader.readLine()) != null)
                {
                    sb.append(line + "\n");
                }}
                catch(Exception e) {}
                // Result is the whole string
                String result = sb.toString();
            }
            return "Done";

        }

        //Type 2
        public void onProgressUpdate(Integer ... args)
        {

        }
        //Type3
        public void onPostExecute(String fromDoInBackground)
        {
            Log.i("HTTP", fromDoInBackground);
        }


    }


}