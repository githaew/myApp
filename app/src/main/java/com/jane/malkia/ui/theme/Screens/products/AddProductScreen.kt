package com.jane.malkia.ui.theme.Screens.products

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jane.malkia.data.ProductViewModel
import com.jane.malkia.navigation.ROUTE_VIEW_PRODUCT


@Composable
fun AddProductsScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        val context = LocalContext.current
        Text(
            text = "Add product",
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Red,
            modifier = Modifier.padding(20.dp),
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline
        )

        var productName by remember { mutableStateOf(TextFieldValue("")) }
        var productStream by remember { mutableStateOf(TextFieldValue("")) }
        var productBooktitle by remember { mutableStateOf(TextFieldValue("")) }

        OutlinedTextField(
            value = productName,
            onValueChange = { productName = it },
            label = { Text(text = "Enter name *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = productStream,
            onValueChange = { productStream = it },
            label = { Text(text = "Stream *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = productBooktitle,
            onValueChange = { productBooktitle = it },
            label = { Text(text = "Book title *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {

            val productRepository = ProductViewModel(navController,context)
            productRepository.saveProduct(productName.text.trim(),productStream.text.trim(),
                productBooktitle.text)
            navController.navigate(ROUTE_VIEW_PRODUCT)


        }) {
            Text(text = "Save")
        }
        Spacer(modifier = Modifier.height(20.dp))
//
//        //---------------------IMAGE PICKER START-----------------------------------//
//
//        ImagePicker(Modifier,context, navController, productName.text.trim(), productQuantity.text.trim(), productPrice.text.trim())
//
//        //---------------------IMAGE PICKER END-----------------------------------//

    }
}

//@Composable
//fun ImagePicker(modifier: Modifier = Modifier, context: Context, navController: NavHostController, name:String, quantity:String, price:String) {
//    var hasImage by remember { mutableStateOf(false) }
//    var imageUri by remember { mutableStateOf<Uri?>(null) }
//
//    val imagePicker = rememberLauncherForActivityResult(
//        contract = ActivityResultContracts.GetContent(),
//        onResult = { uri ->
//            hasImage = uri != null
//            imageUri = uri
//        }
//    )
//
//    Column(modifier = modifier,) {
//        if (hasImage && imageUri != null) {
//            val bitmap = MediaStore.Images.Media.
//            getBitmap(context.contentResolver,imageUri)
//            Image(bitmap = bitmap.asImageBitmap(), contentDescription = "Selected image")
//        }
//        Column(
//            modifier = Modifier.fillMaxWidth().padding(bottom = 32.dp), horizontalAlignment = Alignment.CenterHorizontally,) {
//            Button(
//                onClick = {
//                    imagePicker.launch("image/*")
//                },
//            ) {
//                Text(
//                    text = "Select Image"
//                )
//            }
//
//            Spacer(modifier = Modifier.height(20.dp))
//
//            Button(onClick = {
//                //-----------WRITE THE UPLOAD LOGIC HERE---------------//
//                var productRepository = productviewmodel(navController,context)
//                productRepository.saveProductWithImage(name, quantity, price,imageUri!!)
//
//
//            }) {
//                Text(text = "Upload")
//            }
//        }
//    }
//}


@Preview
@Composable
fun AddProductScreen() {
    AddProductsScreen(rememberNavController())

}