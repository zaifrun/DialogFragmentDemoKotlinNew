package org.pondar.dialogfragmentdemokotlinnew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.pondar.dialogfragmentdemokotlinnew.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }


    //callback function from yes/no dialog - for yes choice
    private fun positiveClicked() {
        val toast = Toast.makeText(
            this,
            "positive button clicked", Toast.LENGTH_LONG
        )
        toast.show()
        binding.dataText.text = "" //clearing the data
    }


    //callback function from yes/no dialog - for no choice
    private fun negativeClick() {
        //Here we override the method and can now do something
        val toast = Toast.makeText(
            this,
            "negative button clicked", Toast.LENGTH_LONG
        )
        toast.show()
    }


    fun showDialog(v: View) {
        //showing our dialog.

        val dialog = MyDialogFragment(::positiveClicked, ::negativeClick)
        //Here we show the dialog
        //The tag "MyFragement" is not important for us.
        dialog.show(supportFragmentManager, "myFragment")
    }

    fun showCustomDialog(v: View) {
        val dialog = AddRangeDialog(::addRemoveRange)
        dialog.show(supportFragmentManager, "addrangedialogfragment")
    }


    //Callback function from add/remove dialog
    private fun addRemoveRange(start: Int, end: Int, add: Boolean) {
        var modify = "remove"
        if (add)
            modify = "add"

        val toast = Toast.makeText(
            this,
            "You choose to $modify records starting from $start and ending at $end",
            Toast.LENGTH_LONG
        )
        toast.show()
        //Change data
        //update UI
    }
}