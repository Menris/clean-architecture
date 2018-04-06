package kz.cheesenology.mvptest;

import android.app.Application;

import com.facebook.stetho.Stetho;

import kz.cheesenology.mvptest.di.ApplicationComponent;

public class MvpApplication extends Application {
    private static MvpApplication app;
    private ApplicationComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        app = this;


        /*appComponent = .builder()
                .appModule(new AppModule(getApplicationContext())).build();*/
    }

    public static MvpApplication app(){
        return app;
    }

    public ApplicationComponent appComponent(){
        return appComponent;
    }
}
