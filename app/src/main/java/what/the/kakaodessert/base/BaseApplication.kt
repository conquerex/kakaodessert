package what.the.kakaodessert.base

import android.app.Activity
import android.app.Application
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatDialog
import  what.the.kakaodessert.R

class BaseApplication : Application() {

    private lateinit var progressDialog: AppCompatDialog

    init {
        instance = this
    }

    companion object {
        private lateinit var instance: BaseApplication
        fun getInstance(): BaseApplication {
            return instance
        }
    }

    // 로딩 화면 띄우기
    fun progressON(activity: Activity?) {
        if (activity == null || activity.isFinishing) {
            return
        }

        progressDialog = AppCompatDialog(activity)
        progressDialog.setCancelable(false)
        progressDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        progressDialog.setContentView(R.layout.dialog_progress)
        progressDialog.show()
    }

    // 로딩 화면 숨기기
    fun progressOFF() {
        if (progressDialog.isShowing) {
            progressDialog.dismiss()
        }
    }
}