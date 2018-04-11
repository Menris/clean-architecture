package kz.cheesenology.mvptest.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import kz.cheesenology.mvptest.R;
import kz.cheesenology.mvptest.presenter.CarDetailPresenter;
import kz.cheesenology.mvptest.ui.view.CarDetailView;

public class CarDetailActivity extends MvpAppCompatActivity implements CarDetailView {

    @InjectPresenter
    CarDetailPresenter presenter;

    @BindView(R.id.btn_save)
    Button btnOK;
    @BindView(R.id.et_car)
    EditText etCarName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_detail);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        final Integer passID = intent.getIntExtra("car_id", 0);
        presenter.getDetails(passID);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.updateValue(passID, etCarName.getText().toString());
            }
        });
    }

    @Override
    public void showDetailsCarData(String carName) {
        etCarName.setText(carName);
    }

    @Override
    public void showUpdateResult(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
