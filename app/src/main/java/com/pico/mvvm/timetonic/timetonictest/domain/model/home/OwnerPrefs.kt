package com.pico.mvvm.timetonic.timetonictest.domain.model.home

data class OwnerPrefs(
    val fpAutoExport: Boolean,
    val oCoverColor: String,
    val oCoverUseLastImg: Boolean,
    var oCoverImg: String,
    val oCoverType: String,
    val authorizeMemberBroadcast: Boolean,
    val acceptExternalMsg: Boolean,
    val title: String,
    val notifyMobileConfidential: Boolean
)