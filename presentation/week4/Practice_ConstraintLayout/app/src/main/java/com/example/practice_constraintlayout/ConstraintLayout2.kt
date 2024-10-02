package com.example.practice_constraintlayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import com.example.practice_constraintlayout.ui.theme.Practice_ConstraintLayoutTheme

@Composable
fun ConstraintLayout2() {
    val constraintSet = ConstraintSet {
        val box1 = createRefFor("box1")
        val box2 = createRefFor("box2")
        val box3 = createRefFor("box3")
        val box4 = createRefFor("box4")

        constrain(box1) {
            start.linkTo(parent.start)
            top.linkTo(parent.top)
        }

        constrain(box2) {
            end.linkTo(parent.end)
            top.linkTo(parent.top)
        }

        constrain(box3) {
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
        }

        constrain(box4) {
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end)
        }
    }

    ConstraintLayout(
        constraintSet = constraintSet,
        modifier = Modifier.size(60.dp)
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .size(10.dp)
                .background(Color.Red)
                .layoutId("box1")
        )

        Box(
            modifier = Modifier
                .size(10.dp)
                .background(Color.Yellow)
                .layoutId("box2")
        )
        Box(
            modifier = Modifier
                .size(10.dp)
                .background(Color.Blue)
                .layoutId("box3")
        )
        Box(
            modifier = Modifier
                .size(10.dp)
                .background(Color.Green)
                .layoutId("box4")
        )
    }
}

@Composable
@Preview
fun Cl2Preview() {
    Practice_ConstraintLayoutTheme {
        ConstraintLayout2()
    }
}