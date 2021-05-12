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
            intent.putExtra(SastoTicketsSDK.USERNAME,"XXX")
            intent.putExtra(SastoTicketsSDK.PASSWORD,"XXX")
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
                val bookingReferenceId = data?.extras?.get("bookingReferenceId")
                println("bookingReferenceId:: $bookingReferenceId")

                //use bookingReferenceId to get details when necessary
            } else {
                println("SDK:: CANCEL!")
            }
        }
    }
}