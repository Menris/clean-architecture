package kz.cheesenology.mvptest.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import kz.cheesenology.mvptest.MvpApplication;
import kz.cheesenology.mvptest.R;
import kz.cheesenology.mvptest.data.db.LocalCars;
import kz.cheesenology.mvptest.data.db.LocalMark;
import kz.cheesenology.mvptest.data.db.dao.CarsDao;
import kz.cheesenology.mvptest.data.db.dao.MarkDao;
import kz.cheesenology.mvptest.presenter.MainPresenter;
import kz.cheesenology.mvptest.ui.view.MainView;

public class MainActivity extends MvpAppCompatActivity
        implements MainView {

    @InjectPresenter
    MainPresenter presenter;

    @Inject
    CarsDao carsDao;
    @Inject
    MarkDao markDao;

    @BindView(R.id.btnSwitchActivity)
    Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MvpApplication.app().appComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.runSwitcher();
            }
        });

        //populateCarsWithData();
    }

    private LocalCars addCar(LocalCars cars) {
        carsDao.insertAll(cars);
        return cars;
    }

    private LocalMark addMark(LocalMark cars) {
        markDao.insertAll(cars);
        return cars;
    }


    private void populateCarsWithData() {
        //adding marks
        LocalMark mark = new LocalMark();
        mark.setMarkID(1);
        mark.setMarkName("Ferrari");
        addMark(mark);
        //adding cars
        LocalCars cars = new LocalCars();
        cars.setCarName("Enzo");
        cars.setMarkID(1);
        addCar(cars);
    }

    @Override
    public void switchActivity() {
        Toast.makeText(this, "Switch toast from presenter", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), CarsActivity.class));
    }
}
