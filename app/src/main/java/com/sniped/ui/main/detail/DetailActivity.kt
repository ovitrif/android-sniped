package com.sniped.ui.main.detail

import android.os.Bundle
import butterknife.ButterKnife
import butterknife.OnClick
import com.sniped.App
import com.sniped.R
import com.sniped.extensions.showKeyboard
import com.sniped.ui.BaseActivity
import com.sniped.ui.main.detail.di.DaggerDetailComponent
import com.sniped.ui.main.detail.di.DetailModule
import com.sniped.ui.navigator.NavigatorModule
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.view_app_bar.*

class DetailActivity : BaseActivity(), IDetail.View {

    private lateinit var presenter: IDetail.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        ButterKnife.bind(this)

        val component = DaggerDetailComponent.builder()
                .appComponent(App.getAppComponent(this))
                .detailModule(DetailModule(this))
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

    override fun onBackPressed() = presenter.onBackPressed()

    @OnClick(R.id.getBtn)
    fun onGetButtonClick() = presenter.onGetButtonClick()

    override val userName get() = userNameFieldView.text.toString()

    override var dataText
        get() = dataTextView.text.toString()
        set(value) = with(dataTextView) { text = value }

    override fun setInputError(errorMessage: Int) = with(userNameLayoutView) { error = getString(errorMessage) }

    override fun clearInputError() = with(userNameLayoutView) { error = null }

    private fun initView() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setTitle(R.string.detail_title)

        userNameFieldView.showKeyboard()
    }
}
