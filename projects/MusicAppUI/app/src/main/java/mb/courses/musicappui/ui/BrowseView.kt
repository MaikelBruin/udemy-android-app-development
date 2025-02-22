package mb.courses.musicappui.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BrowseView() {
    val categories = listOf("Pop", "Funk", "Hiphop", "House", "Techno", "Electro")
    LazyVerticalGrid(columns = GridCells.Fixed(2), horizontalArrangement = Arrangement.Center) {
        items(categories) { cat ->
            Text(text = cat)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BrowsePreview() {
    BrowseView()
}