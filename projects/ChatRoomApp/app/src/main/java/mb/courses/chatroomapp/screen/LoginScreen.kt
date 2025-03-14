package mb.courses.chatroomapp.screen

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mb.courses.chatroomapp.data.MbResult
import mb.courses.chatroomapp.viewmodel.AuthViewModel

@Composable
fun LoginScreen(
    authViewModel: AuthViewModel, onNavigateToSignup: () -> Unit, onSignInSuccess: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val result by authViewModel.authResult.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        OutlinedTextField(value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            visualTransformation = PasswordVisualTransformation()
        )
        Button(onClick = {
            authViewModel.login(email, password)
            when (result) {
                is MbResult.Success -> {
                    onSignInSuccess()
                }

                is MbResult.Error -> {

                }

                else -> {

                }
            }
            email = ""
            password = ""
        }) {
            Text(text = "Log in")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Don't have an account? Sign up",
            modifier = Modifier.clickable { onNavigateToSignup() })
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
//    LoginScreen {}
}