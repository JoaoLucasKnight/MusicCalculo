package br.com.consumoapi.services


import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.result.Result
import com.github.kittinunf.fuel.json.responseJson
import java.util.*

object Autenticar {
    // URL do endpoint de token
    val tokenUrl = "https://accounts.spotify.com/api/token"

    // Credenciais do cliente
    val clientId = "23948ccb57bf49d8b33ddc7277ebfe37"
    val clientSecret = "0c6d70d54bc440eba6b669f6fdff930c"

    // Parâmetros da solicitação
    val grantType = "client_credentials"

    // Codificar as credenciais do cliente em Base64
    val credentials = "$clientId:$clientSecret"
    val encodedCredentials = Base64.getEncoder().encodeToString(credentials.toByteArray(Charsets.UTF_8))

    fun getToken(): String {
        val (_, _, result)= Fuel.post(tokenUrl)
            .header("Content-Type" to "application/x-www-form-urlencoded")
            .header("Authorization" to "Basic $encodedCredentials")
            .body("grant_type=$grantType")
            .responseJson()  // aqui se a resposta for sucesso o body é encapsulado e só é eaccessado se tive sucesso



        when (result) {
            is Result.Failure -> {
                val ex = result.getException()
                return ("Erro: $ex")
            }
            is Result.Success -> {
                val json = result.value.obj()
                return json.getString("access_token")
            }
        }
    }
}