package co.wilsonjavier.ecomerceapp.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import co.wilsonjavier.ecomerceapp.RegisterScreen

class MainActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EcommerceAppTheme{

                val myNavController = rememberNavController()
                val myStartDestination : String = "Login"
                NavHost(
                    navController = myNavController,
                    startDestination = myStartDestination,
                    modifier = Modifier.fillMaxWidth()
                ){
                    composable("login"){
                        MainActivity()
                    }
                    composable("register"){
                        RegisterScreen()
                    }

                }
            }
        }
    }
}