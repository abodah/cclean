package org.abodah.petit.cclean.ui.intro;


import android.content.Intent;
import android.os.Bundle;

import androidx.lifecycle.ViewModelProviders;

import org.abodah.petit.cclean.R;
import org.abodah.petit.cclean.ViewModelProviderFactory;
import org.abodah.petit.cclean.auth.LoginActivity;
import org.abodah.petit.cclean.databinding.ActivitySplashBinding;
import org.abodah.petit.cclean.ui.base.BaseActivity;
import org.abodah.petit.cclean.ui.main.MainActivity;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity<ActivitySplashBinding, IntroViewModel> implements IntroNavigator {

    @Inject
    ViewModelProviderFactory factory;
    private IntroViewModel mSplashViewModel;

    @Override
    public int getBindingVariable() {
        return org.abodah.petit.cclean.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public IntroViewModel getViewModel() {
        mSplashViewModel = ViewModelProviders.of(this, factory).get(IntroViewModel.class);
        return mSplashViewModel;
    }

    @Override
    public void openLoginActivity() {
        Intent intent = LoginActivity.newIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void openMainActivity() {
        Intent intent = MainActivity.newIntent(SplashActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void openOnboardActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSplashViewModel.setNavigator(this);
        mSplashViewModel.startSeeding();
    }

}
