package com.example.practice_tabandpager2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice_tabandpager2.ui.theme.Practice_TabAndPager2Theme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

val pages = listOf("페이지1", "페이지2", "페이지3", "페이지4", "페이지5", "페이지6")

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practice_TabAndPager2Theme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { pages.size }
    )
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TabLayout(pagerState = pagerState, coroutineScope = coroutineScope)
        PagerContent(pagerState = pagerState)
    }
}

@Composable
fun TabLayout(pagerState: PagerState, coroutineScope: CoroutineScope) {
    ScrollableTabRow(
        edgePadding = 0.dp,
        selectedTabIndex = pagerState.currentPage,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage])
            )
        }
    ) {
        pages.forEachIndexed { index, title ->
            Tab(
                text = { Text(text = title) },
                selected = pagerState.currentPage == index,
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}

@Composable
fun PagerContent(pagerState: PagerState) {
    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->
        Text(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(),
            text = "Page ${page + 1}",
            textAlign = TextAlign.Center,
            fontSize = 30.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    Practice_TabAndPager2Theme {
        MainScreen()
    }
}
