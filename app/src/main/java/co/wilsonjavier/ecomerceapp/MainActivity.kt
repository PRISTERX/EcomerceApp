package co.wilsonjavier.ecomerceapp

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.auth

@Composable
fun LoginScreen(navController: NavController, onSuccessfullLogin : ()-> Unit) {

    val auth = Firebase.auth
    val activity = LocalView.current.context as Activity

    var inputEmail by remember { mutableStateOf() }
    var inputPassword by remember { mutableStateOf() }
    var LoginError by remember { mutableStateOf(false) }
    var emailError by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf("") }

    Scaffold { innerPadding ->
        // Contenedor principal
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 30.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Imagen de logo
            Image(
                painter = painterResource(id = R.drawable.logo), // Asegúrate de tener la imagen en la carpeta drawable
                contentDescription = "Logo Unab",
                modifier = Modifier.size(150.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Título
            Text(
                text = "Iniciar Sesión",
                fontSize = 24.sp,
                color = Color(0xFFF9988),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Campo de texto para correo
            OutlinedTextField(
                value = inputEmail,
                onValueChange = {inputEmail = it},
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email",
                        tint = Color(0xFFF9900)
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                supportingText = {
                    if (emailError.isNotEmpty()){
                        Text(
                            text = passwordError,
                            color = Color.Red
                        )
                    }
                },
                keyboardOptions = keyboardOptions(
                    captilazation = KeyboardCapitalization.None

                )
                label = {
                    Text(text = "Correo Electrónico")
                },
                shape = RoundedCornerShape(12.dp)
            )
            OutlinedTextField(
                value = inputPassword,
                onValueChange = {inputPassword = it},
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Email",
                        tint = Color(0xFFF9900)
                    )
                },
                label = {
                    Text(text = "Contraseña")
                },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier,fillMaxWidth(),
                supportingText = {
                    if(passwordError.isNotEmpty()){
                        Text(
                            text = passwordError,
                            color = Color.Red
                        )
                    }
                },
                visulaTrandormation = passwordVisualTrandormation()

            )
            Spacer(modifier = Modifier.height(24.dp))





            Button(onClick = {

                val isValidEmail:Boolean = validateEmail(inputEmail).first
                val isValidPassor = validatePassword(inputPassword).first

                emailError = validateEmail(inputEmail).second
                passwordError = validateEmail(inputPassword).second


                if (isValidEmail && isValidPassword){
                    navController.navigate("home")
                    auth.signInWithEmailAndPassword(inputEmail,inputPassword)
                        .addOnCompleteListener(activity) {task ->
                            if (task.isSuccessful){
                                onSuccessfullLogin()

                            }else{
                                LoginError = when(task.exception){
                                    is FirebaseAuthInvalidCredentialsException -> "Correo o contrasena incorrecta"
                                    is FirebaseAuthInvalidUserException -> "No existe una cuenta con este correo"
                                    else -> "Error al iniciar sesion . intenta de nuevo"
                                }
                            }
                        }
                }




            },modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors()
            ) {
                Text("Iniciar sesion")
            }

            Spacer(modifier = Modifier.height(24.dp))

            TextButton(onClick = {

                navController.navigate("register")

            }) {
                Text(text = "No tienes cuenta? ,REGISTRATE")
            }
        }
    }
}

@Composable
@Preview
fun LoginScreenPreview(){
    //LoginScreen()
}
