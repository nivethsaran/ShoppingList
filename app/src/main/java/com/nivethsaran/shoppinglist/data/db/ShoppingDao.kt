package com.nivethsaran.shoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.nivethsaran.shoppinglist.data.db.entities.ShoppingItem

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query (value = "Select * from shopping_items")
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>
}