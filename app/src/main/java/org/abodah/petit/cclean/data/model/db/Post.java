package org.abodah.petit.cclean.data.model.db;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "Posts")
public class Post {
    @Expose
    @SerializedName("created_at")
    @ColumnInfo(name = "created_at")
    public String createdAt;

    @Expose
    @SerializedName("updated_at")
    @ColumnInfo(name = "updated_at")
    public String updatedAt;

    @Expose
    @PrimaryKey
    public Long id;

    @Expose
    @SerializedName("post_img_url")
    @ColumnInfo(name = "post_img_url")
    public String imgUrl;

    @Expose
    @SerializedName("descripion")
    @ColumnInfo(name = "descripion")
    public String descripion;

    @Expose
    @SerializedName("content")
    @ColumnInfo(name = "content")
    public String content;


}
