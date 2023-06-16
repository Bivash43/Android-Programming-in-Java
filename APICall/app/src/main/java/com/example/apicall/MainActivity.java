package com.example.apicall;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Single Object
    private static final String API_URL = "https://jsonplaceholder.typicode.com/posts/1";

    //Multiple Objects
    private static final String API_URL_1 = "https://jsonplaceholder.typicode.com/posts";

    TextView tv1 , tv2;
    ListView l1;
    List<String> title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*-----------------Viewing Single Object Only------------*/
        /*tv1 = findViewById(R.id.Text);
        tv2 = findViewById(R.id.Text2);


        JsonObjectRequest jsonObject = new JsonObjectRequest(Request.Method.GET, API_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    tv1.setText(response.get("title").toString());
                    tv2.setText(response.get("body").toString());
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "ERROR ERROR", Toast.LENGTH_SHORT).show();
            }
        });

        Volley.newRequestQueue(this).add(jsonObject);*/


        /*------------------Viewing Multiple Object in List View------------------*/

        l1 = findViewById(R.id.List);
        title = new ArrayList<>();
        JsonArrayRequest jsonArray = new JsonArrayRequest(Request.Method.GET, API_URL_1, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0; i<response.length() ; i++){
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        String titleResponse = jsonObject.getString("title");
                        Log.d("API CALL: " , "On Response" + titleResponse );
                        title.add(titleResponse);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MainActivity.this , android.R.layout.simple_list_item_1 , title);
                l1.setAdapter(arrayAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_SHORT).show();
            }
        });

        Volley.newRequestQueue(this).add(jsonArray);

    }
}