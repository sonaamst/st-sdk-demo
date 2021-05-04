package np.com.skybase.stsdkdemoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.sastotickets.activities.SplashActivity
import com.sastotickets.main.SastoTicketsSDK

class MainActivity : AppCompatActivity() {

    //IMP THINGS
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.button).setOnClickListener {
            val intent = Intent(this, SplashActivity::class.java)
            intent.putExtra(SastoTicketsSDK.USERNAME,"XXXXXX")
            intent.putExtra(SastoTicketsSDK.PASSWORD,"XXXXXX")
            startActivityForResult(intent,
                SastoTicketsSDK.RC_INIT
            )
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SastoTicketsSDK.RC_INIT) {
            if (resultCode == RESULT_OK) {
                println("SDK:: RESPONSE OK!")
                println("SDK:: ${data?.extras.toString()}")
            } else {
                println("SDK:: CANCEL!")
            }
        }
    }
}