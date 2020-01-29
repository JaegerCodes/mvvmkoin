package yanbal.com.pe.spypdt.model

import androidx.room.Database
import androidx.room.RoomDatabase
import yanbal.com.pe.spypdt.model.dao.UserDao
import yanbal.com.pe.spypdt.model.entity.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val userDao: UserDao
}