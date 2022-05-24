package org.d3if0093.mynongki.db.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.d3if0093.mynongki.db.entity.MyEntity

@Database(entities = [MyEntity::class], version = 2, exportSchema = true)
abstract class MyDb: RoomDatabase() {

    abstract fun myDao(): MyDao

    companion object{

        @Volatile
        private var INSTANCE: MyDb? = null
        fun getDatabase(context: Context): MyDb {
            val instance = INSTANCE
            if (instance != null){
                return instance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyDb::class.java,
                    "my_nongki"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}