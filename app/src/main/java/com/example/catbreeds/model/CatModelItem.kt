package com.example.catbreeds.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "catDataList")
data class CatModelItem(
    @ColumnInfo(name = "description")
    @SerializedName("description")
    val description: String?,
    @ColumnInfo(name = "dog_friendly")
    @SerializedName("dog_friendly")
    val dogFriendly: Int?,
    @ColumnInfo(name = "id")
    @SerializedName("id")
    val id: String?,
    @ColumnInfo(name = "life_span")
    @SerializedName("life_span")
    val lifeSpan: String?,
    @ColumnInfo(name = "name")
    @SerializedName("name")
    val name: String?,
    @ColumnInfo(name = "origin")
    @SerializedName("origin")
    val origin: String?,
    @ColumnInfo(name = "reference_ image_id")
    @SerializedName("reference_image_id")
    val referenceİmageİd: String?,
    @ColumnInfo(name = "temperament")
    @SerializedName("temperament")
    val temperament: String?,
    @ColumnInfo(name = "wikipedia_url")
    @SerializedName("wikipedia_url")
    val wikipediaUrl: String?
) {
    @Ignore
    @ColumnInfo(name = "image")
    @SerializedName("image")
    var image: İmage? = null

    @PrimaryKey(autoGenerate = true)
    var uid = 0

    /*@ColumnInfo(name = "favorite")
    var favorite: Boolean = false*/
}