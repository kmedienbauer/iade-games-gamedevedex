package pt.iade.games.gamedevedex.ui.components

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import pt.iade.games.gamedevedex.MainActivity
import pt.iade.games.gamedevedex.ProjectDetailActivity
import pt.iade.games.gamedevedex.R

@Composable
fun HeaderDetail(
    title: String,
    lerp: Float
)
{
    val context = LocalContext.current
    val defaultColorContainer = Color(red= 1f, green = 1f, blue = 1f, alpha = 0.3f)
    val scrollColorContainer =  Color(0xFFCDF2BE)
    val defaultColorText = Color.White
    val scrollColorText =  Color.DarkGray
    var lerpColorContainer = lerp(defaultColorContainer, scrollColorContainer, lerp)
    var lerpColorText = lerp(defaultColorText, scrollColorText, lerp)

    Box(
        modifier = Modifier.
        offset(y = -4.dp)

    ) {
        Column() {
            Card(
                shape = RoundedCornerShape(0.dp, 0.dp, 16.dp, 16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = lerpColorContainer
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .border(3.dp, lerpColorText, RoundedCornerShape(0.dp, 0.dp, 16.dp, 16.dp))
            ) {
                Row(){
                    Button(
                        onClick = {
                            Toast.makeText(context, "main screen",
                                Toast.LENGTH_SHORT).show()
                            val intent = Intent(context, MainActivity::class.java)
                            context.startActivity(intent)
                        },
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .padding(start = 10.dp)
                            .rotate(-90f)
                            .height(25.dp)
                            .width(25.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent
                        ),
                        contentPadding = PaddingValues(0.dp),
                        shape = RoundedCornerShape(0.dp),

                        ) {
                        if(lerp > 0.3){
                            Image(
                                painter = painterResource(id = R.drawable.votebutton),
                                contentDescription = "back button",
                                //contentScale = ContentScale.FillBounds,
                                modifier = Modifier
                                    .padding(0.dp)
                                    .fillMaxSize(),
                            )
                        }else{
                            Image(
                                painter = painterResource(id = R.drawable.backbutton),
                                contentDescription = "back button",
                                //contentScale = ContentScale.FillBounds,
                                modifier = Modifier
                                    .padding(0.dp)
                                    .fillMaxSize(),
                            )
                        }

                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .offset(x=-35.dp),
                        contentAlignment = Alignment.Center,
                    ){
                        Text(
                            text = "${title}",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = lerpColorText,
                            modifier = Modifier.padding(top = 13.dp, bottom = 13.dp)
                        )
                    }
            }

            }
        }
    }
}


@Preview
@Composable
fun HeaderDetailPreview() {
    Box(
        modifier = Modifier
            //.fillMaxSize()
    ) {
        HeaderDetail(
            title = "Unbox the Truth",
            lerp = 0.3f
        )
    }

}