package mb.courses.chatroomapp.screen

sealed class Screen(val route: String) {
    object LoginScreen:Screen("loginscreen")
    object SignupScreen:Screen("signupscreen")
    object ChatRoomsScreen:Screen("chatroomsscreen")
    object ChatScreen:Screen("chatscreen")
}