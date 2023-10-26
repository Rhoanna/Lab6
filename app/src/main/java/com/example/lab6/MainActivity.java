package com.example.lab6;

import static android.os.PersistableBundle.readFromStream;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

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


    // tired this version but i dont need the metadata, i need the image file
    String strUrlJSON = "https://cataas.com/cat?json=true";
    // actual cat url
    String strUrl = "https://cataas.com/cat";


      // this is what is at that web site:
    //  {"tags":["cat"],"createdAt":"2022-04-17T19:17:05.564Z","updatedAt":"2022-10-11T07:52:32.651Z","mimetype":"image/jpeg","size":280545,"_id":"KyCpC9ckObUSgQ54"}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CatImages CI = new CatImages();
        CI.execute();

        CI.onProgressUpdate(25);
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
                Log.i("HTTP", "hhhhhhhhhhhhhh");
                con.connect();
                Log.i("HTTP", "iiiiiiiiii");

                while (true) {
                    // pickup the next cat picture
                    // query with  json
                    // use id is jason payload to check if already have that image id locally then use local image
                    // but for now, skip that, just to get this working, ie, step 8 in assignment
                    // use url in the json payload, save it to the device and update imageview

                   // there seems to be two methods to parse out JSON but its not clear which one is the best
                   // these static variables are for the json string method, but its unclear where the bitmap is

                    // json method A if you want all of the meta data, which i do not

                //    String tags;
                //    String createdAt;
                //    String updatedAt;
                //    String mimetype;
                //    Integer size;
                 //   String _id;

              //      final String JSON_STRING="{\"tags\":{\"createdAt\":\"2022-04-17T19:17:05.564Z\",\"updatedAt\":\"2022-10-11T07:52:32.651Z\",\"mimetype\":\"image/jpeg\",\"size\":280545,\"_id\":\"KyCpC9ckObUSgQ54\"}";
//     original   public final static String JSON_STRING="{"tags":["cat"],"createdAt":"2022-04-17T19:17:05.564Z","updatedAt":"2022-10-11T07:52:32.651Z","mimetype":"image/jpeg","size":280545,"_id":"KyCpC9ckObUSgQ54"}";


               //     JSONObject jsonObject = new JSONObject(JSON_STRING);
                    Log.i("HTTP", "222222222");
                     JSONObject jsonObject = new JSONObject(strUrlJSON);
                     // never makes it here *************************** resource failed to call close
                    Log.i("HTTP", "555555555");


                    // json method B
                //    JSONObject webImages = jsonObject.getJSONObject("WebImages");
                    Log.i("HTTP", "4444444444444444");
                    // dont really need meta data so not using these
                    // String imageName = webImages.getString("Imagename");
                    // String imageUrl = webImages.getString("imageurl");
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
                            Log.i("HTTP", "33333333");
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

                      // method A

                  //    final String JSON_STRING="{\"tags\":{\"createdAt\":\"2022-04-17T19:17:05.564Z\",\"updatedAt\":\"2022-10-11T07:52:32.651Z\",\"mimetype\":\"image/jpeg\",\"size\":280545,\"_id\":\"KyCpC9ckObUSgQ54\"}";
//     original   public final static String JSON_STRING="{"tags":["cat"],"createdAt":"2022-04-17T19:17:05.564Z","updatedAt":"2022-10-11T07:52:32.651Z","mimetype":"image/jpeg","size":280545,"_id":"KyCpC9ckObUSgQ54"}";

                     // JSONObject jsonObject = new JSONObject(JSON_STRING);
                      Log.i("HTTP", "aaaaaaaaaaa");
                         JSONObject jsonObject = new JSONObject(strUrlJSON);
                      Log.i("HTTP", "bbbbbbbbb");
                       jsonObject.getJSONObject("WebImages");
                      // never gets here, not sure why it fails getting json object
                      Log.i("HTTP", "ccccccccccc");
                   //   String imageUrl = jsonObject.getString("id");
                      String imageUrl = strUrl;
                      Log.i("HTTP", "eeeeeeeeeee");


                      // method B

//                      JSONObject jsonObject = new JSONObject(strUrl);
                  //    JSONObject webImages = jsonObject.getJSONObject("WebImages");
                  //    String imageName = webImages.getString("Imagename");
                 //     String imageUrl = webImages.getString("imageurl");

                      // display the image version 1
                      ImageView image = findViewById(R.id.imageCatViewer);
                      Bitmap bMap = BitmapFactory.decodeFile(imageUrl);
                     //  Bitmap bMap = BitmapFactory.decodeFile(imageUrl);
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