package orders.appup_kw.designexample

import android.os.Bundle
import android.view.View
import android.view.animation.TranslateAnimation
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    lateinit var filter: ConstraintLayout

    var lo = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        filter = findViewById(R.id.filter)
    }

    fun on(view: View) {
        if(lo) {
            showFooter()
        }else{
            hideFooter()
        }
    }

    fun showFooter(){
        filter.visibility = View.VISIBLE
        val anim = TranslateAnimation(0.0f, 0.0f, 1000.0f, 0.0f)
        anim.duration = 300
        filter.startAnimation(anim)
        lo = false
    }
    
    fun hideFooter(){
        val anim = TranslateAnimation(0.0f, 0.0f, 0.0f, 1000.0f)
        anim.duration = 300
        filter.startAnimation(anim)
        filter.visibility = View.GONE
        lo = true
    }

    fun click(view: View) {
        if(!lo)
        hideFooter()
    }
}