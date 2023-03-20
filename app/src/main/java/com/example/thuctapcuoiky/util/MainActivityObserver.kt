package com.example.thuctapcuoiky.util
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class MainActivityObserver : LifecycleObserver {

    var data: String = "?"

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.d("MyObserver", "appear: $data")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.d("MyObserver", "disappear: $data")
    }
}
