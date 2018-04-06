package kz.cheesenology.mvptest.data.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import kz.cheesenology.mvptest.data.db.LocalCars;
import kz.cheesenology.mvptest.data.db.LocalMark;

@Dao
public interface MarkDao {
    @Query("SELECT * from mark")
    List<LocalMark> getMarkData();
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(LocalMark... marks);
}
