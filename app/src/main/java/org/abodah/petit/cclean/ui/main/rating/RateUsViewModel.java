package org.abodah.petit.cclean.ui.main.rating;

import org.abodah.petit.cclean.data.DataManager;
import org.abodah.petit.cclean.ui.base.BaseViewModel;
import org.abodah.petit.cclean.utils.rx.SchedulerProvider;

public class RateUsViewModel extends BaseViewModel<RateUsCallback> {

    public RateUsViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void onLaterClick() {
        getNavigator().dismissDialog();
    }

    public void onSubmitClick() {
        getNavigator().dismissDialog();
    }
}