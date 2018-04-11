package kz.cheesenology.mvptest.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import kz.cheesenology.mvptest.MvpApplication;
import kz.cheesenology.mvptest.R;
import kz.cheesenology.mvptest.data.db.LocalCarsMark;
import kz.cheesenology.mvptest.data.db.dao.CarsDao;
import kz.cheesenology.mvptest.presenter.CarsPresenter;
import kz.cheesenology.mvptest.ui.adapter.CarsAdapter;
import kz.cheesenology.mvptest.ui.view.CarsView;

public class CarsActivity extends MvpAppCompatActivity
        implements CarsView {

    @InjectPresenter
    CarsPresenter presenter;

    @BindView(R.id.rv_cars)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars);

        ButterKnife.bind(this);

        GridLayoutManager gridLayout = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayout);
        recyclerView.setHasFixedSize(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.getCarsData();
    }

    @Override
    public void showData(List<LocalCarsMark> list) {
        CarsAdapter adapter = new CarsAdapter(list);
        adapter.setCallback(new CarsAdapter.Callback() {
            @Override
            public void onClick(LocalCarsMark model) {
                Toast.makeText(CarsActivity.this, model.getLocalCars().getCarName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), CarDetailActivity.class);
                intent.putExtra("car_id", model.getLocalCars().getCarID());
                startActivity(intent);
            }

            @Override
            public void onLongClick(LocalCarsMark model) {
                Toast.makeText(CarsActivity.this, model.getLocalMark().getMarkName(), Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);
    }
}
