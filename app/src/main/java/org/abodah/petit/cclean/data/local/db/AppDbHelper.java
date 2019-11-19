package org.abodah.petit.cclean.data.local.db;

import org.abodah.petit.cclean.data.model.db.Post;
import org.abodah.petit.cclean.data.model.db.User;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class AppDbHelper implements DbHelper {
    private final AppDatabase mAppDatabase;

    @Inject
    public AppDbHelper(AppDatabase appDatabase) {
        this.mAppDatabase = appDatabase;
    }


    @Override
    public Observable<List<User>> getAllUsers() {
        return Observable.fromCallable(() -> mAppDatabase.userDao().loadAll());
    }


    @Override
    public Observable<Boolean> insertUser(final User user) {
        return Observable.fromCallable(() -> {
            mAppDatabase.userDao().insert(user);
            return true;
        });
    }

    @Override
    public Observable<List<Post>> getAllPosts() {
        return Observable.fromCallable(() -> mAppDatabase.postDao().loadAll());
    }

    @Override
    public Observable<Boolean> savePost(Post post) {
        return Observable.fromCallable(() -> {
            mAppDatabase.postDao().insert(post);
            return true;
        });
    }

}
