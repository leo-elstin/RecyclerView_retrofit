package `in`.yapp.recyclerviewexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    lateinit var userList : ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        userList = ArrayList()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter(userList,this)

        addDummyData()
    }

    private fun addDummyData() {

        val user0 = User("Leo Elstin", "Kaniyakumari,TN")
        userList.add(user0)
        val user1 = User("Bat Man", "Gotham")
        userList.add(user1)
        val user2 = User("Iorn Man", "New York")
        userList.add(user2)
        val user3 = User("Thor", "Parallel universe")
        userList.add(user3)
        val user4 = User("Loki", "Alien Planet")
        userList.add(user4)

        recyclerView.adapter.notifyDataSetChanged()
    }

}
