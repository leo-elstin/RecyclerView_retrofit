package `in`.yapp.recyclerviewexample

import `in`.yapp.recyclerviewexample.adapters.Adapter
import `in`.yapp.recyclerviewexample.models.User
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.azinova.phptesting.model.transData
import com.azinova.phptesting.utils.getApiService
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        val json = JsonObject()
        json.addProperty("","")

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

    private fun dataEngine(json: JsonObject) {


        getApiService().transllate(json).enqueue(object : Callback<transData> {
            override fun onResponse(call: Call<transData>, response: Response<transData>) {

                Log.e("Response", GsonBuilder().setPrettyPrinting().create().toJson(response.body()))


            }

            override fun onFailure(call: Call<transData>, t: Throwable) {

            }
        })
    }

}
