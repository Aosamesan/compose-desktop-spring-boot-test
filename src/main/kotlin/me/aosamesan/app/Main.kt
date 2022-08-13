// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package me.aosamesan.app


import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.NavigationRail
import androidx.compose.material.NavigationRailItem
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import me.aosamesan.app.pages.Page
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.stereotype.Component

@SpringBootApplication
class MainApplication

fun <R: Any> R.logger(): Lazy<Logger> {
    return lazy {
        LoggerFactory.getLogger(this::class.java)
    }
}

@Component
class MainCommandLineRunner: CommandLineRunner {
    @Autowired
    lateinit var pages: List<Page>

    @Preview
    override fun run(vararg args: String?) {
        application {
            Window(onCloseRequest = ::exitApplication) {
                var selectedPage by remember { mutableStateOf(pages.first()) }

                MaterialTheme {
                    Row {
                        Column(modifier = Modifier.padding(10.dp)) {
                            NavigationRail {
                                pages.map { page ->
                                    NavigationRailItem(
                                        selected = selectedPage == page,
                                        onClick = { selectedPage = page },
                                        icon = page.icon
                                    )
                                }
                            }
                        }
                        Column(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
                            selectedPage.content()
                        }
                    }
                }
            }
        }
    }
}

fun main() {
    val builder = SpringApplicationBuilder(MainApplication::class.java)
    builder.headless(false)
    builder.run()
}
