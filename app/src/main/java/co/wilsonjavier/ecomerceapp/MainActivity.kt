package co.wilsonjavier.ecomerceapp

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen() {
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
                    Text(text = "Contraseña")
                },
                shape = RoundedCornerShape(12.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = {},modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors()
            ) {
                Text("Iniciar sesion")
            }

            Spacer(modifier = Modifier.height(24.dp))

            TextButton(onClick = {}) {
                Text(text = "No tienes cuenta? ,REGISTRATE")
            }
        }
    }
}

@Composable
@Preview
fun LoginScreenPreview(){
    LoginScreen()
}
