package com.nipuni.helloworld

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_notify_demo.*


class NotifyDemoActivity : AppCompatActivity() {
    private  var notificationManager:NotificationManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notify_demo)

        button2.setOnClickListener(){
            var intent =  Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE)as NotificationManager
        createNotificationChannel("com.nipuni.helloworld","NotifyDemo News","Example News Channel")
    }

    private fun createNotificationChannel(id: String, name :String, description: String) {
        val importance = NotificationManager.IMPORTANCE_LOW
        val channel = NotificationChannel(id,name,importance)

        channel.description = description
        channel.enableLights(true)
        channel.lightColor = Color.RED
        channel.enableVibration(true)
        channel.vibrationPattern = longArrayOf(100,200,300,400,500,400,300,200,400)
        notificationManager?.createNotificationChannel(channel)

    }


//    issue notification
   fun sendNotification(view: View){
    val notificationID = 101
    val channelID ="com .nipuni.helloworld"
    val notification = Notification.Builder(this@NotifyDemoActivity,channelID)
        .setContentText("Example Notification")
        .setContentText("This is an example notification")
        .setSmallIcon(android.R.drawable.ic_dialog_info)
        .setChannelId(channelID).build()

    notificationManager?.notify(notificationID,notification)



}





}
