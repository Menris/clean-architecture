package kz.cheesenology.mvptest.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import javax.inject.Inject;

import kz.cheesenology.mvptest.data.db.LocalCarsMark;
import kz.cheesenology.mvptest.data.db.dao.AppDatabase;
import kz.cheesenology.mvptest.data.db.dao.CarsDao;
import kz.cheesenology.mvptest.ui.view.CarsView;

@InjectViewState
public class CarsPresenter extends MvpPresenter<CarsView> {

    public void getCarsData(AppDatabase appDatabase) {
        List<LocalCarsMark> list = appDatabase.carsDao().getCarsData();

        getViewState().showData(list);
    }

    public void getCarsData(CarsDao carsDao) {
        List<LocalCarsMark> list = carsDao.getCarsData();

        getViewState().showData(list);
    }
}
