package com.example.catbreeds.Data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.catbreeds.model.CatModelItem

@androidx.room.Database(entities = [CatModelItem::class], version = 1, exportSchema = false)
@androidx.room.TypeConverters(Converters::class)
abstract class CatsDatabase : RoomDatabase() {
    abstract fun catDao(): CatDAO


    // as Singleton
    companion object {

        // volatile for different threads
        @Volatile
        private var instance: CatsDatabase? = null
        private var lock = Any()

        // if no instance, just one thread is use
        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
            instance ?: createDatabase(context).also {

                instance = it
            }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext, CatsDatabase::class.java, "cats.db"
        )
            .build()


    }
}