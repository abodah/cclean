package org.abodah.petit.cclean.di.builder;

import org.abodah.petit.cclean.auth.LoginActivity;
import org.abodah.petit.cclean.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public class ActivityBuilder {
    @ContributesAndroidInjector(modules = {
            FeedActivityModule.class,
            BlogFragmentProvider.class,
            OpenSourceFragmentProvider.class})
    abstract FeedActivity bindFeedActivity();

    @ContributesAndroidInjector
    abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector(modules = {
            AboutFragmentProvider.class,
            RateUsDialogProvider.class})
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector
    abstract StartActivity bindSplashActivity();

}
