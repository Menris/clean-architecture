package kz.cheesenology.mvptest.di;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import kz.cheesenology.mvptest.data.db.dao.AppDatabase;
import kz.cheesenology.mvptest.data.db.dao.CarsDao;
import kz.cheesenology.mvptest.data.db.dao.MarkDao;

@Module
public class ApplicationModule {

    private Context context;

    public ApplicationModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    public Context provideContext() {
        return context;
    }

    @Singleton
    @Provides
    public AppDatabase provideMyDatabase(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, "mycars")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }

    @Singleton
    @Provides
    public CarsDao provideCarsDao(AppDatabase myDatabase) {
        return myDatabase.carsDao();
    }

    @Singleton
    @Provides
    public MarkDao provideMarkDao(AppDatabase myDatabase) {
        return myDatabase.markDao();
    }
}
