package com.example.managers

import android.content.Intent
import android.media.audiofx.BassBoost
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import com.example.managers.ui.theme.ManagersTheme

class IntentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            myintent()

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myintent(){
    val mContext= LocalContext.current
    Column(modifier = Modifier
        .fillMaxSize()
        .paint(painterResource(id = R.drawable.backg),
            contentScale = ContentScale.FillBounds)
    )
    {



        Spacer(modifier = Modifier.height(10.dp))

        //MPESA STK
        Box (modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center){
            Button(onClick = {
                val simToolKitLaunchIntent =
                    mContext.packageManager.getLaunchIntentForPackage("com.android.stk")
                simToolKitLaunchIntent?.let { mContext.startActivity(it)
                }

            },
                colors = ButtonDefaults.buttonColors(Color.Red),
                shape = CutCornerShape(5.dp)
            ) {
                Text(text = "MPESA", color = Color.White)

            }

        }


        Spacer(modifier = Modifier.height(10.dp))

        //EMAIL
        Box (modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center){
            Button(onClick = {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("gichirijoseph73@gmail.com"))
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "national park tour")
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello,kindly share the tour ....")
                mContext.startActivity(shareIntent)
            },
                colors = ButtonDefaults.buttonColors(Color.Red),
                shape = CutCornerShape(5.dp)
            ) {
                Text(text = "EMAIL", color = Color.White)

            }

        }
        Spacer(modifier = Modifier.height(10.dp))

        //SHARE
        Box (modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center){
            Button(onClick = {
                val shareIntent=Intent(Intent.ACTION_SEND)
                shareIntent.type="text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out this is a cool content")
                mContext.startActivity(Intent.createChooser(shareIntent, "Share"))
            },
                colors = ButtonDefaults.buttonColors(Color.Red),
                shape = CutCornerShape(5.dp)
            ) {
                Text(text = "SHARE", color = Color.White)

            }

        }
        Spacer(modifier = Modifier.height(10.dp))

        //CALL
        Box (modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center){
            Button(onClick = {
                val callIntent=Intent(Intent.ACTION_DIAL)
                callIntent.data="tel:0726139499".toUri()
                mContext.startActivity(callIntent)
                Toast.makeText(mContext,"Go to phone calls",Toast.LENGTH_LONG).show()
            },
                colors = ButtonDefaults.buttonColors(Color.Red),
                shape = CutCornerShape(5.dp)
            ) {
                Text(text = "CALL", color = Color.White)


            }

        }
        Spacer(modifier = Modifier.height(10.dp))

        //SMS
        Box (modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center){
            Button(onClick = {
                val smsIntent=Intent(Intent.ACTION_SENDTO)
                smsIntent.data="smsto:0726139499".toUri()
                smsIntent.putExtra("sms_body","Hello 254Ride,how was your day?")
                mContext.startActivity(smsIntent)
            },
                colors = ButtonDefaults.buttonColors(Color.Red),
                shape = CutCornerShape(5.dp)
            ) {
                Text(text = "SMS", color = Color.White)

            }

        }
        Spacer(modifier = Modifier.height(10.dp))

        //SETTINGS
        Box (modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center){
            Button(onClick = {
                val settingsIntent=Intent(Settings.ACTION_SETTINGS)
                mContext.startActivity(settingsIntent)
            },
                colors = ButtonDefaults.buttonColors(Color.Red),
                shape = CutCornerShape(5.dp)
            ) {
                Text(text = "SETTINGS", color = Color.White)

            }

        }
        Spacer(modifier = Modifier.height(10.dp))

        //CAMERA
        Box (modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center){
            Button(onClick = {
                val cameraIntent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                if (cameraIntent.resolveActivity(mContext.packageManager)!=null){
                    mContext.startActivity(cameraIntent)
                }else{
                    println("Camera app is not available")
                }
            },
                colors = ButtonDefaults.buttonColors(Color.Red),
                shape = CutCornerShape(5.dp)
            ) {
                Text(text = "CAMERA", color = Color.White)

            }



        }
        val context = LocalContext.current

        Button(onClick = { context.startActivity(Intent(context,PdfActivity2::class.java)) },
            colors = ButtonDefaults.buttonColors(Color.Red),
            shape = CutCornerShape(5.dp)
        ) {
            Text(text = "NEXT", color = Color.White)
            Icon(imageVector = Icons.Default.ArrowForward,
                contentDescription = "",
                tint = Color.Black)

        }
    }



}




@Preview(showBackground = true)
@Composable
fun myintentpreview(){
    myintent()

}
