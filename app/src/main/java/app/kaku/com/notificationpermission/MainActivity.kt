package app.kaku.com.notificationpermission

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.NotificationManagerCompat
import android.net.Uri.fromParts
import android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS
import android.support.v4.view.accessibility.AccessibilityEventCompat.setAction
import android.content.Intent
import android.net.Uri
import android.provider.Settings


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val manager = NotificationManagerCompat.from(this)
        val isOpened = manager.areNotificationsEnabled()

        if(!isOpened){
            // 根据isOpened结果，判断是否需要提醒用户跳转AppInfo页面，去打开App通知权限
            val intent = Intent()
            intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
            val uri = Uri.fromParts("package", this.getPackageName(), null)
            intent.data = uri
            startActivity(intent)
        }

    }
}
