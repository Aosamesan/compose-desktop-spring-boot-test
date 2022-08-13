package me.aosamesan.app.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.em
import org.springframework.stereotype.Component

@Component
class Home : Page {
    override val order: Int
        get() = 0
    override val title: String
        get() = "Home"
    override val icon: ComposableContent
        get() = @Composable {
            Column {
                Icon(Icons.Default.Home, title, modifier = Modifier.align(Alignment.CenterHorizontally))
                Text(title, maxLines = 1, fontSize = .8.em, modifier = Modifier.align(Alignment.CenterHorizontally))
            }
        }
    override val content: ComposableContent
        get() = @Composable {
            Text("Home")
        }
}