package orders.appup_kw.designexample.view


import android.os.Bundle
import android.view.View
import android.view.animation.TranslateAnimation
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.epoxy.EpoxyRecyclerView
import kotlinx.coroutines.*
import orders.appup_kw.designexample.R
import orders.appup_kw.designexample.model.Products
import orders.appup_kw.designexample.view.ui.ViewController
import orders.appup_kw.designexample.viewModel.MainViewModel
import toothpick.Toothpick
import java.util.ArrayList
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject lateinit var viewModel: MainViewModel

    private lateinit var animatedFilterView: ConstraintLayout
    private lateinit var recyclerView: EpoxyRecyclerView
    private var isShown = true
    private val mutableList: MutableList<Products> = ArrayList()

    private val animationDuration: Long = 300

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.epoxy_activity)

        toothPickInject()
        initView()
        setUpRecView()
        loadGoodsList()
        observeResult()
    }

    private fun toothPickInject(){
        val appScope = Toothpick.openScope("APP")
        Toothpick.inject(this, appScope)
    }

    private fun loadGoodsList(){
        viewModel.getProducts()
    }

    private fun observeResult(){
        viewModel.goodsListLiveData.observe(this){
            mutableList.addAll(it)
            recyclerView.requestModelBuild()
        }
    }

    private fun initView(){
        animatedFilterView = findViewById(R.id.filter)
        recyclerView = findViewById(R.id.recyclerView)
    }

    private fun setUpRecView(){
        recyclerView.setControllerAndBuildModels(ViewController(mutableList))
        recyclerView.requestModelBuild()
    }

    private fun showFooter(){
        animatedFilterView.visibility = View.VISIBLE
        startAnimation(1000.0f,0.0f)
        isShown = false
    }

    private fun hideFooter(){
        startAnimation(0.0f, 1000.0f)
        makeGonePauseBeforeAnimationEnd()
        isShown = true
    }

    private fun makeGonePauseBeforeAnimationEnd(){
        val scope = CoroutineScope(Job() + Dispatchers.Main)
        scope.launch {
            delay(animationDuration)
            animatedFilterView.visibility = View.GONE
        }
    }

    private fun startAnimation(coordinateFrom: Float, coordinateTo: Float){
        val anim = TranslateAnimation(0.0f, 0.0f, coordinateFrom, coordinateTo)
        anim.duration = animationDuration
        animatedFilterView.startAnimation(anim)
    }


    fun openFilterClick(view: View) {
        if(isShown) {
            showFooter()
        }else{
            hideFooter()
        }
    }

    fun closeFilterClick(view: View) {
        if(!isShown)
            hideFooter()
    }

}