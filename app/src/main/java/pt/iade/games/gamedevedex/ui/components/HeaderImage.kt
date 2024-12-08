package pt.iade.games.gamedevedex.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import pt.iade.games.gamedevedex.R

@Composable
fun HeaderImage(
    headerimage: Int,
    headerimage_description: String
) {
    //simple image with crop scale and fixed heigth
        Image(
            painter = painterResource(id = headerimage),
            contentDescription = headerimage_description,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(285.dp)
                .zIndex(-1f)
        )
    }




@Preview
@Composable
fun HeaderImagePreview() {
    Box(
        modifier = Modifier
        //.fillMaxSize()
    ) {
        HeaderImage(
            headerimage = R.drawable.unboxthetruth_asset_image0,
            headerimage_description = "Unbox the Truth Screen"
        )
    }

}