package com.example.practice_constraintlayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.practice_constraintlayout.ui.theme.Practice_ConstraintLayoutTheme

@Composable
fun ConstraintLayout1() {
    ConstraintLayout(
        modifier = Modifier.size(60.dp)
            .background(Color.White)) {

        val (box1, box2, box3, box4)  = createRefs()

        Box(
            modifier = Modifier
                .size(10.dp)
                .background(Color.Red)
                .constrainAs(box1) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                }
        )
        Box(
            modifier = Modifier
                .size(10.dp)
                .background(Color.Yellow)
                .constrainAs(box2) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                }
        )
        Box(
            modifier = Modifier
                .size(10.dp)
                .background(Color.Blue)
                .constrainAs(box3) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                }
        )
        Box(
            modifier = Modifier
                .size(10.dp)
                .background(Color.Green)
                .constrainAs(box4) {
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                }
        )
    }
}

@Composable
@Preview
fun Cl1Preview() {
    Practice_ConstraintLayoutTheme {
        ConstraintLayout1()
    }
}