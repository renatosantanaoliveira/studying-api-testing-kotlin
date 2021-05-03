package com.santana.studyingapitesting.common.utils

import io.restassured.RestAssured.requestSpecification
import io.restassured.builder.RequestSpecBuilder
import io.restassured.filter.log.LogDetail
import io.restassured.specification.RequestSpecification

class logsTests {
    companion object {
        private lateinit var reqSpec: RequestSpecification
    }

    fun requestLog() {
        val reqBuilder = RequestSpecBuilder()
        reqBuilder.log(LogDetail.ALL)
        reqSpec = reqBuilder.build()

        requestSpecification = reqSpec
    }

    fun responseLog() {

    }
}