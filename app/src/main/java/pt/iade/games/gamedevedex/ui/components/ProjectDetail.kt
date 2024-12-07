package pt.iade.games.gamedevedex.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import pt.iade.games.gamedevedex.R
import pt.iade.games.gamedevedex.models.Project
import pt.iade.games.gamedevedex.models.ProjectAsset
import pt.iade.games.gamedevedex.models.Student

@Composable
fun ProjectDetail(project: Project) {
    val scrollState = rememberScrollState()
    var scrollOffset by remember { mutableStateOf(0f) } // Variable to track scroll offset
    var blend by remember { mutableStateOf(0f) }
    var defaultColor = Color(red= 1f, green = 1f, blue = 1f, alpha = 0.3f)
    var scrollColor =  Color(0xFFCDF2BE)
    var lerpColor by remember { mutableStateOf(defaultColor) }
    // Update the variable when the scroll state changes
    LaunchedEffect(scrollState.value) {
        scrollOffset = scrollState.value.toFloat()
        blend = mapRange(scrollOffset, 0f, 285f, 0f, 1f)
    }

    val groupmembers = project.groupMembers
    Column(
        modifier = Modifier
            .padding(0.dp)
            .background(Color.Transparent)
            .fillMaxSize()

    ) {
        Column {
            HeaderDetail(
                title = project.title,
                lerp = blend            )
        }
        Column(
            modifier = Modifier
                .offset(y = -50.dp)
                .zIndex(-1f)
                .verticalScroll(scrollState)
                .fillMaxSize()
        ) {
            HeaderImage(headerimage = project.assets[0].assetResource,
                headerimage_description = project.description)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxSize()
                    .background(Color.Transparent)
                    .offset(y = -80.dp)
            ){
                Column {
                    ProjectDescriptionDetail(project = project)
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                            .wrapContentHeight(),
                        //verticalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        val items = groupmembers
                        groupmembers.forEach { groupMember ->
                            UserInfoCard(student = groupMember)
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                            .wrapContentHeight(),
                        //verticalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        val items = project.assets
                        items.forEach { projectasset ->
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
            ),
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

    ProjectDetail(project = projectDefault)
}


fun mapRange(value: Float, inMin: Float, inMax: Float, outMin: Float, outMax: Float): Float {
    return outMin + (value - inMin) * (outMax - outMin) / (inMax - inMin)
}