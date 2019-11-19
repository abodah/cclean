package org.abodah.petit.cclean.ui.intro;

import org.abodah.petit.cclean.data.DataManager;
import org.abodah.petit.cclean.ui.base.BaseViewModel;
import org.abodah.petit.cclean.utils.rx.SchedulerProvider;

public class IntroViewModel extends BaseViewModel<IntroNavigator> {

    public IntroViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void startSeeding() {
//        getCompositeDisposable().add(getDataManager()
//                .seedDatabaseQuestions()
//                .flatMap(aBoolean -> getDataManager().seedDatabaseOptions())
//                .subscribeOn(getSchedulerProvider().io())
//                .observeOn(getSchedulerProvider().ui())
//                .subscribe(aBoolean -> {
//                    decideNextActivity();
//                }, throwable -> {
//                    decideNextActivity();
//                }));
    }

    private void decideNextActivity() {
        if (!getDataManager().getFirstAppLaunch().equals("FIRST")) {
            getNavigator().openOnboardActivity();
        }
        if (getDataManager().getCurrentUserLoggedInMode() == DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.getType()) {
            getNavigator().openLoginActivity();
        } else {
            getNavigator().openMainActivity();
        }
    }

}
