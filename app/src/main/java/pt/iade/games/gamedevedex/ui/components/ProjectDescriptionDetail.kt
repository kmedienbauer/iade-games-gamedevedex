package pt.iade.games.gamedevedex.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.games.gamedevedex.R
import pt.iade.games.gamedevedex.models.Project
import pt.iade.games.gamedevedex.models.ProjectAsset
import pt.iade.games.gamedevedex.models.Student
import java.net.URI

@Composable
fun ProjectDescriptionDetail(
    project: Project
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            //.offset(y=-40.dp)
    ){
        Card(
            modifier = Modifier
                .fillMaxWidth(),
            //.background(Color.White),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFFFFFFF)
            ),
            shape = RoundedCornerShape(40.dp, 40.dp, 0.dp, 0.dp),
        ){
            Row (
                modifier = Modifier
                    .padding(30.dp)
            )
            {
                VoteCounter(project = project)
                Spacer(Modifier.weight(1f))
                Text(text = project.description,
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp,
                    color = Color.Black,
                    modifier = Modifier.width(270.dp)
                )
            }
        }
    }

}


@Preview
@Composable
fun ProjectDescriptionDetailPreview() {
    Column (modifier = Modifier.fillMaxSize()){
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)){

        }
        ProjectDescriptionDetail(
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
                        assetResource = R.drawable.header_image_unboxthetruth
                    ),
                    ProjectAsset(
                        id = 1,
                        assetDescription = "test",
                        assetResource = R.drawable.header_image_unboxthetruth
                    )
                ),
                groupMembers = listOf(
                    Student(
                        id = 123,
                        name = "João Pedro",
                        biography = "Love playing Valorant. Currently thinking of switching courses.",
                        mood = "Lucky",
                        avatar = R.drawable.default_avatar
                    ),
                    Student(
                        id = 123,
                        name = "João Pedro",
                        biography = "Love playing Valorant. Currently thinking of switching courses.",
                        mood = "Lucky",
                        avatar = R.drawable.default_avatar
                    )
                )
            )
        )
    }
}