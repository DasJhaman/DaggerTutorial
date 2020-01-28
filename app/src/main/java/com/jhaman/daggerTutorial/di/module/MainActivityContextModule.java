package com.jhaman.daggerTutorial.di.module;

import android.content.Context;

import com.jhaman.daggerTutorial.MainActivity;
import com.jhaman.daggerTutorial.di.scopes.ActivityScope;
import com.jhaman.daggerTutorial.qualifier.ActivityContext;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityContextModule {

    private MainActivity mainActivity;

    public Context context;

    public MainActivityContextModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.context = mainActivity;
    }


    @Provides
    @ActivityScope
    public MainActivity providesMainActivity() {
        return mainActivity;
    }

    @Provides
    @ActivityScope
    @ActivityContext
    public Context provideContext() {
        return context;
    }
}