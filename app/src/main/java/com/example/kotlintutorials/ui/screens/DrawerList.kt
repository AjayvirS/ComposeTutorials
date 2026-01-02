package com.example.kotlintutorials.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.kotlintutorials.navigation.DemoDestination

@Composable
fun DrawerList(
    demos: List<DemoDestination>,
    currentRoute: String?,
    onNavigate: (DemoDestination) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(demos, key = { it.route }) { demo ->
            val selected = demo.route == currentRoute
            ListItem(
                headlineContent = {
                    Text(
                        text = stringResource(demo.titleRes),
                        style = if (selected) MaterialTheme.typography.titleMedium
                        else MaterialTheme.typography.bodyLarge
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onNavigate(demo) }
                    .padding(horizontal = 8.dp)
            )
        }
    }
}
