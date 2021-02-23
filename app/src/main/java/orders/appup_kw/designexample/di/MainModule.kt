package orders.appup_kw.designexample.di

import orders.appup_kw.designexample.network.MainNetworkService
import orders.appup_kw.designexample.repository.MainRepository
import orders.appup_kw.designexample.viewModel.MainViewModel
import toothpick.config.Module

class MainModule : Module() {

    init {
        bind(MainNetworkService::class.java)
            .singleton()

        bind(MainRepository::class.java)
            .singleton()

        bind(MainViewModel::class.java)
            .singleton()
    }
}