package com.example.retrofit;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static String api="https://jsonplaceholder.typicode.com/";
    List<UserModel> alluserslist;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
recyclerView = findViewById(R.id.recycler);
recyclerView.setLayoutManager(new LinearLayoutManager(this));

      RetrofitIncetence.getIncetence().apiInterface.getusers().enqueue(new Callback<List<UserModel>>() {
          @Override
          public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
              alluserslist =response.body();
              recyclerView.setAdapter(new userAdaptor(MainActivity.this,alluserslist));
              for(int i=0;i<alluserslist.size();i++){
                  Log.e("API", "onResponse: "+alluserslist.get(i).getTitle() );
              }
           }

          @Override
          public void onFailure(Call<List<UserModel>> call, Throwable throwable) {
              Log.e("API", "onFailure: "+ throwable.getLocalizedMessage());
          }
      });
    }
}