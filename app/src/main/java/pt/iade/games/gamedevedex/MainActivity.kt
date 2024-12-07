package pt.iade.games.gamedevedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
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
import pt.iade.games.gamedevedex.models.Project
import pt.iade.games.gamedevedex.models.ProjectAsset
import pt.iade.games.gamedevedex.models.Student
import pt.iade.games.gamedevedex.ui.components.ProjectCard
import pt.iade.games.gamedevedex.ui.theme.GamedevedexTheme
import java.net.URI

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
            if (student != null) {
                Text(student!!.name)
            } else {
                // TODO: Show progress circle thingy.
            }

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

fun ProjectExample(): Project {
    return Project(
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
}
