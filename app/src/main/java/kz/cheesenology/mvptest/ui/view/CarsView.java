package kz.cheesenology.mvptest.ui.view;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import dagger.Component;
import kz.cheesenology.mvptest.data.db.LocalCars;
import kz.cheesenology.mvptest.data.db.LocalCarsMark;
import kz.cheesenology.mvptest.di.ApplicationModule;

public interface CarsView extends MvpView {

    void showData(List<LocalCarsMark> list);
}
