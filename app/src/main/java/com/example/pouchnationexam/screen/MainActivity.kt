package com.example.pouchnationexam.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pouchnationexam.R
import com.example.pouchnationexam.databinding.ActivityMainBinding
import com.example.pouchnationexam.framework.rx.RxSchedulerUtils
import com.example.pouchnationexam.usecase.api.Events
import com.example.pouchnationexam.usecase.api.Events.*
import com.example.pouchnationexam.usecase.api.Token
import com.example.pouchnationexam.usecase.event.EventsLoader
import dagger.android.AndroidInjection
import io.reactivex.Scheduler
import io.reactivex.SingleObserver
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var loader : EventsLoader

    @Inject
    lateinit var scheduler : RxSchedulerUtils

    private lateinit var adapter: TicketAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = setContentView(this, R.layout.activity_main)

        loader.get()
            .observeOn(AndroidSchedulers.mainThread())
            .compose(scheduler.forSingle())
            .subscribe(object : SingleObserver<Events> {
                override fun onSuccess(events: Events) {
                    binding.event = events
                    setupAdapter(events.ticketTypes)
                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {

                }

            })

    }

    private fun setupAdapter(types: List<TicketType>) {
        binding.ticketTypesRecycler.layoutManager =  LinearLayoutManager(this)
        val dividerItemDecoration = DividerItemDecoration(
            binding.ticketTypesRecycler.context,
            (binding.ticketTypesRecycler.layoutManager as LinearLayoutManager).orientation
        )
        binding.ticketTypesRecycler.addItemDecoration(dividerItemDecoration)
        adapter = TicketAdapter(types)
        binding.ticketTypesRecycler.adapter = adapter
    }
}