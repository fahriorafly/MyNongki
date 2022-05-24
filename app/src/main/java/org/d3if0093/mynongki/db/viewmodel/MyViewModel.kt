package org.d3if0093.mynongki.db.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if0093.mynongki.db.dao.MyDao
import org.d3if0093.mynongki.db.dao.MyDb
import org.d3if0093.mynongki.db.entity.MyEntity

class MyViewModel(application: Application): AndroidViewModel(application) {

    private val myRepository: MyRepository
    val getAllData: LiveData<List<MyEntity>>

    init {
        val myDao = MyDb.getDatabase(application).myDao()
        myRepository = MyRepository(myDao)
        getAllData = myRepository.getAllData
    }

    fun tambahData(myEntity: MyEntity){
        viewModelScope.launch (Dispatchers.IO){
            myRepository.tambah(myEntity)
        }
    }

    fun hapusData(myEntity: MyEntity){
        viewModelScope.launch (Dispatchers.IO){
            myRepository.hapus(myEntity)
        }
    }

}