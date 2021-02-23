package orders.appup_kw.designexample.network

import orders.appup_kw.designexample.utils.baseUrl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class MainNetworkService @Inject constructor() {

    fun getApi(): Api =
            Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(Api::class.java)

}