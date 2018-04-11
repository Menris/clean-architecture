package kz.cheesenology.mvptest.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.List;

import javax.inject.Inject;

import kz.cheesenology.mvptest.MvpApplication;
import kz.cheesenology.mvptest.data.db.LocalCarsMark;
import kz.cheesenology.mvptest.data.repository.CarsRepository;
import kz.cheesenology.mvptest.ui.view.CarsView;

@InjectViewState
public class CarsPresenter extends MvpPresenter<CarsView> {

    @Inject
    public CarsRepository carsRepository;

    public CarsPresenter() {
        MvpApplication.app().appComponent().inject(this);
    }

    public void getCarsData() {
        List<LocalCarsMark> list = carsRepository.getCars();

        getViewState().showData(list);
    }
}
