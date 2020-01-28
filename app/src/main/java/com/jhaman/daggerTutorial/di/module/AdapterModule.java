package com.jhaman.daggerTutorial.di.module;

import com.jhaman.daggerTutorial.MainActivity;
import com.jhaman.daggerTutorial.adapter.RecyclerViewAdapter;
import com.jhaman.daggerTutorial.di.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module(includes = {MainActivityContextModule.class})
public class AdapterModule {

    @Provides
    @ActivityScope
    public RecyclerViewAdapter getStarWarsPeopleLIst(RecyclerViewAdapter.ClickListener clickListener) {
        return new RecyclerViewAdapter(clickListener);
    }

    @Provides
    @ActivityScope
    public RecyclerViewAdapter.ClickListener getClickListener(MainActivity mainActivity) {
        return mainActivity;
    }
}
