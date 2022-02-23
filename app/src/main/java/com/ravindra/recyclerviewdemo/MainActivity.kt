package com.ravindra.recyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ravindra.recyclerviewdemo.response.user.ResultsItem
import com.ravindra.recyclerviewdemo.response.user.UserResponseNew
import retrofit2.Call
import retrofit2.Response
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName

    private lateinit var recyclerView: RecyclerView
    private var mApiService: APIService? = null

    private var mUserList: MutableList<ResultsItem> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        mApiService = RestClient.client.create(APIService::class.java)

        userListAPI()
    }

    private fun userListAPI() {
        val call = mApiService!!.fetchUser()

        call.enqueue(object : retrofit2.Callback<UserResponseNew?> {
            override fun onResponse(
                call: Call<UserResponseNew?>, response: Response<UserResponseNew?>) {

                val userResponse = response.body()!!
                Log.d(TAG, "data_size:: " + userResponse.results?.size)

                mUserList.addAll(userResponse.results!!)

                //RecyclerView
                recyclerView.layoutManager = LinearLayoutManager(
                    this@MainActivity,
                    RecyclerView.VERTICAL, false
                )
                val exampleAdapter = ExampleAdapter(mUserList)
                recyclerView.adapter = exampleAdapter


                //////////////////////////////////// Print record in log
                val responseBody = response.body()!!

                //Toast
                Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_SHORT).show()

                //Single record print
                Log.d(TAG, "email_1:: " + responseBody.results?.get(0)?.email)
                //Log.d(TAG, "title_1:: "+responseBody.results?.get(0)?.name?.title)

                //All record print using for loop
                for (myData in responseBody.results!!) {
                    //if (myData != null) {
                        Log.d(TAG, "email:: " + myData.email)
                    //}
                }
            }

            override fun onFailure(call: Call<UserResponseNew?>, t: Throwable) {
                //Toast
                Toast.makeText(this@MainActivity, "Fail", Toast.LENGTH_SHORT).show()
            }
        })
    }

}