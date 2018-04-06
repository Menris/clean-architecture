package kz.cheesenology.mvptest.ui.activity;

import android.os.Bundle;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import kz.cheesenology.mvptest.R;
import kz.cheesenology.mvptest.presenter.CarsPresenter;
import kz.cheesenology.mvptest.ui.view.CarsView;

public class CarsActivity extends MvpAppCompatActivity
        implements CarsView {

    @InjectPresenter
    CarsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getCarsData();
    }

    @Override
    public void showData() {
        Toast.makeText(this, "Cars Toast", Toast.LENGTH_SHORT).show();
    }
}
