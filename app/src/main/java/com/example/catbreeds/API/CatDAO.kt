package com.example.catbreeds.API

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.catbreeds.model.CatModelItem

@Dao
interface CatDAO {

    // suspend coroutines, pause & resume
    //vararg multiple Country object, we do not how many
    // Lis<Long> for Primary Keys

    @Query("SELECT * FROM catDataList")
    suspend fun getAll(): List<CatModelItem>

    @Query("SELECT  * FROM catDataList WHERE uid IN (:catIds)")
    suspend fun loadAllByIds(catIds: Int): CatModelItem

    @Insert
    suspend fun insertAll(vararg cats: CatModelItem): List<Long>

    @Delete
    suspend fun deleteAll(cats: List<CatModelItem>)

   /* @Query("SELECT * FROM catDataList WHERE favorite IN (:favorite)")
    suspend fun getFavCats(favorite: Boolean): List<CatModelItem>

    @Query("DELETE FROM catDataList WHERE favorite IN (:favorite)")
    suspend fun deleteFavCats(favorite: Boolean): List<CatModelItem>*/


    //@Query("DELETE FROM catDataList")
    //suspend fun delete(cats: CatModelItem)
}