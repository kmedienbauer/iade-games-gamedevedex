package pt.iade.games.gamedevedex.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProjectCard(
    title: String,
    votes: Int
) {
    Column {
        Text(
            text = "$votes",
            fontSize = 17.sp
        )

        Text("Here a background with screenshot will be placed.")

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Button(
                onClick = { },
                modifier = Modifier.padding(start = 30.dp)
            ) {
                Text("Vote")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ProjectCardPreview() {
    Column {
        ProjectCard(
            title = "Among Us",
            votes = 2
        )
        ProjectCard(
            title = "Zelda: Twilight Princess",
            votes = 123
        )
    }
}