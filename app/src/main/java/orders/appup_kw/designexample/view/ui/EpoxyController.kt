package orders.appup_kw.designexample.view.ui

import com.airbnb.epoxy.EpoxyController
import orders.appup_kw.designexample.*
import orders.appup_kw.designexample.model.Products
import javax.inject.Inject

class ViewController constructor(private val productsList: List<Products>) : EpoxyController() {
    override fun buildModels() {
        header {
            id()
        }

        category {
            id()
        }

        search{
            id()
        }

        title{
            id()
            title("Hot sales")
        }

        hotSales {
            id()
        }


        title{
            id()
            title("Goods")
        }

        productsList.forEach {
            goods {
                id()
                title(it.title.toString())
                count(it.price.toString())
            }
        }


    }
}