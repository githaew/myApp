package com.jane.malkia.ui.theme.Screens.logout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jane.malkia.navigation.ROUTE_ABOUT_SCREEN
import com.jane.malkia.navigation.ROUTE_LOGOUT
import com.jane.malkia.navigation.ROUTE_REGISTER_SCREEN


@Composable
fun LogoutScreen(navController: NavHostController) {
    Surface(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .background(Color.LightGray),
                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Layout.Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Logout page",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(bottom = 16.dp),
                    fontSize = 30.sp,
                    color = Color.Blue
                )
                Button(onClick ={
                    navController.navigate(ROUTE_ABOUT_SCREEN)
                },modifier = Modifier.padding(8.dp)


                ) {
                    Text(text = "Don't have an account?Go to about.")
                }
                Button(onClick ={
                    navController.navigate(ROUTE_REGISTER_SCREEN)
                },modifier = Modifier.padding(8.dp)


                ) {
                    Text(text = "Don't have an account?Register.")
                }
                Button(onClick ={
                    navController.navigate(ROUTE_LOGOUT)
                },modifier = Modifier.padding(8.dp)


                ) {
                    Text(text = "Successfully registered?Logout.")
                }
            }
        }
    )
}
@Preview(showBackground = true)
@Composable
fun LogoutScreenPreview() {
    LogoutScreen (rememberNavController())
}