package mb.courses.chatroomapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mb.courses.chatroomapp.screen.LoginScreen
import mb.courses.chatroomapp.screen.Screen
import mb.courses.chatroomapp.screen.SignupScreen
import mb.courses.chatroomapp.ui.theme.ChatRoomAppTheme
import mb.courses.chatroomapp.viewmodel.AuthViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChatRoomAppTheme {
                val navHostController = rememberNavController()
                val authViewModel: AuthViewModel = viewModel()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    NavigationGraph(navHostController = navHostController, authViewModel = authViewModel)
                }
            }
        }
    }
}

@Composable
fun NavigationGraph(
    navHostController: NavHostController,
    authViewModel: AuthViewModel
) {
    NavHost(navController = navHostController, startDestination = Screen.SignupScreen.route) {
        composable(Screen.SignupScreen.route) {
            SignupScreen(authViewModel = authViewModel, onNavigateToLogin = { navHostController.navigate(Screen.LoginScreen.route) })
        }
        composable(Screen.LoginScreen.route) {
            LoginScreen(onNavigateToSignup = { navHostController.navigate(Screen.SignupScreen.route) })
        }
    }
}