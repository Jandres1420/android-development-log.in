package com.pico.mvvm.timetonic.timetonictest.domain.model.home

data class UserPrefs(
    val maxMsgsOffline: Int,
    val syncWithHubic: Boolean,
    val uCoverLetOwnerDecide: Boolean,
    val uCoverColor: String,
    val uCoverUseLastImg: Boolean,
    val uCoverImg: String,
    val uCoverType: String,
    val inGlobalSearch: Boolean,
    val inGlobalTasks: Boolean,
    val notifyEmailCopy: Boolean,
    val notifySmsCopy: Boolean,
    val notifyMobile: Boolean,
    val notifyWhenMsgInArchivedBook: Boolean
)