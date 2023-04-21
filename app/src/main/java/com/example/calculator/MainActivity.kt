package com.example.calculator

import android.os.Bundle
import android.preference.PreferenceActivity.Header
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
            OutPutCalcState(modifier = Modifier)
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
fun OutPutCalcState(modifier: Modifier = Modifier) {
    Surface(
        modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.secondary,


        ) {
        Text(
            text = "1103865",
            modifier = modifier
                .padding(vertical = 80.dp, horizontal = 10.dp)
                .background(
                    color = MaterialTheme.colorScheme.secondary,
                    shape = RoundedCornerShape(0.dp, 0.dp, 28.dp, 28.dp)
                ),
            style = MaterialTheme.typography.displayMedium.copy(
                fontWeight = FontWeight.ExtraBold
            ),
            textAlign = TextAlign.End
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CalculatorTheme {
//        Greeting("Android")
        Header()
        MyApp(modifier = Modifier)
    }

}

@Preview(showBackground = true)
@Composable
fun HeaderPreview() {
    CalculatorTheme {
//        Greeting("Android")
        Header()
        Header(modifier = Modifier)
    }

}