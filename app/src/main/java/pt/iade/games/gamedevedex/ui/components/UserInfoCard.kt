package pt.iade.games.gamedevedex.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.games.gamedevedex.R
import pt.iade.games.gamedevedex.models.MoodEnum
import pt.iade.games.gamedevedex.models.Project
import pt.iade.games.gamedevedex.models.Student
import java.net.URI

@Composable
fun UserInfoCard(
    student: Student
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ){
        //card to get rounded corners
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFCDF2BE)
            ),
            shape = RoundedCornerShape(25.dp),
        ){
            //row to have picture + mood and description
            Row (
                modifier = Modifier
                    .padding(15.dp)
            )
            {
                //column for picture + mood
                Column {
                    //change border color based on mood
                    Box(
                        modifier =
                        if(student.mood == MoodEnum.HAPPY) {
                             Modifier
                                .size(65.dp)
                                .clip(CircleShape)
                                .border(2.dp, Color.Green, CircleShape)
                        } else if(student.mood == MoodEnum.SAD){
                            Modifier
                                .size(65.dp)
                                .clip(CircleShape)
                                .border(2.dp, Color.Red, CircleShape)

                        }else{
                            Modifier
                                .size(65.dp)
                                .clip(CircleShape)
                                .border(2.dp, Color(0xFFFFBB00), CircleShape)

                        }

                    ) {
                        Image(
                            painter = painterResource(id = student.avatar),
                            contentDescription = "${student.name}'s avatar",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .padding(0.dp)
                                .fillMaxSize()
                        )
                    }
                    //get moodEnum to text
                    Text(
                        text = student.mood.toString().lowercase(),
                        fontWeight = FontWeight.Light,
                        fontSize = 14.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 4.dp)
                    )
                }
                //push the description to the right
                Spacer(Modifier.weight(1f))
                //Column for name and biography
                Column (modifier = Modifier
                    .width(270.dp)
                ){
                     Text(
                        text = student.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Color.Black,

                    )
                    Text(text = student.biography,
                        fontWeight = FontWeight.Light,
                        fontSize = 14.sp,
                        color = Color.Black,

                    )
                }

            }
        }
    }

}


@Preview
@Composable
fun UserInfoCardPreview() {
    Column (modifier = Modifier.fillMaxSize()){
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)){

        }
        UserInfoCard(
            student = Student(
                id = 123,
                name = "João Pedro",
                biography = "Love playing Valorant. Currently thinking of switching courses.",
                mood = MoodEnum.HAPPY,
                avatar = R.drawable.default_avatar
            )
                )
    }
}