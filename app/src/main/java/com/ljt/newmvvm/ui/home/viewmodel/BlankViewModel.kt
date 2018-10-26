package com.ljt.newmvvm.ui.home.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class BlankViewModel : ViewModel() {

    var textOne = MutableLiveData<String>()
    var imgUrl = MutableLiveData<String>()

    init {
        imgUrl.value = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1540558161553&di=280b443820e39ee7f7be3c" +
                "4a407aa397&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201409%2F17%2F20140917174823_hTshV.thumb.700_0.png"
    }

}