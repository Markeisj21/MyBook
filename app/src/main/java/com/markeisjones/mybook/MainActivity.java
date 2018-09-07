package com.markeisjones.mybook;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.request.RequestOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String JSON_URL = "http://de-coding-test.s3.amazonaws.com/books.json";
    private JsonArrayRequest  request;
    private RequestQueue requestQueue;
    private List<Book> listBook;
    private RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listBook =  new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerview_id);
        jsonrequest();

    }

    private void jsonrequest() {

        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length();i++){

                    try{
                        jsonObject = response.getJSONObject(i);
                        Book book = new Book();
                        book.setTitle(jsonObject.getString("title"));
                        book.setAuthor(jsonObject.getString("author"));
                        book.setImageURL(jsonObject.getString("imageURL"));
                        listBook.add(book);


                    }catch (JSONException e){
                        e.printStackTrace();
                    }
                }
                setuprecylerview(listBook);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
         requestQueue = Volley.newRequestQueue(MainActivity.this);
         requestQueue.add(request);
    }

    private void setuprecylerview(List<Book> listBook) {
        BookAdapter myadapter =  new BookAdapter(this, listBook);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);
    }
}



