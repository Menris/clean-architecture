package kz.cheesenology.mvptest.data.db;

import android.arch.persistence.room.Embedded;

public class LocalCarsMark {

    @Embedded
    private
    LocalCars localCars;

    @Embedded
    private
    LocalMark localMark;

    public LocalCars getLocalCars() {
        return localCars;
    }

    public void setLocalCars(LocalCars localCars) {
        this.localCars = localCars;
    }

    public LocalMark getLocalMark() {
        return localMark;
    }

    public void setLocalMark(LocalMark localMark) {
        this.localMark = localMark;
    }
}
