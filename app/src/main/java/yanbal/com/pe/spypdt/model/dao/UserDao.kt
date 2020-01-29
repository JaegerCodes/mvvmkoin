package yanbal.com.pe.spypdt.model.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import yanbal.com.pe.spypdt.model.entity.User

@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun findAll(): LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(users: List<User>)
}