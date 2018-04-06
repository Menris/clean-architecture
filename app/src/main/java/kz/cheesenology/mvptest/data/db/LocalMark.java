package kz.cheesenology.mvptest.data.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "mark")
public class LocalMark {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int markID;
    @ColumnInfo(name = "mark_name")
    private String markName;

    public int getMarkID() {
        return markID;
    }

    public void setMarkID(int markID) {
        this.markID = markID;
    }

    public String getMarkName() {
        return markName;
    }

    public void setMarkName(String markName) {
        this.markName = markName;
    }
}
