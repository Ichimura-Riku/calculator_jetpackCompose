package com.example.calculator

import android.inputmethodservice.Keyboard
import android.os.Bundle
import android.preference.PreferenceActivity.Header
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                // A surface container using the 'background' color from the theme
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyApp(modifier: Modifier = Modifier) {

    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        Column {
            Header(modifier = Modifier)
            OutPutCalcScreen(modifier = Modifier)
            OnButtonScreen(modifier = Modifier)
        }
    }

}

@Composable
fun Header(modifier: Modifier = Modifier) {
    Surface(modifier, color = MaterialTheme.colorScheme.primary) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 55.dp, vertical = 15.dp
                ),
//            verticalArrangement = Arrangement,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "calculator", style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Medium
                )
            )
        }
    }
}

@Composable
fun OutPutCalcScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier.fillMaxWidth()
    ) {
        Text(
            text = "1103865",
            modifier = modifier
                .background(
                    color = MaterialTheme.colorScheme.secondary,
                    shape = RoundedCornerShape(0.dp, 0.dp, 28.dp, 28.dp)
                )
                .padding(vertical = 80.dp, horizontal = 10.dp),
            style = MaterialTheme.typography.displayMedium.copy(
                fontWeight = FontWeight.ExtraBold
            ),
            textAlign = TextAlign.End
        )
    }
}

@Composable
fun OnButtonScreen(modifier: Modifier = Modifier) {
    val calcKeyList:Array<Array<String>> = arrayOf(
        arrayOf("ac", "^", "%", "÷"),
        arrayOf("7", "8", "9", "x"),
        arrayOf("4", "5", "6", "-"),
        arrayOf("1", "2", "3", "+"),
        arrayOf("0", ".", "←", "=")
    )

    Column(
        modifier = modifier.padding(vertical = 6.dp)
    ) {
        for (i in 0..4 ) {
            Row(
                modifier = modifier.padding(horizontal = 6.dp)
            ) {
                for (j in 0..3){
//                    CalcKey(CalcKeyList[i][j])
                    Text(
                        text = calcKeyList[i][j],
                        modifier = modifier
                            .background(
                                color = MaterialTheme.colorScheme.tertiary,
                                shape = RoundedCornerShape(10.dp, 10.dp, 10.dp, 10.dp)
                            )
                            .padding(vertical = 15.dp, horizontal = 15.dp),
                        style = MaterialTheme.typography.displayMedium.copy(
                            fontWeight = FontWeight.ExtraBold
                        ),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CalculatorTheme {
        MyApp(modifier = Modifier)
    }

}

@Preview(showBackground = true)
@Composable
fun HeaderPreview() {
    CalculatorTheme {
        Header(modifier = Modifier)
    }

}

@Preview(showBackground = true)
@Composable
fun OutPutCalcScreenPreview() {
    CalculatorTheme {
        OutPutCalcScreen(modifier = Modifier)
    }

}

@Preview(showBackground = true)
@Composable
fun OnButtonScreenPreview() {
    CalculatorTheme {
        OnButtonScreen(modifier = Modifier)
    }

}