package kz.cheesenology.mvptest.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import kz.cheesenology.mvptest.data.db.dao.CarsDao;
import kz.cheesenology.mvptest.data.repository.CarsRepository;
import kz.cheesenology.mvptest.ui.view.CarsView;

@InjectViewState
public class CarsPresenter extends MvpPresenter<CarsView> {

    public void getCarsData() {

        //getViewState().showData();
    }
}
