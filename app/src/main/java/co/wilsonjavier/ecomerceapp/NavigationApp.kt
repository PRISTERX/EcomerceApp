package co.wilsonjavier.ecomerceapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationApp(){
    val myNavController = rememberNavController()
    val myStartDestination: String = "login"

    NavHost(
        navController =  myNavController,
        startDestination = myStartDestination
    ){
        composable("login") {
            LoginScreen()
        }
        composable("register") {
            RegisterScreen()
        }
    }



}