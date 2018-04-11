package kz.cheesenology.mvptest.ui.view;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpView;

public interface CarDetailView extends MvpView {

    void showDetailsCarData(String carName);
    void showUpdateResult(String text);
}
