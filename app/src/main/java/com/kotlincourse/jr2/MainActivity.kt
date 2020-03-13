package com.kotlincourse.jr2

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlincourse.jr2.Common.Common
import com.kotlincourse.jr2.Interface.RetrofitService
import com.kotlincourse.jr2.Model.Photos
import com.kotlincourse.jr2.PhotoAdapter.PhotoAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var mService : RetrofitService
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adpater: PhotoAdapter
    lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService = Common.retrofitService
        recyclerviewphotos.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerviewphotos.layoutManager = layoutManager

       //dialog = SpotsDialog.Builder().setCancelable(false).setContext(this).build()


        getAllPhotosList()
    }

    private fun getAllPhotosList() {

        //dialog.show()

        mService.getPhotos().enqueue(object : Callback<List<Photos>>{
            override fun onFailure(call: Call<List<Photos>>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<Photos>>, response: Response<List<Photos>>) {
                adpater = PhotoAdapter(baseContext, response.body() as MutableList<Photos>)
                adpater.notifyDataSetChanged()
                recyclerviewphotos.adapter = adpater

               // dialog.dismiss()
            }


        })
    }
}
