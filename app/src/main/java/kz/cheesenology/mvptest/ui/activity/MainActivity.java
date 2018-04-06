package kz.cheesenology.mvptest.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import kz.cheesenology.mvptest.R;
import kz.cheesenology.mvptest.data.db.LocalCars;
import kz.cheesenology.mvptest.data.db.LocalMark;
import kz.cheesenology.mvptest.data.db.dao.AppDatabase;
import kz.cheesenology.mvptest.presenter.MainPresenter;
import kz.cheesenology.mvptest.ui.view.MainView;

public class MainActivity extends MvpAppCompatActivity
        implements MainView {

    @InjectPresenter
    MainPresenter presenter;

    Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClick = findViewById(R.id.btnSwitchActivity);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.runSwitcher();
            }
        });

        populateCarsWithData(AppDatabase.getAppDatabase(getApplicationContext()));
    }

    private LocalCars addCar(final AppDatabase db, LocalCars cars) {
        db.carsDao().insertAll(cars);
        return cars;
    }

    private LocalMark addMark(final AppDatabase db, LocalMark cars) {
        db.markDao().insertAll(cars);
        return cars;
    }


    private void populateCarsWithData(AppDatabase db) {
        //adding marks
        LocalMark mark = new LocalMark();
        mark.setMarkID(1);
        mark.setMarkName("Ferrari");
        addMark(db, mark);
        //adding cars
        LocalCars cars = new LocalCars();
        cars.setCarName("Enzo");
        cars.setMarkID(1);
        addCar(db, cars);


    }

    @Override
    public void switchActivity() {
        Toast.makeText(this, "Switch toast from presenter", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), CarsActivity.class));
    }
}
