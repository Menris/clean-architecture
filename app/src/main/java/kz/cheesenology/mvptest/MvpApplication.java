package kz.cheesenology.mvptest;

import android.app.Application;

import com.facebook.stetho.Stetho;

import dagger.android.DaggerApplication;
import dagger.android.DaggerService;
import dagger.android.support.DaggerAppCompatActivity;
import kz.cheesenology.mvptest.data.db.dao.AppDatabase;
import kz.cheesenology.mvptest.di.ApplicationComponent;
import kz.cheesenology.mvptest.di.ApplicationModule;
import kz.cheesenology.mvptest.di.DaggerApplicationComponent;

public class MvpApplication extends Application {
    private static MvpApplication app;
    private ApplicationComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        app = this;

        appComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(getApplicationContext())).build();
    }

    public static MvpApplication app() {
        return app;
    }

    public ApplicationComponent appComponent() {
        return appComponent;
    }
}
