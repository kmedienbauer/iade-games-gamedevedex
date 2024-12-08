package pt.iade.games.gamedevedex.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import pt.iade.games.gamedevedex.R
import pt.iade.games.gamedevedex.models.MoodEnum
import pt.iade.games.gamedevedex.models.Project
import pt.iade.games.gamedevedex.models.ProjectAsset
import pt.iade.games.gamedevedex.models.Student

@Composable
fun ProjectDetail(project: Project) {
    val scrollState = rememberScrollState()
    var scrollOffset by remember { mutableStateOf(0f) } // Variable to track scroll offset
    var blend by remember { mutableStateOf(0f) } // Variable to blend colors

    //calculate blend variable on scroll
    LaunchedEffect(scrollState.value) {
        scrollOffset = scrollState.value.toFloat()
        blend = mapRange(scrollOffset, 0f, 285f, 0f, 1f)
    }


    Column(
        modifier = Modifier
            .padding(0.dp)
            .background(Color.Transparent)
            .fillMaxSize()

    ) {
        Column {
            //header with mutable blend attribute to blend colors on scroll
            HeaderDetail(
                title = project.title,
                lerp = blend
            )
        }
        // column to make the content scrollable
        Column(
            modifier = Modifier
                .offset(y = -50.dp)
                .zIndex(-1f)
                .verticalScroll(scrollState)
                .fillMaxSize()
        ) {
            //header image
            HeaderImage(headerimage = project.assets[0].assetResource,
                headerimage_description = project.description)
            //box to offset all the content to the top to avoid gaps from the rounded corners
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxSize()
                    .background(Color.Transparent)
                    .offset(y = -80.dp)
            ){
                Column {
                    //project description with vote counter
                    ProjectDescriptionDetail(project = project)
                    //column for student info cards
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                            .wrapContentHeight(),
                    ) {
                        val items = project.groupMembers
                        items.forEach { groupMember ->
                            UserInfoCard(student = groupMember)
                        }
                    }
                    // column for assets
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                            .wrapContentHeight(),
                    ) {
                        val items = project.assets
                        //drop the first asset because it is the header image
                        items.drop(1).forEach { projectasset ->
                            DetailAssetImage(assetImage = projectasset.assetResource,
                                assetImageDescription = projectasset.assetDescription)
                        }
                    }

                }


            }
        }

}
}

@Preview
@Composable
fun PreviewProjectDetail(){
    val projectDefault = Project(
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
                mood = MoodEnum.SAD,
                avatar = R.drawable.default_avatar
            ),
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
                mood = MoodEnum.HAPPY,
                avatar = R.drawable.default_avatar
            )
        )
    )

    ProjectDetail(project = projectDefault)
}


fun mapRange(value: Float, inMin: Float, inMax: Float, outMin: Float, outMax: Float): Float {
    return outMin + (value - inMin) * (outMax - outMin) / (inMax - inMin)
}