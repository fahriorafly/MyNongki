package org.d3if0093.mynongki.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import org.d3if0093.mynongki.db.entity.MyEntity

@Dao
interface MyDao {
    @Insert
    fun insertData(data: MyEntity)

    @Delete
    fun deleteData(data: MyEntity)

    @Query("SELECT * FROM my_nongki ORDER BY nameNongki ASC")
    fun getAllData(): LiveData<List<MyEntity>>
}