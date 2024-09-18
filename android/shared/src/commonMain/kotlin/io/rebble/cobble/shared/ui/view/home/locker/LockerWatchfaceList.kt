package io.rebble.cobble.shared.ui.view.home.locker

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import io.rebble.cobble.shared.ui.viewmodel.LockerViewModel

@Composable
fun LockerWatchfaceList(viewModel: LockerViewModel) {
    val entriesState: LockerViewModel.LockerEntriesState by viewModel.entriesState.collectAsState()
    val entries = ((entriesState as? LockerViewModel.LockerEntriesState.Loaded)?.entries ?: emptyList()).filter { it.entry.type == "watchface" }

    LazyVerticalGrid(
            columns = GridCells.Fixed(2),
    ) {
        items(entries.size) { i ->
            LockerWatchfaceItem(entries[i])
        }
    }
}