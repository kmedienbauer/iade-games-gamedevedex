package pt.iade.games.gamedevedex.ui.components

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.games.gamedevedex.ProjectDetailActivity
import pt.iade.games.gamedevedex.R
import pt.iade.games.gamedevedex.models.MoodEnum
import pt.iade.games.gamedevedex.models.Project
import pt.iade.games.gamedevedex.models.ProjectAsset
import pt.iade.games.gamedevedex.models.Student

@Composable
fun ProjectCard(
    project: Project,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    // var votes = project.votes
    var votes by remember { mutableIntStateOf(project.votes) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.DarkGray
        ),
        onClick = {
            Toast.makeText(context, project.title,
                Toast.LENGTH_SHORT).show()
            // Navigate to project detail
            val intent = Intent(context, ProjectDetailActivity::class.java)
            //put the project object in the intent as extra
            intent.putExtra("project", project)
            context.startActivity(intent)
        }
    ) {
        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth(),
        ) {
//            AsyncImage(
//                model = project.assets[0].toString(),
//                placeholder = painterResource(R.drawable.placeholder_cover_image),
//                error =  painterResource(R.drawable.placeholder_cover_image),
//                contentDescription = "Cover image of the game",
//                modifier = Modifier.fillMaxSize(),
//                contentScale = ContentScale.Crop
//            )
            Image(
                painter = painterResource(id = project.assets[0].assetResource),
                contentDescription = "Cover image of the game",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Text(
                    text = "$votes",
                    modifier = Modifier.background(Color.Transparent),
                    fontSize = 17.sp,
                    color = Color(255, 255, 255)

                )
            }
        }

        Row(
            modifier = Modifier
                .padding(10.dp)
                .background(Color.DarkGray),
            verticalAlignment = Alignment.CenterVertically

        ) {
            Text(
                text = project.title,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.weight(weight = 1f),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.White
            )
            Button(
                onClick = {
                    votes++
                    project.votes++
                },
                modifier = Modifier.padding(start = 30.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFCDF2BE),
                    contentColor = Color.DarkGray
                )
            ) {
                Text("Vote")
            }
        }
    }
}

@Composable
@Preview()
fun ProjectCardPreview() {
    Column {
        ProjectCard(
            modifier = Modifier.padding(vertical = 20.dp),
            project = Project(
                title = "Among Us",
                votes = 123,
                description = "Super sus.",
                id = 404,
                semester = 1,
                assets = listOf(
                    ProjectAsset(
                        id = 1,
                        assetDescription = "test",
                        assetResource = R.drawable.unboxthetruth_asset_image0
                    ),
                    ProjectAsset(
                        id = 1,
                        assetDescription = "test",
                        assetResource = R.drawable.unboxthetruth_asset_image0
                    )
                ),
                groupMembers = listOf(
                    Student(
                        id = 123,
                        name = "João Pedro",
                        biography = "Love playing Valorant. Currently thinking of switching courses.",
                        mood = MoodEnum.STRESSED,
                        avatar = R.drawable.default_avatar
                    ),
                    Student(
                        id = 123,
                        name = "João Pedro",
                        biography = "Love playing Valorant. Currently thinking of switching courses.",
                        mood = MoodEnum.HAPPY,
                        avatar = R.drawable.default_avatar
                    )
                )
            )
        )
        ProjectCard(
            modifier = Modifier.padding(vertical = 20.dp),
            project = Project(
                title = "Among Us",
                votes = 123,
                description = "Super sus.",
                id = 404,
                semester = 1,
                assets = listOf(
                    ProjectAsset(
                        id = 1,
                        assetDescription = "test",
                        assetResource = R.drawable.unboxthetruth_asset_image0
                    ),
                    ProjectAsset(
                        id = 1,
                        assetDescription = "test",
                        assetResource = R.drawable.unboxthetruth_asset_image0
                    )
                ),
                groupMembers = listOf(
                    Student(
                        id = 123,
                        name = "João Pedro",
                        biography = "Love playing Valorant. Currently thinking of switching courses.",
                        mood = MoodEnum.HAPPY,
                        avatar = R.drawable.default_avatar
                    ),
                    Student(
                        id = 123,
                        name = "João Pedro",
                        biography = "Love playing Valorant. Currently thinking of switching courses.",
                        mood = MoodEnum.STRESSED,
                        avatar = R.drawable.default_avatar
                    )
                )
            )
        )
    }
}