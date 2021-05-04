package np.com.skybase.stsdkdemoapp

import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication


class MainApplication : MultiDexApplication() {
    override fun attachBaseContext(context: Context?) {
        super.attachBaseContext(context)
        MultiDex.install(this)
    }
}