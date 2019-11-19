package org.abodah.petit.cclean.ui.about;


import org.abodah.petit.cclean.data.DataManager;
import org.abodah.petit.cclean.ui.base.BaseViewModel;
import org.abodah.petit.cclean.utils.rx.SchedulerProvider;

public class AboutViewModel extends BaseViewModel<AboutNavigator> {

    public AboutViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void onNavBackClick() {
        getNavigator().goBack();
    }

}
