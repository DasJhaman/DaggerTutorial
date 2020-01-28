package com.jhaman.daggerTutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.jhaman.daggerTutorial.adapter.RecyclerViewAdapter;
import com.jhaman.daggerTutorial.di.components.ApplicationComponent;
import com.jhaman.daggerTutorial.di.components.DaggerMainActivityComponent;
import com.jhaman.daggerTutorial.di.components.MainActivityComponent;
import com.jhaman.daggerTutorial.di.module.MainActivityContextModule;
import com.jhaman.daggerTutorial.di.pojo.StarWars;
import com.jhaman.daggerTutorial.di.retrofit.APIInterface;
import com.jhaman.daggerTutorial.qualifier.ActivityContext;
import com.jhaman.daggerTutorial.qualifier.ApplicationContext;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity  implements RecyclerViewAdapter.ClickListener {
    private RecyclerView recyclerView;
    MainActivityComponent mainActivityComponent;

    @Inject
    public RecyclerViewAdapter recyclerViewAdapter;

    @Inject
    public APIInterface apiInterface;

    @Inject
    @ApplicationContext
    public Context mContext;

    @Inject
    @ActivityContext
    public Context activityContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        ApplicationComponent applicationComponent = MyApplication.get(MainActivity.this).getApplicationComponent();
        mainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityContextModule(new MainActivityContextModule(this))
                .applicationComponent(applicationComponent)
                .build();

        mainActivityComponent.injectMainActivity(this);
        recyclerView.setAdapter(recyclerViewAdapter);
        apiInterface.getPeople("json").enqueue(new Callback<StarWars>() {
            @Override
            public void onResponse(Call<StarWars> call, Response<StarWars> response) {
                populateRecyclerView(response.body().results);
            }

            @Override
            public void onFailure(Call<StarWars> call, Throwable t) {

            }
        });
    }
    private void populateRecyclerView(List<StarWars.People> response) {
        recyclerViewAdapter.setData(response);
    }
    @Override
    public void launchIntent(String filmName) {

        Toast.makeText(MainActivity.this, ""+filmName,Toast.LENGTH_LONG).show();

    }
}
