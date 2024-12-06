package pt.iade.games.gamedevedex.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeaderDetail(
    title: String,
)
{

    Box(
        modifier = Modifier

    ) {
        Card(
            shape = RoundedCornerShape(0.dp, 0.dp, 16.dp, 16.dp),
            colors = CardDefaults.cardColors(
                containerColor = lightScheme.primary
            ),
            modifier = if(challenge.isStarted){
                Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
            }else{
                Modifier
                    .fillMaxWidth()
            }
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {

                Text(
                    text = "${title}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    color = lightScheme.secondary

                )
                Row(verticalAlignment = Alignment.CenterVertically)
                {
                    Box(
                        modifier = Modifier
                            .width(150.dp)
                            .weight(1f)
                            .padding(end = 20.dp)
                    )
                    {
                        Text(
                            text = "${challenge.description}",
                            fontWeight = FontWeight.Light,
                            fontSize = 16.sp,
                            color = lightScheme.secondary
                        )
                    }
                    Box(){
                        Button(
                            onClick = {
                                onClick()
                                challenge.isStarted = true
                                mutableStateActive.value = true
                                //mutableStateChallengeId.value = challenge.id
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if(challenge.isStarted){
                                    lightScheme.tertiary
                                }else{
                                    Color.White
                                },
                                contentColor = Color(0xFFAA7950)
                            ),


                            )
                        {
                            Text(
                                if(challenge.isStarted && mutableStateActive.value) "Started" else if (challenge.isStarted) "Continue" else
                                    "Start",
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp,
                                modifier = Modifier
                                    .padding(horizontal = 10.dp)
                            )
                        }
                    }

                }

            }
        }
        if(challenge.isStarted){
            ProgressBar(
                progress = challenge.currSteps.toFloat() / challenge.stepsToReach,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .align(Alignment.BottomCenter)
            )
        }

    }
}
