package kz.cheesenology.mvptest.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import kz.cheesenology.mvptest.ui.view.MainView;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    public void runSwitcher() {
        getViewState().switchActivity();
    }
}
