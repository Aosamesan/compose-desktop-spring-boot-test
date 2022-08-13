package me.aosamesan.app.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import org.springframework.stereotype.Component
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Component
class UrlEncoder : Page {
    override val order: Int
        get() = 1
    override val title: String
        get() = "URL"
    override val icon: ComposableContent
        get() = @Composable {
            Column {
                Icon(Icons.Default.Refresh, title, modifier = Modifier.align(Alignment.CenterHorizontally))
                Text(title, maxLines = 1, fontSize = .8.em, modifier = Modifier.align(Alignment.CenterHorizontally))
            }
        }
    override val content: ComposableContent
        get() = @Composable {
            var text by remember { mutableStateOf("") }

            Column {
                Row(modifier = Modifier.weight(.9f)) {
                    TextField(
                        text,
                        onValueChange = { text = it },
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Row(modifier = Modifier.weight(.1f)) {
                    Column(modifier = Modifier.padding(5.dp).weight(.5f)) {
                        Button(
                            onClick = { text = URLEncoder.encode(text, StandardCharsets.UTF_8) },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Encode")
                        }
                    }
                    Column(modifier = Modifier.padding(5.dp).weight(.5f)) {
                        Button(
                            onClick = { text = URLDecoder.decode(text, StandardCharsets.UTF_8) },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Decode")
                        }
                    }
                }
            }
        }
}