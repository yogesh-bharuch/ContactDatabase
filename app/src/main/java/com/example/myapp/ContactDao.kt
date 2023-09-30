package com.example.myapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {
    @Insert
    suspend fun insertContact(contact: Contact)
    @Update
    suspend fun updateContact(contact: Contact)
    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query("SELECT * FROM CONTACT")
    fun getContact():LiveData<List<Contact>>
    //fun getContact():Flow<Contact>
}