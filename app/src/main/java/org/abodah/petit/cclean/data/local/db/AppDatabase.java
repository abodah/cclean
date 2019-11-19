package org.abodah.petit.cclean.data.local.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import org.abodah.petit.cclean.data.local.db.dao.PostDao;
import org.abodah.petit.cclean.data.local.db.dao.UserDao;
import org.abodah.petit.cclean.data.model.db.Post;
import org.abodah.petit.cclean.data.model.db.User;

@Database(entities = {User.class, Post.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();

    public abstract PostDao postDao();
}
