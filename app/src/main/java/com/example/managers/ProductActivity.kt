package com.example.managers

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import com.example.managers.ui.theme.ManagersTheme

class ProductActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            products()

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun products() {
    val mContext = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()){

        TopAppBar(title = { Text(text = "Products On Sale", color = Color.White) },
            colors = TopAppBarDefaults.mediumTopAppBarColors(Color.Red),
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Menu,
                        contentDescription ="" ,
                        tint = Color.White)

                }



            },
            actions = {
                IconButton(onClick = {  val shareIntent=Intent(Intent.ACTION_SEND)
                    shareIntent.type="text/plain"
                    shareIntent.putExtra(Intent.EXTRA_TEXT, "https://qinetralaundry.com/")
                    mContext.startActivity(Intent.createChooser(shareIntent, "Share")) }) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
                IconButton(onClick = { val settingsIntent= Intent(Settings.ACTION_SETTINGS)
                    mContext.startActivity(settingsIntent) }) {
                    Icon(imageVector = Icons.Default.Settings,
                        contentDescription = "",
                        tint = Color.White
                    )


                }
            }

        )

        Spacer(modifier = Modifier.height(5.dp))

       Column(modifier = Modifier
           .fillMaxSize()
           .verticalScroll(rememberScrollState())
           ) {
           Row(modifier = Modifier
               .padding(start = 10.dp)
               .horizontalScroll(rememberScrollState())
           ) {
               Column {
                   Card(modifier = Modifier
                       .size(width = 150.dp, height = 200.dp)){
                       Box(modifier = Modifier.fillMaxSize(),
                           contentAlignment = Alignment.Center){
                           Image(painter = painterResource(id = R.drawable.food ),
                               contentDescription = "",
                               modifier = Modifier.fillMaxSize(),
                               contentScale = ContentScale.Crop)

                           Text(text = "Wet fry",
                               fontSize = 25.sp,
                               fontWeight = FontWeight.ExtraBold,
                               color = Color.White
                           )


                       }

                   }

                   Text(text = "Wet fry",
                       fontSize = 15.sp,
                       color = Color.Black
                   )
                   Text(text = "Ksh500/Kilogram",
                       fontSize = 15.sp,
                       color = Color.Black
                   )

                   Row {
                       Button(onClick = {  val simToolKitLaunchIntent =
                           mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                           simToolKitLaunchIntent?.let { mContext.startActivity(it) }
                       },
                           colors = ButtonDefaults.buttonColors(Color.Red),
                           shape = CutCornerShape(5.dp)
                       ) {
                           Icon(imageVector = Icons.Default.ShoppingCart ,
                               contentDescription = "",
                               tint = Color.White)

                           Text(text = "PAY", color = Color.White)
                       }
                   }

               }

               Spacer(modifier = Modifier.width(10.dp))

               //2nd Column
               Column {
                   Card(modifier = Modifier
                       .size(width = 150.dp, height = 200.dp)){
                       Box(modifier = Modifier.fillMaxSize(),
                           contentAlignment = Alignment.Center){
                           Image(painter = painterResource(id = R.drawable.burger ),
                               contentDescription = "",
                               modifier = Modifier.fillMaxSize(),
                               contentScale = ContentScale.Crop)

                           Text(text = "Delicious",
                               fontSize = 25.sp,
                               fontWeight = FontWeight.ExtraBold,
                               color = Color.White
                           )


                       }

                   }

                   Text(text = "Kings Burger",
                       fontSize = 15.sp,
                       color = Color.Black
                   )
                   Text(text = "Ksh500",
                       fontSize = 15.sp,
                       color = Color.Black
                   )

                   Row {
                       Button(onClick = {  val simToolKitLaunchIntent =
                           mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                           simToolKitLaunchIntent?.let { mContext.startActivity(it) }
                       },
                           colors = ButtonDefaults.buttonColors(Color.Red),
                           shape = CutCornerShape(5.dp)
                       ) {
                           Icon(imageVector = Icons.Default.ShoppingCart ,
                               contentDescription = "",
                               tint = Color.White)

                           Text(text = "PAY", color = Color.White)
                       }
                   }

               }

               //3rd Column
               Spacer(modifier = Modifier.width(10.dp))

               Column {
                   Card(modifier = Modifier
                       .size(width = 150.dp, height = 200.dp)){
                       Box(modifier = Modifier.fillMaxSize(),
                           contentAlignment = Alignment.Center){
                           Image(painter = painterResource(id = R.drawable.grilledpork ),
                               contentDescription = "",
                               modifier = Modifier.fillMaxSize(),
                               contentScale = ContentScale.Crop)

                           Text(text = "Finger licking",
                               fontSize = 25.sp,
                               fontWeight = FontWeight.ExtraBold,
                               color = Color.White
                           )


                       }

                   }

                   Text(text = "Grilled Pork",
                       fontSize = 15.sp,
                       color = Color.Black
                   )
                   Text(text = "Ksh1500/kg",
                       fontSize = 15.sp,
                       color = Color.Black
                   )

                   Row {
                       Button(onClick = {  val simToolKitLaunchIntent =
                           mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                           simToolKitLaunchIntent?.let { mContext.startActivity(it) }
                       },
                           colors = ButtonDefaults.buttonColors(Color.Red),
                           shape = CutCornerShape(5.dp)
                       ) {
                           Icon(imageVector = Icons.Default.ShoppingCart ,
                               contentDescription = "",
                               tint = Color.White)

                           Text(text = "PAY", color = Color.White)
                       }


                   }

               }

           }
           Spacer(modifier = Modifier.height(2.dp))

           Text(text = "Leather watches",
               fontSize = 25.sp,
               color = Color.White,
               modifier = Modifier
                   .fillMaxWidth()
                   .background(Color.Red)
                   .height(50.dp),
               textAlign = TextAlign.Center,
               fontWeight = FontWeight.ExtraBold
           )

           Spacer(modifier = Modifier.height(20.dp))
           Row(modifier = Modifier
               .padding(start = 10.dp)
               .horizontalScroll(rememberScrollState())
           ) {
               Column {
                   Card(modifier = Modifier
                       .size(width = 150.dp, height = 200.dp)){
                       Box(modifier = Modifier.fillMaxSize(),
                           contentAlignment = Alignment.Center){
                           Image(painter = painterResource(id = R.drawable.watch1 ),
                               contentDescription = "",
                               modifier = Modifier.fillMaxSize(),
                               contentScale = ContentScale.Crop)

                       }

                   }

                   Text(text = "Watch",
                       fontSize = 15.sp,
                       color = Color.Black
                   )
                   Text(text = "Ksh5000",
                       fontSize = 15.sp,
                       color = Color.Black
                   )
                   Text(text = "make an order",
                       fontSize = 15.sp,
                       color = Color.Black
                   )

                   Row {
                       Button(onClick = { val callIntent=Intent(Intent.ACTION_DIAL)
                           callIntent.data="tel:0726139499".toUri()
                           mContext.startActivity(callIntent)
                       },
                           colors = ButtonDefaults.buttonColors(Color.Red),
                           shape = CutCornerShape(5.dp)
                       ) {
                           Icon(imageVector = Icons.Default.Call ,
                               contentDescription = "",
                               tint = Color.White)

                           Text(text = "Call", color = Color.White)
                       }
                   }

               }

               Spacer(modifier = Modifier.width(10.dp))

               //2nd Column
               Column {
                   Card(modifier = Modifier
                       .size(width = 150.dp, height = 200.dp)){
                       Box(modifier = Modifier.fillMaxSize(),
                           contentAlignment = Alignment.Center){
                           Image(painter = painterResource(id = R.drawable.w2 ),
                               contentDescription = "",
                               modifier = Modifier.fillMaxSize(),
                               contentScale = ContentScale.Crop)

                       }

                   }

                   Text(text = "Gold watch",
                       fontSize = 15.sp,
                       color = Color.Black
                   )
                   Text(text = "Ksh6000",
                       fontSize = 15.sp,
                       color = Color.Black
                   )

                   Row {
                       Button(onClick = {   val callIntent=Intent(Intent.ACTION_DIAL)
                           callIntent.data="tel:0726139499".toUri()
                           mContext.startActivity(callIntent)
                       },
                           colors = ButtonDefaults.buttonColors(Color.Red),
                           shape = CutCornerShape(5.dp)
                       ) {
                           Icon(imageVector = Icons.Default.Call ,
                               contentDescription = "",
                               tint = Color.White)

                           Text(text = "Call", color = Color.White)
                       }
                   }

               }

               //3rd Column
               Spacer(modifier = Modifier.width(10.dp))

               Column {
                   Card(modifier = Modifier
                       .size(width = 150.dp, height = 200.dp)){
                       Box(modifier = Modifier.fillMaxSize(),
                           contentAlignment = Alignment.Center){
                           Image(painter = painterResource(id = R.drawable.w3 ),
                               contentDescription = "",
                               modifier = Modifier.fillMaxSize(),
                               contentScale = ContentScale.Crop)

                       }

                   }
                   Text(text = "Camping watch",
                       fontSize = 15.sp,
                       color = Color.Black
                   )

                   Text(text = "Ksh5500",
                       fontSize = 15.sp,
                       color = Color.Black
                   )

                   Row {
                       Button(onClick = {   val callIntent=Intent(Intent.ACTION_DIAL)
                           callIntent.data="tel:0726139499".toUri()
                           mContext.startActivity(callIntent)
                       },
                           colors = ButtonDefaults.buttonColors(Color.Red),
                           shape = CutCornerShape(5.dp)
                       ) {
                           Icon(imageVector = Icons.Default.Call ,
                               contentDescription = "",
                               tint = Color.White)

                           Text(text = "Call", color = Color.White)
                       }


                   }

               }

           }
           Spacer(modifier = Modifier.height(2.dp))

           Text(text = "Mens store",
               fontSize = 25.sp,
               color = Color.White,
               modifier = Modifier
                   .fillMaxWidth()
                   .background(Color.Red)
                   .height(50.dp),
               textAlign = TextAlign.Center,
               fontWeight = FontWeight.ExtraBold
           )
           Spacer(modifier = Modifier.height(2.dp))
           Row(modifier = Modifier
               .padding(start = 10.dp)
               .horizontalScroll(rememberScrollState())
           ) {
               Column {
                   Card(modifier = Modifier
                       .size(width = 150.dp, height = 200.dp)){
                       Box(modifier = Modifier.fillMaxSize(),
                           contentAlignment = Alignment.Center){
                           Image(painter = painterResource(id = R.drawable.office ),
                               contentDescription = "",
                               modifier = Modifier.fillMaxSize(),
                               contentScale = ContentScale.Crop)

                       }

                   }

                   Text(text = "Mens office wear",
                       fontSize = 15.sp,
                       color = Color.Black
                   )
                   Text(text = "Ksh25000",
                       fontSize = 15.sp,
                       color = Color.Black
                   )
                   Text(text = "make an order",
                       fontSize = 15.sp,
                       color = Color.Black
                   )

                   Row {
                       Button(onClick = { val callIntent=Intent(Intent.ACTION_DIAL)
                           callIntent.data="tel:0726139499".toUri()
                           mContext.startActivity(callIntent)
                       },
                           colors = ButtonDefaults.buttonColors(Color.Red),
                           shape = CutCornerShape(5.dp)
                       ) {
                           Icon(imageVector = Icons.Default.Call ,
                               contentDescription = "",
                               tint = Color.White)

                           Text(text = "Call", color = Color.White)
                       }
                   }

               }

               Spacer(modifier = Modifier.width(10.dp))

               //2nd Column
               Column {
                   Card(modifier = Modifier
                       .size(width = 150.dp, height = 200.dp)){
                       Box(modifier = Modifier.fillMaxSize(),
                           contentAlignment = Alignment.Center){
                           Image(painter = painterResource(id = R.drawable.shirt ),
                               contentDescription = "",
                               modifier = Modifier.fillMaxSize(),
                               contentScale = ContentScale.Crop)

                       }

                   }

                   Text(text = "Official shirt",
                       fontSize = 15.sp,
                       color = Color.Black
                   )
                   Text(text = "Ksh2500",
                       fontSize = 15.sp,
                       color = Color.Black
                   )

                   Row {
                       Button(onClick = {   val callIntent=Intent(Intent.ACTION_DIAL)
                           callIntent.data="tel:0726139499".toUri()
                           mContext.startActivity(callIntent)
                       },
                           colors = ButtonDefaults.buttonColors(Color.Red),
                           shape = CutCornerShape(5.dp)
                       ) {
                           Icon(imageVector = Icons.Default.Call ,
                               contentDescription = "",
                               tint = Color.White)

                           Text(text = "Call", color = Color.White)
                       }
                   }

               }

               //3rd Column
               Spacer(modifier = Modifier.width(10.dp))

               Column {
                   Card(modifier = Modifier
                       .size(width = 150.dp, height = 200.dp)){
                       Box(modifier = Modifier.fillMaxSize(),
                           contentAlignment = Alignment.Center){
                           Image(painter = painterResource(id = R.drawable.smartc1 ),
                               contentDescription = "",
                               modifier = Modifier.fillMaxSize(),
                               contentScale = ContentScale.Crop)

                       }

                   }
                   Text(text = "Smart casual",
                       fontSize = 15.sp,
                       color = Color.Black
                   )

                   Text(text = "Ksh6500",
                       fontSize = 15.sp,
                       color = Color.Black
                   )

                   Row {
                       Button(onClick = {   val callIntent=Intent(Intent.ACTION_DIAL)
                           callIntent.data="tel:0726139499".toUri()
                           mContext.startActivity(callIntent)
                       },
                           colors = ButtonDefaults.buttonColors(Color.Red),
                           shape = CutCornerShape(5.dp)
                       ) {
                           Icon(imageVector = Icons.Default.Call ,
                               contentDescription = "",
                               tint = Color.White)

                           Text(text = "Call", color = Color.White)
                       }


                   }

               }

           }


       }




    }

}




@Preview(showBackground = true)
@Composable
fun productsPreview() {

    products()

}