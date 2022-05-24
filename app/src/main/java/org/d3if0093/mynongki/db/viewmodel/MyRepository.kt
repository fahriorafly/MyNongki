package org.d3if0093.mynongki.db.viewmodel

import androidx.lifecycle.LiveData
import org.d3if0093.mynongki.db.dao.MyDao
import org.d3if0093.mynongki.db.entity.MyEntity

class MyRepository(private val myDao: MyDao) {
    val getAllData: LiveData<List<MyEntity>> = myDao.getAllData()

    fun tambah(myEntity: MyEntity){
        myDao.insertData(myEntity)
    }

    fun hapus(myEntity: MyEntity){
        myDao.deleteData(myEntity)
    }
}