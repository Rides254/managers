package com.example.managers

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.managers.ui.theme.ManagersTheme

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            form()

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun form(){
    Column (modifier = Modifier.fillMaxSize()){
        TopAppBar(title = { Text(text = "Create an Account", color = Color.White) },
            colors = TopAppBarDefaults.mediumTopAppBarColors(Color.Red),
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Menu,
                        contentDescription ="" ,
                        tint = Color.White)

                }



            },


        )
        Spacer(modifier = Modifier.height(10.dp))
        Box(modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.registar))
            val progress by animateLottieCompositionAsState(composition)
            LottieAnimation(composition, progress,
                modifier = Modifier.size(300.dp)
            )
        }
        Spacer(modifier = Modifier.height(5.dp))

        Text(text = "ShopEasy",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = Color.Black,
            fontSize = 25.sp,
            fontWeight = FontWeight.ExtraBold
            )
        Spacer(modifier = Modifier.height(10.dp))

       var fname by remember { mutableStateOf("") }
       var lname by remember { mutableStateOf("") }
       var email by remember { mutableStateOf("") }
       var password by remember { mutableStateOf("") }
       var contact by remember { mutableStateOf("") }

        TextField(value =fname,
            onValueChange = {fname = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            placeholder = { Text(text = "Enter Your Firstname")},
            leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)

            )
        Spacer(modifier = Modifier.height(10.dp))

        TextField(value =lname,
            onValueChange = {lname = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            placeholder = { Text(text = "Enter Your lastname")},
            leadingIcon = { Icon(imageVector = Icons.Default.Face, contentDescription = "")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)

        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(value =email,
            onValueChange = {email = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            placeholder = { Text(text = "Enter Your Email")},
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)

        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(value =password,
            onValueChange = {password = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            placeholder = { Text(text = "Type Your password...")},
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation()

        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(value =contact,
            onValueChange = {contact = it},
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            placeholder = { Text(text = "Enter phone number")},
            leadingIcon = { Icon(imageVector = Icons.Default.Call, contentDescription = "")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)

        )
        Spacer(modifier = Modifier.height(10.dp))
        Row() {

            Spacer(modifier = Modifier.width(50.dp))
            Button(onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.Red),
                shape = CutCornerShape(5.dp)
            ) {

                Text(text = "SIGN UP", color = Color.White)
            }
            Spacer(modifier = Modifier.width(50.dp))

            Button(onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color.Red),
                shape = CutCornerShape(5.dp)
            ) {

                Text(text = "REGISTER", color = Color.White)
            }

        }
        Spacer(modifier = Modifier.width(50.dp))
        val context = LocalContext.current

        Button(onClick = { context.startActivity(Intent(context,IntentActivity::class.java)) },
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
fun formPreview(){
    form()
}