package com.kardelencetin.moviekmm.android.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import coil.compose.AsyncImage
import androidx.compose.ui.unit.dp
import com.kardelencetin.moviekmm.android.R

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    uiState: DetailScreenState
) {
    Box(contentAlignment = Alignment.Center) {
        uiState.movie?.let { movie ->
            Column(
                modifier = modifier.fillMaxSize().background(color = MaterialTheme.colors.background)
            ) {
                AsyncImage(model = movie.imageUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth().height(320.dp)
                )
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .weight(1f)
                        .padding(8.dp)
                ) {
                    Text(text = movie.title,
                        style = MaterialTheme.typography.h5,
                        fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(
                        onClick = {},
                        modifier = Modifier.fillMaxWidth().height(46.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Red
                        ),
                        elevation = ButtonDefaults.elevation(
                            defaultElevation = 0.dp
                        )
                    ) {
                        Icon(painter = painterResource(R.drawable.play_button), contentDescription = null, tint = Color.White)
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = " Start watching now", color = Color.White)
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Released in ${movie.releaseDate}".uppercase(), color = Color.White, style = MaterialTheme.typography.overline)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = movie.description, color = Color.White, style = MaterialTheme.typography.body2)
                }
            }
        }
        if (uiState.loading) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                CircularProgressIndicator(color = Color.Red)
            }
        }
    }
}