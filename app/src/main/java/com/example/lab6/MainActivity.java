package com.example.lab6;

import static android.os.PersistableBundle.readFromStream;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.MulticastSocket;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.nio.Buffer;

public class MainActivity extends AppCompatActivity {
     String strUrl = "https://cataas.com/cat?json=true";

      // this is what is at that web site:
    //  {"tags":["cat"],"createdAt":"2022-04-17T19:17:05.564Z","updatedAt":"2022-10-11T07:52:32.651Z","mimetype":"image/jpeg","size":280545,"_id":"KyCpC9ckObUSgQ54"}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new CatImages().execute();
        new CatImages().onProgressUpdate(25);
    }
    private class CatImages extends AsyncTask< String, Integer, String> {
        Bitmap currentBitmap;
        public String doInBackground(String... args) {
            String jsonResponse = "";
            InputStream inputStream = null;
            try {
                URL url = new URL(strUrl);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestMethod("GET");
                con.connect();
                while (true) {
                    // pickup the next cat picture
                    // query with  json
                    // use id is jason payload to check if already have that image id locally then use local image
                    // but for now, skip that, just to get this working, ie, step 8 in assignment
                    // use url in the json payload, save it to the device and update imageview

                   // there seems to be two methods to parse out JSON but its not clear which one is the best
                   // these static variables are for the json string method, but its unclear where the bitmap is

                    // json method A

                    String tags;
                    String createdAt;
                    String updatedAt;
                    String mimetype;
                    Integer size;
                    String _id;

                    final String JSON_STRING="{\"tags\":{\"createdAt\":\"2022-04-17T19:17:05.564Z\",\"updatedAt\":\"2022-10-11T07:52:32.651Z\",\"mimetype\":\"image/jpeg\",\"size\":280545,\"_id\":\"KyCpC9ckObUSgQ54\"}";
//     original   public final static String JSON_STRING="{"tags":["cat"],"createdAt":"2022-04-17T19:17:05.564Z","updatedAt":"2022-10-11T07:52:32.651Z","mimetype":"image/jpeg","size":280545,"_id":"KyCpC9ckObUSgQ54"}";

                    JSONObject jsonObject = new JSONObject(JSON_STRING);
                   // JSONObject jsonObject = new JSONObject(strUrl);


                    // json method B
                    JSONObject webImages = jsonObject.getJSONObject("WebImages");


                    String imageName = webImages.getString("Imagename");
                    String imageUrl = webImages.getString("imageurl");
                    //  inputStream = con.getInputStream();
                    // BufferedReader bf = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    //   String value = bf.readLine();
                    // jsonResponse = readFromStream(inputStream);
                    // display the image version 2
                   // getApplication().setWallpaper(currentBitmap);
                    // enjoy the cat, this is a timer
                    for (int i = 0; i < 100; i++) {
                        try {
                            publishProgress(i);
                            Thread.sleep(30);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
               }
            catch (Exception e)
                {
                // do something};
                }
                return "Done";
                }
            //Type 2
              public void onProgressUpdate(Integer ... args)
              {
                  try {
                      JSONObject jsonObject = new JSONObject(strUrl);
                      JSONObject webImages = jsonObject.getJSONObject("WebImages");
                      String imageName = webImages.getString("Imagename");
                      String imageUrl = webImages.getString("imageurl");
                      // display the image version 1
                      ImageView image = findViewById(R.id.imageCatViewer);
                      Bitmap bMap = BitmapFactory.decodeFile(imageUrl);
                      //    Bitmap bMap = BitmapFactory.decodeResource(); // get image from html as a parameter
                      image.setImageBitmap(bMap);
                  }
                  catch(Exception e) {}
              }
            //Type3
              public void onPostExecute(String fromDoInBackground)
              {
            //  Log.i("HTTP", fromDoInBackground);
              }
            // pre work forth method
            //   public void onPreExecute()
            //     {
            // Log.i("HTTP", fromDoInBackground);
            //     }
        }
    }