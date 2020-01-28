package com.jhaman.daggerTutorial.di.components;

import android.content.Context;

import com.jhaman.daggerTutorial.MyApplication;
import com.jhaman.daggerTutorial.di.module.ContextModule;
import com.jhaman.daggerTutorial.di.module.RetrofitModule;
import com.jhaman.daggerTutorial.di.retrofit.APIInterface;
import com.jhaman.daggerTutorial.di.scopes.ApplicationScope;
import com.jhaman.daggerTutorial.qualifier.ApplicationContext;

import dagger.Component;


@ApplicationScope
@Component(modules = {ContextModule.class, RetrofitModule.class})
public interface ApplicationComponent {

    public APIInterface getApiInterface();

    @ApplicationContext
    public Context getContext();

    public void injectApplication(MyApplication myApplication);
}
