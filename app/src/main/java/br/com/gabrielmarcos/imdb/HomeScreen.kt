package br.com.gabrielmarcos.imdb

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import br.com.gabrielmarcos.imdb.navigation.Navigator
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@Composable
fun HomeScreen(context: Context, nav: Navigator) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column {
            Header(onSearchAction = {
                Toast.makeText(context, "BUSCANDO", Toast.LENGTH_SHORT)
                    .show()
            })
            MainContent(context = context, nav = nav)
        }
    }
}

@Composable
fun MainContent(context: Context, nav: Navigator) {
    LazyColumn {
        item {
            Tips(
                tips = listOf(
                    "Terror",
                    "Comedia",
                    "Romance",
                    "Animação",
                    "Outros",
                    "Documentarios",
                    "Interativos",
                    "Comedia Romantica"
                )
            ) { nav.performDetail() }
            Carousel(movies = hashMapOf(
                "Star Wars" to "https://cloud.netlifyusercontent.com/assets/344dbf88-fdf9-42bb-adb4-46f01eedd629/9ada75bf-aba2-4259-b1ca-16d33469a46f/14.jpg",
                "Walk the Line" to "https://cloud.netlifyusercontent.com/assets/344dbf88-fdf9-42bb-adb4-46f01eedd629/529fb627-f365-4d49-83a2-4fb44b375282/15.jpg",
                "Grindhouse" to "https://cloud.netlifyusercontent.com/assets/344dbf88-fdf9-42bb-adb4-46f01eedd629/4e382411-3c56-4da1-bb26-630fa185182d/13.jpg",
                "Spirit" to "https://cloud.netlifyusercontent.com/assets/344dbf88-fdf9-42bb-adb4-46f01eedd629/f3367401-bd09-4df0-9d8d-6b0deb7a450e/4.jpg",
                "Vacancy" to "https://cloud.netlifyusercontent.com/assets/344dbf88-fdf9-42bb-adb4-46f01eedd629/3084569a-9ee8-4827-b40a-d69f128d63a9/vacancy.jpg",
                "V For Vendetta" to "https://cloud.netlifyusercontent.com/assets/344dbf88-fdf9-42bb-adb4-46f01eedd629/a6411636-c6e7-4524-8800-9a3e4e36787e/v.jpg",
                "The Dark Knight" to "https://cloud.netlifyusercontent.com/assets/344dbf88-fdf9-42bb-adb4-46f01eedd629/22a1881f-eaef-4998-aafd-1600538b1ca3/the-dark-knight.jpg"

            ), onCarouselAction = {
                Toast.makeText(
                    context,
                    "SELECIONANDO FILME: $it",
                    Toast.LENGTH_SHORT
                ).show()
            })
            Text(
                text = "Viewers' choice",
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Viewers(
                listOf(
                    ViewersChoice(
                        title = "How to train your dragon 2",
                        image = "https://cloud.netlifyusercontent.com/assets/344dbf88-fdf9-42bb-adb4-46f01eedd629/9ada75bf-aba2-4259-b1ca-16d33469a46f/14.jpg",
                        rating = 0.0f,
                        description = LoremIpsum(10).values.joinToString()
                    ),
                    ViewersChoice(
                        title = "How to train your dragon 2",
                        image = "https://cloud.netlifyusercontent.com/assets/344dbf88-fdf9-42bb-adb4-46f01eedd629/9ada75bf-aba2-4259-b1ca-16d33469a46f/14.jpg",
                        rating = 0.0f,
                        description = LoremIpsum(10).values.joinToString()
                    ),
                    ViewersChoice(
                        title = "How to train your dragon 2",
                        image = "https://cloud.netlifyusercontent.com/assets/344dbf88-fdf9-42bb-adb4-46f01eedd629/9ada75bf-aba2-4259-b1ca-16d33469a46f/14.jpg",
                        rating = 0.0f,
                        description = LoremIpsum(10).values.joinToString()
                    ),
                    ViewersChoice(
                        title = "How to train your dragon 2",
                        image = "https://cloud.netlifyusercontent.com/assets/344dbf88-fdf9-42bb-adb4-46f01eedd629/9ada75bf-aba2-4259-b1ca-16d33469a46f/14.jpg",
                        rating = 0.0f,
                        description = LoremIpsum(10).values.joinToString()
                    ),
                    ViewersChoice(
                        title = "How to train your dragon 2",
                        image = "https://cloud.netlifyusercontent.com/assets/344dbf88-fdf9-42bb-adb4-46f01eedd629/9ada75bf-aba2-4259-b1ca-16d33469a46f/14.jpg",
                        rating = 0.0f,
                        description = LoremIpsum(10).values.joinToString()
                    ),
                )
            ) {
                Toast.makeText(
                    context,
                    "SELECIONANDO FILME",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}

@Composable
fun Header(
    onSearchAction: () -> Unit
) {
    Row(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Popular now",
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.h2,
            modifier = Modifier.weight(1f)
        )
        Icon(
            Icons.Rounded.Search,
            contentDescription = "Search",
            modifier = Modifier.clickable(enabled = true) { onSearchAction() }
        )
    }
}

@Composable
fun Tips(
    tips: List<String>,
    onTipAction: (String) -> Unit,
) {
    val state = rememberLazyListState()

    LazyRow(
        modifier = Modifier.padding(horizontal = 16.dp),
        state = state,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        items(tips) { data -> TipItem(data) { onTipAction(it) } }
    }
}


@Composable
fun TipItem(
    title: String,
    onTipAction: (String) -> Unit,
) {
    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colors.onPrimary,
                shape = RoundedCornerShape(10.dp)
            )
            .clickable { onTipAction(title) }
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onPrimary,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Carousel(
    movies: HashMap<String, String>,
    onCarouselAction: (String) -> Unit,
) {
    Row(
        modifier = Modifier.padding(vertical = 16.dp)
    ) {
        val state = rememberPagerState()

        HorizontalPager(
            count = movies.size,
            state = state,
            contentPadding = PaddingValues(horizontal = 64.dp)
        ) { page ->
            val key = movies.keys.toMutableList()[page]
            val value = movies[key].orEmpty()

            Card(
                modifier = Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .clickable { onCarouselAction(value) }
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(value)
                        .crossfade(true)
                        .build(),
                    modifier = Modifier
                        .width(250.dp)
                        .height(300.dp),
                    contentDescription = key,
                    contentScale = ContentScale.FillWidth
                )
            }
        }
    }
}

data class ViewersChoice(
    val title: String,
    val image: String,
    val rating: Float,
    val description: String,
)

@Composable
fun Viewers(
    data: List<ViewersChoice>,
    onViewerAction: () -> Unit,
) {
    data.forEach {
        ViewerItem(
            title = it.title,
            image = it.image,
            rating = it.rating,
            description = it.description
        ) {
            onViewerAction()
        }
    }
}

@Composable
fun ViewerItem(
    title: String,
    image: String,
    rating: Float,
    description: String,
    onViewerAction: () -> Unit,
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .fillMaxWidth()
            .clickable { onViewerAction() }
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(image)
                .crossfade(true)
                .build(),
            modifier = Modifier
                .width(100.dp)
                .height(150.dp),
            contentDescription = "",
            contentScale = ContentScale.FillWidth
        )
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically),
        ) {
            Text(text = title)
            Text(text = description, modifier = Modifier.padding(top = 8.dp))
        }
    }
}
