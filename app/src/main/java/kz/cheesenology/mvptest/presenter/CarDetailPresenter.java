package kz.cheesenology.mvptest.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
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

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    //Логика получения деталей машины
    public void getDetails(Integer passID) {
        Disposable disposable = carsRepository.getCarName(passID)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        // on next
                        (name) -> getViewState().showDetailsCarData(name),
                        // on error
                        Throwable::printStackTrace);
        compositeDisposable.add(disposable);
    }

    public void updateValue(Integer passID, String newCarName) {
        int i = carsRepository.updateCarName(passID, newCarName);
        if (i > 0) {
            getViewState().showUpdateResult("Данные успешно изменены");
        } else {
            getViewState().showUpdateResult("Ошибка при обновлении");
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }
}
