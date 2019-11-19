package org.abodah.petit.cclean.data.remote;

import org.abodah.petit.cclean.data.model.api.BlogResponse;
import org.abodah.petit.cclean.data.model.api.LoginRequest;
import org.abodah.petit.cclean.data.model.api.LoginResponse;

import io.reactivex.Single;

public interface ApiHelper {
    Single<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest request);

    Single<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest request);

//    Single<LogoutResponse> doLogoutApiCall();

    Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request);

    ApiHeader getApiHeader();

    Single<BlogResponse> getBlogApiCall();

//    Single<OpenSourceResponse> getOpenSourceApiCall();

}
