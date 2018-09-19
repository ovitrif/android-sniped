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
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_app_bar.*

class MainActivity : BaseActivity(), IMain.View {

    private lateinit var presenter: IMain.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)

        val component = DaggerMainComponent.builder()
                .appComponent(App.getAppComponent(this))
                .mainModule(MainModule(this, this))
                .navigatorModule(NavigatorModule(this))
                .build()
        presenter = component.presenter()

        initView()
    }

    override fun onResume() {
        super.onResume()
        presenter.onShow()
    }

    override fun onStop() {
        super.onStop()
        presenter.onHide()
    }

    override fun onBackPressed() {
        moveTaskToBack(true)
    }

    @OnClick(R.id.detailNavBtn)
    fun onDetailNavBtnClick() = presenter.onDetailNavBtnClick()

    override fun setDetailBtnBgColor(color: Int) = with(detailNavBtn) { setBackgroundColor(color) }

    private fun initView() {
        setSupportActionBar(toolbar)
        supportActionBar?.setTitle(R.string.main_title)
    }
}
