package com.sniped.ui.main

import android.os.Bundle
import butterknife.ButterKnife
import butterknife.OnClick
import com.sniped.App
import com.sniped.R
import com.sniped.ui.BaseActivity
import com.sniped.ui.main.di.DaggerMainComponent
import com.sniped.ui.main.di.MainModule
import com.sniped.ui.navigator.NavigatorModule
import kotlinx.android.synthetic.main.view_app_bar.*

class MainActivity : BaseActivity(), IMain.View {

    private lateinit var presenter: IMain.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        val component = DaggerMainComponent.builder()
                .appComponent(App.getAppComponent(this))
                .mainModule(MainModule(this))
                .navigatorModule(NavigatorModule(this))
                .build()
        presenter = component.presenter()

        initView()
        presenter.onShow()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onHide()
    }

    override fun onBackPressed() {
        moveTaskToBack(true)
    }

    @OnClick(R.id.detailNavBtn)
    fun onDetailButtonClick() = presenter.onDetailButtonClick()

    private fun initView() {
        setSupportActionBar(toolbar)
        supportActionBar?.setTitle(R.string.main_title)
    }
}
