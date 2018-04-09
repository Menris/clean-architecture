package kz.cheesenology.mvptest.ui.view;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import kz.cheesenology.mvptest.data.db.LocalCars;
import kz.cheesenology.mvptest.data.db.LocalCarsMark;

public interface CarsView extends MvpView {

    void showData(List<LocalCarsMark> list);
}
