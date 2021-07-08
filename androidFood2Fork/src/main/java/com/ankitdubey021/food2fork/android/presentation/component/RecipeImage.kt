package com.ankitdubey021.food2fork.android.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.imageloading.ImageLoadState

const val RECIPE_IMAGE_HEIGHT = 260

@Composable
fun RecipeImage(
    url : String,
    contentDesc : String
) {

    val painter = rememberCoilPainter(url)
    Box{
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(RECIPE_IMAGE_HEIGHT.dp),
            painter = painter,
            contentDescription = contentDesc,
            contentScale = ContentScale.Crop
        )
    }
    when(painter.loadState){
        is ImageLoadState.Error -> {}
        is ImageLoadState.Loading -> {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(RECIPE_IMAGE_HEIGHT.dp)
            ){

            }
        }
    }
}