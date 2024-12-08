package pt.iade.games.gamedevedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.games.gamedevedex.controllers.StudentController
import pt.iade.games.gamedevedex.models.MoodEnum
import pt.iade.games.gamedevedex.models.Project
import pt.iade.games.gamedevedex.models.ProjectAsset
import pt.iade.games.gamedevedex.models.Student
import pt.iade.games.gamedevedex.ui.components.ProjectCard
import pt.iade.games.gamedevedex.ui.theme.GamedevedexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GamedevedexTheme {
                MainView()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView() {
    var student by remember { mutableStateOf<Student?>(null) }
    val studentController = StudentController()
    studentController.GetById(
        id = 123,
        onSuccess = { studentReq ->
            student = studentReq
        }
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text("Gamedevedex")
                },
                colors = topAppBarColors(
                    containerColor = Color.DarkGray,
                    titleContentColor = Color.White,
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            ProjectCard(
                modifier = Modifier
                    .padding(vertical = 20.dp),
                project = ProjectExample()
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MainViewPreview() {
    GamedevedexTheme {
        MainView()
    }
}

// Example project with data for "Unbox The Truth" to be used in the ProjectCard
fun ProjectExample(): Project {
    return Project(
        title = "Unbox The Truth",
        votes = 164,
        description = "Unbox the Truth is a 2D side-view puzzle platform. Players will explore a dystopian, hyper-consumerist warehouse playing as a conscious cardboard box.",
        id = 1,
        semester = 3,
        assets = listOf(
            ProjectAsset(
                id = 1,
                assetDescription = "header image - ingame screenshot",
                assetResource = R.drawable.unboxthetruth_asset_image0
            ),
            ProjectAsset(
                id = 2,
                assetDescription = "level 1",
                assetResource = R.drawable.unboxthetruth_asset_image1
            ),
            ProjectAsset(
                id = 3,
                assetDescription = "level 2",
                assetResource = R.drawable.unboxthetruth_asset_image2
            ),
            ProjectAsset(
                id = 4,
                assetDescription = "level 3",
                assetResource = R.drawable.unboxthetruth_asset_image3
            ),
            ProjectAsset(
                id = 5,
                assetDescription = "hublevel",
                assetResource = R.drawable.unboxthetruth_asset_image4
            )

        ),
        groupMembers = listOf(
            Student(
                id = 1,
                name = "Dito Junior",
                biography = "Dito is 24 years old and currently studying in the 3rd sememster Games Development in IADE. He is a passionate gamer and loves to play all kinds of Games.",
                mood = MoodEnum.HAPPY,
                avatar = R.drawable.default_avatar
            ),
            Student(
                id = 2,
                name = "Filippo Trafarello",
                biography = "Filippo  is a 23 years old italian student in the 3rd semester of Games Development in IADE. Among us is his favorite game.",
                mood = MoodEnum.STRESSED,
                avatar = R.drawable.default_avatar
            ),
            Student(
                id = 2,
                name = "Konstantin Meidenbauer",
                biography = "Konstantin is currently studying abroad as an ERASMUS student. In Portugal he is studying Games Development in the 3rd semester. But usually he is studying in Germany in the field of Visual Effects for movies.",
                mood = MoodEnum.TIRED,
                avatar = R.drawable.default_avatar
            )
        )
    )
}
