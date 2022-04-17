package com.example.catbreeds.API

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.catbreeds.model.CatModelItem

@Dao
interface CatFavDAO {

    @Query("SELECT * FROM favCatList")
    fun getAll(): List<CatModelItem>

    @Query("SELECT * FROM favCatList WHERE uid IN (:catIds)")
    fun loadAllByIds(catIds: IntArray): List<CatModelItem>

    @Insert
    fun insertAll(vararg users: CatModelItem)

    @Delete
    fun delete(user: CatModelItem)
}