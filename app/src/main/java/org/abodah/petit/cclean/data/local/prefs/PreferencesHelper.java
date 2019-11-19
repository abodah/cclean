package org.abodah.petit.cclean.data.local.prefs;

import org.abodah.petit.cclean.data.DataManager;

public interface PreferencesHelper {
    String getAccessToken();

    void setAccessToken(String accessToken);

    String getCurrentUserEmail();

    void setCurrentUserEmail(String email);

    Long getCurrentUserId();

    void setCurrentUserId(Long userId);

    int getCurrentUserLoggedInMode();

    void setCurrentUserLoggedInMode(DataManager.LoggedInMode mode);

    String getCurrentUserName();

    void setCurrentUserName(String userName);

    String getCurrentUserProfilePicUrl();

    void setCurrentUserProfilePicUrl(String profilePicUrl);

    String getFirstAppLaunch();

    void setFirstAppLaunch(String firstAppLaunch);
}
