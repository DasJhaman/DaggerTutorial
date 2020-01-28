package com.jhaman.daggerTutorial.di.module;

import android.content.Context;

import com.jhaman.daggerTutorial.di.scopes.ApplicationScope;
import com.jhaman.daggerTutorial.qualifier.ApplicationContext;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    public Context provideContext() {
        return context;
    }
}
