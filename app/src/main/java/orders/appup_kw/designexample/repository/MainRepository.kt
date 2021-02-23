package orders.appup_kw.designexample.repository

import orders.appup_kw.designexample.model.Products
import orders.appup_kw.designexample.network.Api
import orders.appup_kw.designexample.network.MainNetworkService
import orders.appup_kw.designexample.utils.token
import toothpick.Toothpick
import javax.inject.Inject

class MainRepository @Inject constructor(var mainNetworkService: MainNetworkService) {

    init {
        val appScope = Toothpick.openScope("APP")
        Toothpick.inject(this, appScope)
    }


    suspend fun getProducts(): List<Products> {
        return mainNetworkService.getApi().getProducts(token)
    }
}