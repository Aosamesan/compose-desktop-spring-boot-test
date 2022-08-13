package me.aosamesan.app.pages

import androidx.compose.runtime.Composable

typealias ComposableContent = @Composable () -> Unit

interface Page {
    val order: Int
    val title: String
    val icon: ComposableContent
    val content: ComposableContent

    fun compareTo(other: Page): Int {
        return compare(this, other)
    }

    companion object {
        fun compare(left: Page, right: Page): Int {
            if (left.order != right.order) {
                return left.order - right.order
            }
            return left.title.compareTo(right.title)
        }
    }
}
