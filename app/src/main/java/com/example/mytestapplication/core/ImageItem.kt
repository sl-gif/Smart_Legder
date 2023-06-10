package com.example.mytestapplication.core

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.mytestapplication.R

@Composable
fun ImageItemWithName(
    modifier: Modifier = Modifier,
    name: String,
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    painter: Painter = painterResource(id = R.drawable.ic_launcher_foreground)
){
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Image(
            painter = painter,
            contentDescription = null,
            modifier = modifier
                //   .width(10.dp)
                .clip(RoundedCornerShape(6.dp))


        )
        Text(
            text = name,
            style = textStyle,
            color = Color.Black
        )
    }
    }


@Composable
fun ImageItemWithoutName(
    modifier: Modifier = Modifier,
    painter: Painter = painterResource(id = R.drawable.ic_launcher_foreground)
){
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Image(
            painter = painter,
            contentDescription = null,
            modifier = modifier
                //   .width(10.dp)
                .clip(RoundedCornerShape(6.dp))


        )
    }
}
