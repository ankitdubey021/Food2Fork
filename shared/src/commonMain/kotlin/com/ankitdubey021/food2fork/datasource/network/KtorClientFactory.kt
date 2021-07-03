package com.ankitdubey021.food2fork.datasource.network

import io.ktor.client.*

expect class KtorClientFactory(){
    fun build() : HttpClient
}