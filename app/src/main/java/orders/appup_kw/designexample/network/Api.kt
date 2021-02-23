package orders.appup_kw.designexample.network

import orders.appup_kw.designexample.model.Products
import retrofit2.http.GET
import retrofit2.http.Header
import javax.inject.Inject

interface Api  {

    @GET("products")
    suspend fun getProducts(@Header("x-apikey") token : String): List<Products>

}