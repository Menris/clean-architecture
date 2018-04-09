package kz.cheesenology.mvptest.data.repository;

import javax.inject.Inject;

import kz.cheesenology.mvptest.data.db.dao.CarsDao;

public class CarsRepository {
    @Inject
    CarsDao carsDao;
}