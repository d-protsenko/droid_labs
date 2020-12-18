package excy.droid

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import android.view.MenuItem;
import android.view.Menu;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;

import java.util.*


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private var list: ListView? = null
    private lateinit var array: Array<String>
    private var adapter: ArrayAdapter<String?>? = null
    private var toolbar: Toolbar? = null
    private var categoryIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        list = findViewById(R.id.id_ListView)
        array = resources.getStringArray(R.array.Games)
        adapter = ArrayAdapter<String?>(this,
            android.R.layout.simple_list_item_1,
            array
        )
        list?.adapter = adapter
        toolbar = findViewById(R.id.toolbar)
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(this, drawer, toolbar, 0, 0)
        drawer.addDrawerListener(toggle)
        toggle.syncState()
        navigationView.setNavigationItemSelectedListener(this)
        list?.onItemClickListener = OnItemClickListener { parent, view, position, id ->
            val intent = Intent(this@MainActivity, TextContentActivity::class.java)
            intent.putExtra("category", categoryIndex)
            intent.putExtra("position", position)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        toolbar?.setTitle(R.string.menu_games)
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id: Int = item.getItemId()
        if (id == R.id.id_games_list) {
            toolbar?.setTitle(R.string.menu_games)
            array = resources.getStringArray(R.array.Games)
            adapter!!.clear()
            adapter!!.addAll(*array)
            adapter!!.notifyDataSetChanged()
            categoryIndex = 0
        } else if (id == R.id.dev_item_id) {
            toolbar?.setTitle(R.string.menu_different)
            adapter!!.clear()
            categoryIndex = 1
            val intent = Intent(this@MainActivity, TextContentActivity::class.java)
            intent.putExtra("category", categoryIndex)
            startActivity(intent)
        }
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}