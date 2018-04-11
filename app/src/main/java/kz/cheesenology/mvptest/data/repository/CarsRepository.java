package kz.cheesenology.mvptest.data.repository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

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

    public List<LocalCarsMark> getCars() {
        return carsDao.getCarsData();
    }

    public String getCarName(Integer id) {
        LocalCars model = carsDao.getCarName(id);
        return model.getCarName();
    }

    public int updateCarName(Integer passID, String newCarName) {
        return carsDao.updateCarName(passID,newCarName);
    }
}