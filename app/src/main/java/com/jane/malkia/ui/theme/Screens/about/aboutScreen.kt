package com.jane.malkia.ui.theme.Screens.about

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jane.malkia.navigation.ROUTE_LOGIN_SCREEN


@Composable
fun HomeContent(navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.Gray),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            HomeListItem(title = "Welcome", subtitle = "This app is for students registration while taking a book from the school library.",navController=navController)
        }
        item {
            HomeListItem(title = "About", subtitle = "Students are required to give there information as inquired.Fill the spaces with correct information.",navController=navController)
        }

//            HomeListItem(title = "Item 4", subtitle = "Description for Item 4")
    }

}


@Composable
fun HomeListItem(title: String, subtitle: String,navController: NavController) {
    Card(
        modifier = Modifier.fillMaxWidth(),
//        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Start
            )
        }
    }
    Button(
        onClick = {
            navController.navigate(ROUTE_LOGIN_SCREEN)
        },
        modifier = Modifier
            .fillMaxSize()
            .height(100.dp)
    ) {
        Text(text="Login", fontSize = 30.sp)
    }

}

@Preview(showBackground=true)
@Composable
fun HomeContentPreview(){
    HomeContent(rememberNavController())
}