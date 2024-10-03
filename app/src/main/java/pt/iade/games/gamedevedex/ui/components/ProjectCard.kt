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
import pt.iade.games.gamedevedex.models.Project
import pt.iade.games.gamedevedex.models.Student
import java.net.URI

@Composable
fun ProjectCard(
    project: Project
) {
    Column {
        Text(
            text = "${project.votes}",
            fontSize = 17.sp
        )

        Text("Here a background with screenshot will be placed.")

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = project.title,
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
            project = Project(
                title = "Among Us",
                votes = 2,
                description = "Super sus.",
                id = 404,
                semester = 1,
                assets = listOf(
                    URI.create("https://cdn.mobygames.com/screenshots/12341377-among-us-windows-calling-an-emergency-meeting.png"),
                    URI.create("https://lutris.net/media/games/screenshots/ss_649e19ff657fa518d4c2b45bed7ffdc4264a4b3a.jpg")
                ),
                groupMembers = listOf(
                    Student(
                        id = 123,
                        name = "João Pedro",
                        biography = "Love playing Valorant. Currently thinking of switching courses.",
                        mood = "Lucky",
                        avatar = URI.create("https://media.gettyimages.com/photos/cristiano-ronaldo-of-portugal-poses-during-the-official-fifa-world-picture-id450555852?k=6&m=450555852&s=612x612&w=0&h=aUh0DVio_ubpFtCVvMv3WLR1MVPQji1sN5PDNKvHCT4=")
                    )
                )
            )
        )
        ProjectCard(
            project = Project(
                title = "Zelda: Twilight Princess",
                votes = 123,
                description = "The best Wii game ever made. Apart from Super Smash Bros.",
                id = 404,
                semester = 1,
                assets = listOf(
                    URI.create("https://cdn.mobygames.com/screenshots/12341377-among-us-windows-calling-an-emergency-meeting.png"),
                    URI.create("https://lutris.net/media/games/screenshots/ss_649e19ff657fa518d4c2b45bed7ffdc4264a4b3a.jpg")
                ),
                groupMembers = listOf(
                    Student(
                        id = 123,
                        name = "João Pedro",
                        biography = "Love playing Valorant. Currently thinking of switching courses.",
                        mood = "Lucky",
                        avatar = URI.create("https://media.gettyimages.com/photos/cristiano-ronaldo-of-portugal-poses-during-the-official-fifa-world-picture-id450555852?k=6&m=450555852&s=612x612&w=0&h=aUh0DVio_ubpFtCVvMv3WLR1MVPQji1sN5PDNKvHCT4=")
                    )
                )
            )
        )
    }
}