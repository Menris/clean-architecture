package kz.cheesenology.mvptest.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kz.cheesenology.mvptest.MvpApplication;
import kz.cheesenology.mvptest.data.db.LocalCars;
import kz.cheesenology.mvptest.data.db.LocalCarsMark;
import kz.cheesenology.mvptest.data.repository.CarsRepository;
import kz.cheesenology.mvptest.ui.view.CarsView;

@InjectViewState
public class CarsPresenter extends MvpPresenter<CarsView> {

    @Inject
    public CarsRepository carsRepository;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public CarsPresenter() {
        MvpApplication.app().appComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        Disposable disposable = carsRepository.getCars()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        // On Next
                        (list) -> getViewState().showData(list),
                        // On error
                        Throwable::printStackTrace,
                        // On Complete
                        () -> { /* On Complete */ } );
        compositeDisposable.add(disposable);
    }


    public void insertRandomCar() {
        LocalCars car = new LocalCars();
        car.setCarName("My car");
        car.setMarkID(1);
        carsRepository.insertCar(car);
    }

    @Override
    public void onDestroy() {
        compositeDisposable.clear();
    }
}
