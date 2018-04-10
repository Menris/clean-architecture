package kz.cheesenology.mvptest.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import kz.cheesenology.mvptest.ui.view.CarDetailView;

@InjectViewState
public class CarDetailPresenter extends MvpPresenter<CarDetailView> {

    //Логика получения деталей машины
    public void getDetails(Integer passID) {

        getViewState().showDetailsCarData();
    }
}
