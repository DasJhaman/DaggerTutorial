package com.jhaman.daggerTutorial.di.components;


import android.content.Context;

import com.jhaman.daggerTutorial.MainActivity;
import com.jhaman.daggerTutorial.di.module.AdapterModule;
import com.jhaman.daggerTutorial.di.scopes.ActivityScope;
import com.jhaman.daggerTutorial.qualifier.ActivityContext;

import dagger.Component;

@ActivityScope
@Component(modules = AdapterModule.class, dependencies = ApplicationComponent.class)
public interface MainActivityComponent {

    @ActivityContext
    Context getContext();


    void injectMainActivity(MainActivity mainActivity);
}
