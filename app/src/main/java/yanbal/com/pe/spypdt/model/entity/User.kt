package yanbal.com.pe.spypdt.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey val id: Long,
    val login: String,
    val avatar_url: String
)