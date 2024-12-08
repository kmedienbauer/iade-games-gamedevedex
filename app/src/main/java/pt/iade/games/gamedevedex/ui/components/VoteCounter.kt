package pt.iade.games.gamedevedex.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.games.gamedevedex.R
import pt.iade.games.gamedevedex.models.MoodEnum
import pt.iade.games.gamedevedex.models.Project
import pt.iade.games.gamedevedex.models.ProjectAsset
import pt.iade.games.gamedevedex.models.Student

@Composable
fun VoteCounter(
    project: Project
) {
    //mutable state to update the votes
    var votesMutableState = remember {
        mutableStateOf(project.votes)
    }
    Box() {
        //column to have the vote button and the vote count
        Column() {
            Button(
                onClick = {
                    //update the project votes + mutable state on click
                    project.votes += 1
                    votesMutableState.value = project.votes
                },
                modifier = Modifier
                    .height(25.dp)
                    .width(25.dp)
                    .align(Alignment.CenterHorizontally),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                contentPadding = PaddingValues(0.dp),
                //override the shape to have a square button
                shape = RoundedCornerShape(0.dp),
                ) {
                Image(
                    painter = painterResource(id = R.drawable.votebutton),
                    contentDescription = "vote button",
                    //contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .padding(0.dp)
                        .fillMaxSize()
                )
            }
            //use mutable state of votes to update the count on click
            Text(
                text = "${votesMutableState.value}",
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 4.dp)

            )
            Text(
                text = "votes",
                color = Color.Black,
                fontSize = 15.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 0.dp)
                    .offset(y = -5.dp)
            )

        }
    }
}

@Preview
@Composable
fun VoteCounterPreview() {
    VoteCounter(
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
                    mood = MoodEnum.TIRED,
                    avatar = R.drawable.default_avatar
                ),
                Student(
                    id = 123,
                    name = "João Pedro",
                    biography = "Love playing Valorant. Currently thinking of switching courses.",
                    mood = MoodEnum.SAD,
                    avatar = R.drawable.default_avatar
                )
            )
        )
    )
}