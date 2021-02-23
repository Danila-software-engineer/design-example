package orders.appup_kw.designexample

import android.app.Application
import orders.appup_kw.designexample.di.MainModule
import toothpick.Toothpick

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        val appScope = Toothpick.openScope("APP")
        appScope.installModules(MainModule())
    }
}