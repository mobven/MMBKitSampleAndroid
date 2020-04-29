package com.mobven.mmbkittester.uicomponents

import com.mobven.mmbkittester.R
import com.mobven.uicomponents.dashboard.DashboardAdapter

class CustomDashboardAdapter : DashboardAdapter() {

    override fun getListLayoutId(): Int = R.layout.item_list

    override fun getGridLayoutId(): Int = R.layout.item_grid

    override fun getItemCount(): Int = 5
}