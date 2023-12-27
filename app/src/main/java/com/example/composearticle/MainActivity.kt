package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme
import androidx.compose.material3.Surface as Surface

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeArticleApp()
                }
            }
        }
    }
}

@Composable
fun ComposeArticleApp() {
    ArticleCard(
        title = stringResource(R.string.title),
        shortDesc = stringResource(R.string.short_desc),
        longDesc = stringResource(R.string.long_desc),
        image = painterResource(R.drawable.bg_compose_background),
        )
}

@Composable
private fun ArticleCard(
    title: String,
    shortDesc: String,
    longDesc: String,
    image: Painter,
    modifier: Modifier = Modifier,
    ) {
    Column(modifier = modifier) {
        Image(painter = image, contentDescription = null)

        Text(
            text = title, fontSize = 24.sp,
            modifier = modifier.padding(16.dp),
            )

        Text(
            text = shortDesc,
            modifier = modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )

        Text(
            text = longDesc,
            modifier = modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeArticleAppPerview() {
    ComposeArticleTheme{
        ComposeArticleApp()
    }
}