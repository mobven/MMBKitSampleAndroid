package com.mobven.mmbkittester.uicomponents

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobven.mmbkittester.R
import com.mobven.uicomponents.toolbar.ExpandableToolbar

class ToolbarActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar)

        val expandedLayout = layoutInflater.inflate(R.layout.layout_expanded, null, false)
        val collapsedLayout = layoutInflater.inflate(R.layout.layout_collapse, null, false)

        findViewById<ExpandableToolbar>(R.id.expanded_toolbar).apply {
            addExpandedLayout(expandedLayout)
            addCollapsedLayout(collapsedLayout)
        }
    }

}