package com.vinay.kotlinbasicappwithretrofitlivedataandviewmodel.api;

object ServiceManagerProvider {
    fun provideSearchRepository(): ServiceManager {
        return ServiceManager()
    }
}