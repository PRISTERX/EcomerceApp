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
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

@Composable
fun RegisterScreen(){

    val auth = Firebase.auth
    val activity = LocalView.current.context as Activity

    var inputName by remember { mutableStateOf("") }
    var inputEmail by remember { mutableStateOf("") }
    var inputPassword by remember { mutableStateOf("") }
    var inputPasswordConfirmation by remember { mutableStateOf("") }

    var nameError by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf() }
    var passwordError by remember { mutableStateOf("") }
    var passwordConfirmation by remember { mutableStateOf("") }

    var registerError by remember { mutableStateOf("") }




    Scaffold { innerPadding ->
        Column (modifier = Modifier.padding(innerPadding).fillMaxSize().padding(horizontal = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            Image(imageVector = Icons.Default.Person,
                contentDescription = null,
                modifier = Modifier.size(150.dp),
                colorFilter = ColorFilter.tint(Color(0xFFF9900))
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Título
            Text(
                text = "REGISTRO",
                fontSize = 24.sp,
                color = Color(0xFFF9988),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Campo de texto para correo
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email",
                        tint = Color(0xFFF9900)
                    )
                },
                label = {
                    Text(text = "Correo Electrónico")
                },
                shape = RoundedCornerShape(12.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Email",
                        tint = Color(0xFFF9900)
                    )
                },
                supportingText = {
                    if (passwordError.isNotEmpty()){
                        Text(
                            text = passwordError,
                            color = Color.Red
                        )
                    }
                },


                label = {
                    Text(text = "Contraseña")
                },
                shape = RoundedCornerShape(12.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Email",
                        tint = Color(0xFFF9900)
                    )
                },
                label = {
                    Text(text = "Confirmar Contraseña")
                },
                shape = RoundedCornerShape(12.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))

            // Campo de texto para correo
            OutlinedTextField(
                value = "",
                onValueChange = {},
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email",
                        tint = Color(0xFFF9900)
                    )
                },
                supportingText = {
                    if(nameError.isNotEmpty)
                },
                label = {
                    Text(text = "Nombre Completo")
                },
                shape = RoundedCornerShape(12.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = {
                val isValidName = validateName(inputName).first
                val isValidEmail = validateEmail(inputEmail).first
                val isValidPassword = validatePassword(inputPassword).first
                val isValidConfirmationPassword = validateConfirmPassword(inputPassword, inputPasswordConfirmation).first

                nameError = validateName(inputName).second
                emailError = validateEmail(inputEmail).second
                passwordError = validatePassword(inputPassword).second
                inputPasswordConfirmation = validateConfirmPassword(inputPassword,inputPasswordConfirmation)

                if (isValidName && isValidEmail && isValidPassword && isValidConfirmationPassword){

                }else{
                    registerError = "Hubo un error en el register"
                }
            },modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors()
            ) {
                Text("Registrarse")
            }

        }
    }
}

@Preview
@Composable
fun RegisterScreenPreview(){
    RegisterScreen()
}