package com.example.app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.app.model.User
import com.example.app.services.RetrofitInstance
import com.example.app.ui.theme.AppTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userService = RetrofitInstance.buildUserService()

        // 1. Rcuperation des vues
        val editNom = findViewById<EditText>(R.id.editNom)
        val editEmail = findViewById<EditText>(R.id.editEmail)
        val editMessage = findViewById<EditText>(R.id.editMessage)
        val btnEnvoyer = findViewById<Button>(R.id.btnEnvoyer)

        // 2. Definir l'action du button
        btnEnvoyer.setOnClickListener {
            val nom = editNom.text.toString().trim()
            val email = editEmail.text.toString().trim()
            val message = editMessage.text.toString().trim()

            if(nom.isNotEmpty() && email.isNotEmpty() && message.isNotEmpty()) {
                val user = User(nom = nom, email = email, message = message)
                userService.createUser(user).enqueue(object : Callback<User> {
                    override fun onResponse(call: Call<User>, response: Response<User>) {
                        if(response.isSuccessful) {
                            Toast.makeText(this@MainActivity, "Utilisateur créé avec succès", Toast.LENGTH_LONG).show()

                            editNom.text.clear()
                            editEmail.text.clear()
                            editMessage.text.clear()
                        }else {
                            Toast.makeText(this@MainActivity, "Erreur lors de la création de l'utilisateur", Toast.LENGTH_LONG).show()
                        }
                    }

                    override fun onFailure(call: Call<User>, t: Throwable) {
                        Toast.makeText(this@MainActivity, "Erreur serveur", Toast.LENGTH_LONG).show()
                    }
                })
            }else {
                Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_LONG).show()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppTheme {
        Greeting("Android")
    }
}
