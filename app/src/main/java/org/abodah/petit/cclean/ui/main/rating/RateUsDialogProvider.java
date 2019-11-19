package org.abodah.petit.cclean.ui.main.rating;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class RateUsDialogProvider {
    @ContributesAndroidInjector
    abstract RateUsDialog provideRateUsDialogFactory();
}
