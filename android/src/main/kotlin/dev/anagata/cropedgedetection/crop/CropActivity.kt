package dev.anagata.cropedgedetection.crop

import android.app.Activity
import android.content.Intent
import android.widget.ImageView
import dev.anagata.cropedgedetection.R
import dev.anagata.cropedgedetection.base.BaseActivity
import dev.anagata.cropedgedetection.view.PaperRectangle
import kotlinx.android.synthetic.main.activity_crop.*
import android.view.MenuItem
import android.view.Menu
import dev.anagata.cropedgedetection.SCANNED_RESULT


class CropActivity : BaseActivity(), ICropView.Proxy {

    private lateinit var mPresenter: CropPresenter

    override fun prepare() {
    }

    override fun provideContentViewId(): Int = R.layout.activity_crop


    override fun initPresenter() {
        mPresenter = CropPresenter(this, this)
        mPresenter.crop()
    }

    override fun getPaper(): ImageView = paper

    override fun getPaperRect(): PaperRectangle = paper_rect

    override fun getCroppedPaper(): ImageView = picture_cropped

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.crop_activity_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // handle button activities
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == android.R.id.home){
            onBackPressed()
            return true
        }

        if (item.itemId == R.id.action_label) {
            if(item.title == applicationContext.getString(R.string.next)){
                // item.title = "Done"
                item.title = "Save"
                mPresenter.crop()
                return true
            }
            if(item.title == applicationContext.getString(R.string.save)){
                var path = mPresenter.save()
                setResult(Activity.RESULT_OK, Intent().putExtra(SCANNED_RESULT, path))
                System.gc()
                finish()
            return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
}