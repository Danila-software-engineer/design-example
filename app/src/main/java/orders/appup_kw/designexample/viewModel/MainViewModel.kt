package orders.appup_kw.designexample.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import orders.appup_kw.designexample.model.Products
import orders.appup_kw.designexample.repository.MainRepository
import toothpick.Toothpick
import javax.inject.Inject

class MainViewModel @Inject constructor(var mainRepository: MainRepository) : ViewModel() {


    val goodsListLiveData = MutableLiveData<List<Products>>()

    init {
        val appScope = Toothpick.openScope("APP")
        Toothpick.inject(this, appScope)
    }

    fun getProducts(){
        Log.e("TAGG","start")
        viewModelScope.launch {
            try {
                goodsListLiveData.value = mainRepository.getProducts()
                Log.e("TAGG","end")
            } catch (error: Exception) {
                Log.e("TAGG","error: $error")
            }


        }
    }
}