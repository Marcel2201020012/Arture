import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.arture.R
import com.example.arture.data.DummyData
import com.example.arture.data.DummyData.artikelcard
import model.ArtikelPopulerCardModel

@Composable
fun ExpandableContentList(
    navController: NavController,
    newArtikelList: List<ArtikelPopulerCardModel>
) {
    val items = remember {
        mutableStateListOf(*artikelcard.toTypedArray())
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        ExpandableCard(
            title = "Artikel",
            content = { TextContent(newArtikelList[0].desc) }
        )
        Spacer(modifier = Modifier.height(8.dp))
        ExpandableCard(
            title = "Video",
            content = { VideoContent(newArtikelList[0].yt) }
        )
        Spacer(modifier = Modifier.height(8.dp))
        ExpandableCard(
            title = "E-Book",
            content = { EbookContent(newArtikelList[0].ebook) }
        )
    }

    Spacer(modifier = Modifier.height(16.dp))
}


@Composable
fun ExpandableCard(
    title: String,
    content: @Composable () -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(1f)
                )
                IconButton(onClick = { isExpanded = !isExpanded }) {
                    Icon(
                        imageVector = if (isExpanded) Icons.Default.ExpandLess
                        else Icons.Default.ExpandMore,
                        contentDescription = null
                    )
                }
            }
            AnimatedVisibility(visible = isExpanded) {
                Column {
                    content()
                }
            }
        }
    }
}

@Composable
fun TextContent(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodySmall,
    )
}

@Composable
fun VideoContent(videoUrl: String) {
    Column {
        Text(
            text = "Watch Video:",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        // Placeholder for video thumbnail (replace with your video player logic)
        Image(
            painter = painterResource(id = R.drawable.beranda_profile_picture), // Replace with your video thumbnail resource
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(8.dp))
        )
    }
}

@Composable
fun EbookContent(ebookInfo: String) {
    Row(
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column (
            Modifier.padding(end = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                modifier = Modifier.size(160.dp),
                painter = painterResource(id = R.drawable.detail_e_book_test),
                contentDescription = "Ebook cover"
            )
            Button(
                onClick = {/*download ebook*/},
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF8B402)
                )
            ) {
                Text(
                    text = "Unduh", style = MaterialTheme.typography.bodySmall
                )
            }
        }

        Column (
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            //judul
            Text("Bertanam Hidroponik", style = MaterialTheme.typography.labelMedium)

            //desc
            TextContent(ebookInfo)
        }
    }
}

@Preview
@Composable
fun ExpandableTest() {
    ExpandableContentList(
        newArtikelList = DummyData.artikelcard,
        navController = rememberNavController()
    )
}