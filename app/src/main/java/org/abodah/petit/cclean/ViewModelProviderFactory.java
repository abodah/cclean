package org.abodah.petit.cclean;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import org.abodah.petit.cclean.data.DataManager;
import org.abodah.petit.cclean.ui.intro.IntroViewModel;
import org.abodah.petit.cclean.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ViewModelProviderFactory extends ViewModelProvider.NewInstanceFactory {

    private final DataManager dataManager;
    private final SchedulerProvider schedulerProvider;

    @Inject
    public ViewModelProviderFactory(DataManager dataManager,
                                    SchedulerProvider schedulerProvider) {
        this.dataManager = dataManager;
        this.schedulerProvider = schedulerProvider;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
//        if (modelClass.isAssignableFrom(AboutViewModel.class)) {
//            //noinspection unchecked
//            return (T) new AboutViewModel(dataManager,schedulerProvider);
//        } else if (modelClass.isAssignableFrom(FeedViewModel.class)) {
//            //noinspection unchecked
//            return (T) new FeedViewModel(dataManager,schedulerProvider);
//        } else if (modelClass.isAssignableFrom(LoginViewModel.class)) {
//            //noinspection unchecked
//            return (T) new LoginViewModel(dataManager,schedulerProvider);
//        } else if (modelClass.isAssignableFrom(MainViewModel.class)) {
//            //noinspection unchecked
//            return (T) new MainViewModel(dataManager,schedulerProvider);
//        }
//        else if (modelClass.isAssignableFrom(BlogViewModel.class)) {
//            //noinspection unchecked
//            return (T) new BlogViewModel(dataManager,schedulerProvider);
//        }
//        else if (modelClass.isAssignableFrom(RateUsViewModel.class)) {
//            //noinspection unchecked
//            return (T) new RateUsViewModel(dataManager,schedulerProvider);
//        }
//        else if (modelClass.isAssignableFrom(OpenSourceViewModel.class)) {
//            //noinspection unchecked
//            return (T) new OpenSourceViewModel(dataManager,schedulerProvider);
//        }
//        else
        if (modelClass.isAssignableFrom(IntroViewModel.class)) {
            //noinspection unchecked
            return (T) new IntroViewModel(dataManager, schedulerProvider);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }

}
