package kz.cheesenology.mvptest.data.db;

import android.arch.persistence.room.ColumnInfo;

public class LocalCarTuple {
    @ColumnInfo(name = "car_id")
    private int carId;

    @ColumnInfo(name = "car_name")
    private String carName;

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }
}
