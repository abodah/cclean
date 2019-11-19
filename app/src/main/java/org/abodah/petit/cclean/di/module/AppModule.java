package org.abodah.petit.cclean.di.module;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.abodah.petit.cclean.BuildConfig;
import org.abodah.petit.cclean.R;
import org.abodah.petit.cclean.data.AppDataManager;
import org.abodah.petit.cclean.data.DataManager;
import org.abodah.petit.cclean.data.local.db.AppDatabase;
import org.abodah.petit.cclean.data.local.db.AppDbHelper;
import org.abodah.petit.cclean.data.local.db.DbHelper;
import org.abodah.petit.cclean.data.local.prefs.AppPreferencesHelper;
import org.abodah.petit.cclean.data.local.prefs.PreferencesHelper;
import org.abodah.petit.cclean.data.remote.ApiHeader;
import org.abodah.petit.cclean.data.remote.ApiHelper;
import org.abodah.petit.cclean.data.remote.AppApiHelper;
import org.abodah.petit.cclean.di.ApiInfo;
import org.abodah.petit.cclean.di.DatabaseInfo;
import org.abodah.petit.cclean.di.PreferenceInfo;
import org.abodah.petit.cclean.utils.AppConstants;
import org.abodah.petit.cclean.utils.rx.AppSchedulerProvider;
import org.abodah.petit.cclean.utils.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

@Module
public class AppModule {
    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(@DatabaseInfo String dbName, Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, dbName).fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }

    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
                                                           PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey,
                preferencesHelper.getCurrentUserId(),
                preferencesHelper.getAccessToken());
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

}
