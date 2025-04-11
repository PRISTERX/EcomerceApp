package co.wilsonjavier.ecomerceapp

import android.content.ClipData.Item
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){
    Scaffold (
        topBar = {

            val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

            MediumTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        "Bienvenido",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                            contentDescription = "Localized description"
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        }
    ){ innerpadding ->
        Column(modifier =  Modifier.padding(innerpadding)) {

            Text(
                text = "Promociones",
                modifier = Modifier
                    .padding(
                        top = 16.dp,
                        start = 16.dp,
                        bottom = 8.dp
                    )
            )

            val listadoPromociones = listOf(
                "https://imgs.search.brave.com/GBJDlfqyY4cNQmFJRjhJpfxVKE21OzCy3KJ2MjNrjNg/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9tYXJr/ZXRwbGFjZS5jYW52/YS5jb20vRUFGNHls/Y3FFTjQvMy8wLzE2/MDB3L2NhbnZhLW5h/cmFuamEtYW1hcmls/bG8teS1ibGFuY28t/dmlicmFudGUtZGlu/JUMzJUExbWljby1j/b25zdHJ1Y2NpJUMz/JUIzbi1iYW5uZXIt/NFB4YlZmZjVHVGcu/anBn",
                "https://imgs.search.brave.com/Y0LzsHP3ky1YxF2CBwo_YX5RMHPBqDASwaXEfkdES3o/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9pbWcu/ZnJlZXBpay5jb20v/cHNkLXByZW1pdW0v/YmFubmVyLXZlbnRh/LWRlc2N1ZW50by1j/b2xvcmlkby1wcmVt/aXVtLXBzZF80Njc1/MDAtMTI4LmpwZz9z/ZW10PWFpc19oeWJy/aWQ",
                "https://imgs.search.brave.com/yypAoBOhJi4kJrIi-v22GUhzL8fisO6Di8icDPKMvKA/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly9kMnZy/NjRmZDYyYWpoNS5j/bG91ZGZyb250Lm5l/dC9pbWcvYmxvZy9o/bGYtcmVzaWRlbmNp/YS1nZXJpYXRyaWNh/LWJhbm5lci1lZGl0/YXItZ3JhdGlzX21p/bmlfLmpwZw",

            )

            LazyRow(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    CardPromo(listadoPromociones[0])

                }
                item {
                    CardPromo(listadoPromociones[1])

                }
                item {
                    CardPromo(listadoPromociones[2])
                }
                item {
                    CardPromo(listadoPromociones[3])

                }

            }

        }
    }

}

@Preview
@Composable
fun HomeScreenPreview(){
    HomeScreen()

}

@Composable
fun CardPromo(urlImage : String){
    Card(modifier = Modifier
        .height(180.dp)
        .width(300.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Image(
            painter = painterResource((R.drawable.ic_launcher_background)),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale =  ContentScale.Crop

        )

    }
}