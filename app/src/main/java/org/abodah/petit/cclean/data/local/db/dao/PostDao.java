package org.abodah.petit.cclean.data.local.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import org.abodah.petit.cclean.data.model.db.Post;
import org.abodah.petit.cclean.data.model.db.User;

import java.util.List;

@Dao
public interface PostDao {
    @Delete
    void delete(User user);

    @Query("SELECT * FROM posts WHERE id LIKE :id LIMIT 1")
    Post findPostById(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Post post);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Post> posts);

    @Query("SELECT * FROM posts")
    List<Post> loadAll();

    @Query("SELECT * FROM posts WHERE id IN (:userIds)")
    List<Post> loadAllByIds(List<Integer> userIds);
}
