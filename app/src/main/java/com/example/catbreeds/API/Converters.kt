package com.example.catbreeds.API

import androidx.room.TypeConverter
import com.example.catbreeds.model.CatModelItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class Converters {
    @TypeConverter
    fun toModelInfo(cat:String):CatModelItem{
        val type=object :TypeToken<CatModelItem>(){}.type
        return Gson().fromJson(cat,type)
    }
    @TypeConverter
    fun toModelJson(cat:CatModelItem):String{
        val type=object :TypeToken<CatModelItem>(){}.type
        return Gson().toJson(cat,type)
    }
}