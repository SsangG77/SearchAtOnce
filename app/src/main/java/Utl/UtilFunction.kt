package Utl

import android.app.Activity
import android.widget.Toast

class UtilFunction {
    constructor()
    fun toast(activity : Activity, msg : String) {
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()
    }

}