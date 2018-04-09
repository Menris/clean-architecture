package kz.cheesenology.mvptest.di;

import javax.inject.Singleton;

import dagger.Component;
import kz.cheesenology.mvptest.ui.activity.CarsActivity;
import kz.cheesenology.mvptest.ui.activity.MainActivity;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);
    void inject(CarsActivity carsActivity);
}