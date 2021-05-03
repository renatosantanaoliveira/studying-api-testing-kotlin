package com.santana.studyingapitesting.common

import io.restassured.specification.RequestSender
import io.restassured.specification.RequestSpecification
import io.restassured.specification.ResponseSpecification

fun RequestSpecification.When(): RequestSpecification {
    return this.`when`()
}

fun ResponseSpecification.When(): RequestSender {
    return this.`when`()
}