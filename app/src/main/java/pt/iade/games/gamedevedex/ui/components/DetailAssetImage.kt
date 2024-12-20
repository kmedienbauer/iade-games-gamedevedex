package pt.iade.games.gamedevedex.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.games.gamedevedex.R

@Composable
fun DetailAssetImage(
    assetImage: Int,
    assetImageDescription: String
) {
    //card to get rounded corners
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        //.background(Color.White),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFCDF2BE)
        ),
        shape = RoundedCornerShape(25.dp),
    ){
        // box to set the image and text on top of each other, text content aligned to the bottom
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomCenter,

        ){
            Image(
                painter = painterResource(id = assetImage),
                contentDescription = assetImageDescription,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
            )
            // image description with shadow to make it readable on top of the image
            Text(
                text = "${assetImageDescription}",
                fontWeight = FontWeight.Light,
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(10.dp),
                style = TextStyle(
                shadow = Shadow(
                    color = Color.Black.copy(alpha = 0.8f),
                    offset = Offset(4f, 4f),
                    blurRadius = 8f
                )
                )
            )
        }

    }
}

@Preview
@Composable
fun PreviewDetailAssetImage() {
    DetailAssetImage(
        assetImage = R.drawable.unboxthetruth_asset_image0,
        assetImageDescription = "Project 1"
    )
}