package org.abodah.petit.cclean.data;

import org.abodah.petit.cclean.data.local.db.DbHelper;
import org.abodah.petit.cclean.data.local.prefs.PreferencesHelper;
import org.abodah.petit.cclean.data.remote.ApiHelper;

public interface DataManager extends DbHelper, PreferencesHelper, ApiHelper {

    void setUserAsLoggedOut();

    void updateApiHeader(Long userId, String accessToken);

    void updateUserInfo(
            String accessToken,
            Long userId,
            LoggedInMode loggedInMode,
            String userName,
            String email,
            String profilePicPath);

    enum LoggedInMode {

        LOGGED_IN_MODE_LOGGED_OUT(0),
        LOGGED_IN_MODE_GOOGLE(1),
        LOGGED_IN_MODE_FB(2),
        LOGGED_IN_MODE_SERVER(3);

        private final int mType;

        LoggedInMode(int type) {
            mType = type;
        }

        public int getType() {
            return mType;
        }
    }

}
