package excy.droid

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var textView: TextView? = null
    private var log: String = "Logs:\n"
    override fun onCreate(savedInstanceState: Bundle?) {
        val startTime = System.currentTimeMillis()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this, "Called onCreate()", Toast.LENGTH_SHORT).show()
        val endTime = System.currentTimeMillis()
        textView = findViewById(R.id.textView)
        val message = "onCreate took " + (endTime - startTime) + " milliseconds\n"
        log += message
        textView?.text = log
        println(message)
    }

    override fun onStart() {
        val startTime = System.currentTimeMillis()
        super.onStart()
        Toast.makeText(this, "Called onStart()", Toast.LENGTH_SHORT).show()
        val endTime = System.currentTimeMillis()
        val message = "onStart took " + (endTime - startTime) + " milliseconds\n"
        log += message
        textView?.text = log
        println(message)
    }

    override fun onPause() {
        val startTime = System.currentTimeMillis()
        Toast.makeText(this, "Called onPause()", Toast.LENGTH_SHORT).show()
        super.onPause()
        val endTime = System.currentTimeMillis()
        val message = "onPause took " + (endTime - startTime) + " milliseconds\n"
        log += message
        textView?.text = log
        println(message)
    }

    override fun onResume() {
        val startTime = System.currentTimeMillis()
        super.onResume()
        Toast.makeText(this, "Called onResume()", Toast.LENGTH_SHORT).show()
        val endTime = System.currentTimeMillis()
        val message = "onResume took " + (endTime - startTime) + " milliseconds\n"
        log += message
        textView?.text = log
        println(message)
    }

    override fun onStop() {
        val startTime = System.currentTimeMillis()
        Toast.makeText(this, "Called onStop()", Toast.LENGTH_SHORT).show()
        super.onStop()
        val endTime = System.currentTimeMillis()
        val message = "onStop took " + (endTime - startTime) + " milliseconds\n"
        log += message
        textView?.text = log
        println(message)
    }

    override fun onDestroy() {
        val startTime = System.currentTimeMillis()
        Toast.makeText(this, "Called onDestroy()", Toast.LENGTH_SHORT).show()
        super.onDestroy()
        val endTime = System.currentTimeMillis()
        val message = "onDestroy took " + (endTime - startTime) + " milliseconds\n"
        log += message
        textView?.text = log
        println(message)
    }
}