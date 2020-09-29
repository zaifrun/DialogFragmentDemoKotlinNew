package org.pondar.dialogfragmentdemokotlinnew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun positiveClicked() {
            val toast = Toast.makeText(this,
                "positive button clicked", Toast.LENGTH_LONG)
            toast.show()
            dataText.text = "" //clearing the data
        }

    fun negativeClick() {
        //Here we override the method and can now do something
        val toast = Toast.makeText(this,
            "negative button clicked", Toast.LENGTH_SHORT)
        toast.show()
    }


    fun showDialog(v: View) {
        //showing our dialog.

        val dialog = MyDialogFragment(::positiveClicked,::negativeClick)
        //Here we show the dialog
        //The tag "MyFragement" is not important for us.
        dialog.show(supportFragmentManager,"myFragment")
    }
}