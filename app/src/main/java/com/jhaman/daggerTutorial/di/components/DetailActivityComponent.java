package com.jhaman.daggerTutorial.di.components;


import com.jhaman.daggerTutorial.DetailActivity;
import com.jhaman.daggerTutorial.di.scopes.ActivityScope;

import dagger.Component;

@Component(dependencies = ApplicationComponent.class)
@ActivityScope
public interface DetailActivityComponent {

    void inject(DetailActivity detailActivity);
}
