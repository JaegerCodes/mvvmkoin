package yanbal.com.pe.spypdt.model.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import yanbal.com.pe.spypdt.model.api.UserApi
import yanbal.com.pe.spypdt.model.dao.UserDao

class UserRepository(private val userApi: UserApi, private val userDao: UserDao) {

    val data = userDao.findAll()

    suspend fun refresh() {
        withContext(Dispatchers.IO) {
            val users = userApi.getAllAsync().await()
            userDao.add(users)
        }
    }
}