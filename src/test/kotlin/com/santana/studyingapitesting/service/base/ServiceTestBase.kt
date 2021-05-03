package com.santana.studyingapitesting.service.base

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.json.content
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest

open class ServiceTestBase {
    companion object{
        private const val secretName = "dev/..."
    }

    var username: String
    var password: String

    init {
        val client = SecretsManagerClient.builder().region(Region.US_EAST_1).build()
        val secrets = client.getSecretValue(GetSecretValueRequest.builder().secretId(secretName).build())
        val json = Json(JsonConfiguration.Default)
        val jsonObject = json.parseJson(secrets.secretString()).jsonObject
        username = jsonObject["username"]!!.content
        password = jsonObject["passowrd"]!!.content

    }
}