package kz.cheesenology.mvptest.di;

import javax.inject.Singleton;

import dagger.Component;
import kz.cheesenology.mvptest.data.repository.CarsRepository;
import kz.cheesenology.mvptest.presenter.CarDetailPresenter;
import kz.cheesenology.mvptest.presenter.CarsPresenter;
import kz.cheesenology.mvptest.ui.activity.CarsActivity;
import kz.cheesenology.mvptest.ui.activity.MainActivity;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(CarsActivity carsActivity);

    void inject(CarsPresenter carsPresenter);

    void inject(CarDetailPresenter carDetailPresenter);
}