package kz.cheesenology.mvptest.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import kz.cheesenology.mvptest.MvpApplication;
import kz.cheesenology.mvptest.data.repository.CarsRepository;
import kz.cheesenology.mvptest.ui.view.CarDetailView;

@InjectViewState
public class CarDetailPresenter extends MvpPresenter<CarDetailView> {

    @Inject
    public CarsRepository carsRepository;

    public CarDetailPresenter() {
        MvpApplication.app().appComponent().inject(this);
    }

    //Логика получения деталей машины
    public void getDetails(Integer passID) {
        String carName = carsRepository.getCarName(passID);
        getViewState().showDetailsCarData(carName);
    }

    public void updateValue(Integer passID, String newCarName) {
        int i = carsRepository.updateCarName(passID, newCarName);
        if (i > 0) {
            getViewState().showUpdateResult("Данные успешно изменены");
        } else {
            getViewState().showUpdateResult("Ошибка при обновлении");
        }
    }
}
