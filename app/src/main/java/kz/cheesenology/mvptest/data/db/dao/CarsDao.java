package kz.cheesenology.mvptest.data.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import kz.cheesenology.mvptest.data.db.LocalCars;

@Dao
public interface CarsDao {
    @Query("SELECT * from cars")
    List<LocalCars> getCarsData();
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(LocalCars... cars);
}
