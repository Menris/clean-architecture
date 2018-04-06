package kz.cheesenology.mvptest.data.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "cars",
        foreignKeys = @ForeignKey(
                entity = LocalMark.class,
                parentColumns = "id",
                childColumns = "mark_id")
)
public class LocalCars {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "car_id")
    private int carID;
    @ColumnInfo(name = "car_name")
    private String carName;
    @ColumnInfo(name = "mark_id")
    private int markID;

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getMarkID() {
        return markID;
    }

    public void setMarkID(int markID) {
        this.markID = markID;
    }
}
