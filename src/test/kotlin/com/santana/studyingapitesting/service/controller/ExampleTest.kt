package com.santana.studyingapitesting.service.controller

import com.santana.studyingapitesting.common.When
import com.santana.studyingapitesting.common.utils.Const
import com.santana.studyingapitesting.service.base.ServiceTestBase
import io.restassured.RestAssured.given
import io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

class ExampleTest: ServiceTestBase() {
    companion object {
        private const val RESOURCE = "/.."
    }

    @Test
    @Tag("auth")
    fun `Login successful`() {
        given()
                .contentType(Const.APP)
                .When()
                .body(username)
                .post(RESOURCE)
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("service/Schema.json"))
    }
}