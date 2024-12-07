package pt.iade.games.gamedevedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import pt.iade.games.gamedevedex.models.Project
import pt.iade.games.gamedevedex.ui.components.ProjectDescriptionDetail
import pt.iade.games.gamedevedex.ui.components.ProjectDetail
import pt.iade.games.gamedevedex.ui.theme.GamedevedexTheme

class ProjectDetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val project = intent.getParcelableExtra<Project>("project")

        setContent {
            GamedevedexTheme {
                Scaffold(modifier = Modifier
                    .fillMaxSize()
                    .zIndex(-5f)
                    .windowInsetsPadding(WindowInsets.statusBars)
                ) { innerPadding ->
                    Box (
                        modifier = Modifier.padding(innerPadding)

                    ){
                        ProjectDetail(project = project!!)
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GamedevedexTheme {
    }
}