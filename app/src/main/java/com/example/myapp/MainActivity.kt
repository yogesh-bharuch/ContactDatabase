package com.example.myapp

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapp.ui.theme.MyAppTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Date

class MainActivity : ComponentActivity() {
   lateinit var database: ContactDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database= ContactDatabase.getDatabase(this)
        val database2 = ContactDatabase.getDatabase(this)

        GlobalScope.launch {

            //database.contactDao().updateContact(Contact(1, "Yogesh Vyas","9724911768", Date()))
            //database.contactDao().updateContact(Contact(2, "Bela","9998003359",Date()))
            database.contactDao().deleteContact(Contact(5, "Bela","9998003359",Date(),1))
            database.contactDao().insertContact(Contact(0, "Deep","+198979678",Date(), 1))
        }
    }
    fun getData(view: View){
        database.contactDao().getContact().observe(this, Observer {
            Log.d("myTag",it.toString())
        })
    }
}
