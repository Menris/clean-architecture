package kz.cheesenology.mvptest.data.repository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import kz.cheesenology.mvptest.data.db.LocalCars;
import kz.cheesenology.mvptest.data.db.LocalCarsMark;
import kz.cheesenology.mvptest.data.db.dao.CarsDao;

@Singleton
public class CarsRepository {

    private final CarsDao carsDao;

    @Inject
    public CarsRepository(CarsDao carsDao) {
        this.carsDao = carsDao;
    }

    public Flowable<List<LocalCarsMark>> getCars() {
        return carsDao.getCarsData()
                .subscribeOn(Schedulers.computation());
    }

    public Flowable<String> getCarName(Integer id) {
        return carsDao.getCarName(id)
                .subscribeOn(Schedulers.computation())
                .map(LocalCars::getCarName);
    }

    public int updateCarName(Integer passID, String newCarName) {
        return carsDao.updateCarName(passID,newCarName);
    }

    public void insertCar(LocalCars car) {
        carsDao.insertAll(car);
    }
}