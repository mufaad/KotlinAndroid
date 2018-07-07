package site.msolutions.msgshareapp.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.recyclerandcardviews.*
import site.msolutions.msgshareapp.adapters.HobbiesAdapter
import site.msolutions.msgshareapp.models.Hobby
import site.msolutions.msgshareapp.R

class RecyclerAndCardViews : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recyclerandcardviews)

        setupRecyclerView()

    }

    private fun setupRecyclerView() {

        val layoutmanager = LinearLayoutManager(this)
        layoutmanager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutmanager
        val adapter = HobbiesAdapter(this, Hobby.Supplier.hobbies)
        recyclerView.adapter = adapter

    }

}