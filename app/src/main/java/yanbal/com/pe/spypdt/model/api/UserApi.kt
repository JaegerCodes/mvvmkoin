package yanbal.com.pe.spypdt.model.api

import kotlinx.coroutines.Deferred
import yanbal.com.pe.spypdt.model.entity.User
import retrofit2.http.GET

interface UserApi {

    @GET("users")
    fun getAllAsync(): Deferred<List<User>>
}