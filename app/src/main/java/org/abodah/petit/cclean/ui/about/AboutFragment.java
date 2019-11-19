package org.abodah.petit.cclean.ui.about;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import org.abodah.petit.cclean.R;
import org.abodah.petit.cclean.ViewModelProviderFactory;
import org.abodah.petit.cclean.databinding.AboutFragmentBinding;
import org.abodah.petit.cclean.ui.base.BaseFragment;

import javax.inject.Inject;

public class AboutFragment extends BaseFragment<AboutFragmentBinding, AboutViewModel> implements AboutNavigator {

    public static final String TAG = AboutFragment.class.getSimpleName();
    @Inject
    ViewModelProviderFactory factory;
    private AboutViewModel mAboutViewModel;

    public static AboutFragment newInstance() {
        Bundle args = new Bundle();
        AboutFragment fragment = new AboutFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getBindingVariable() {
        return org.abodah.petit.cclean.BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.about_fragment;
    }

    @Override
    public AboutViewModel getViewModel() {
        mAboutViewModel = ViewModelProviders.of(this, factory).get(AboutViewModel.class);
        return mAboutViewModel;
    }

    @Override
    public void goBack() {
        getBaseActivity().onFragmentDetached(TAG);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAboutViewModel.setNavigator(this);
    }

}
