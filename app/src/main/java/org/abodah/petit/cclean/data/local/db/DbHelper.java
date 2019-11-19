package org.abodah.petit.cclean.data.local.db;


import org.abodah.petit.cclean.data.model.db.Post;
import org.abodah.petit.cclean.data.model.db.User;

import java.util.List;

import io.reactivex.Observable;

public interface DbHelper {

    Observable<List<User>> getAllUsers();

    Observable<Boolean> insertUser(final User user);

    Observable<List<Post>> getAllPosts();

    Observable<Boolean> savePost(Post post);
}
