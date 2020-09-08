package com.mobven.mmbkittester.permissionmanager

import android.Manifest
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mobven.mmbkittester.R
import com.mobven.mmbkittester.extension.showToast
import com.mobven.permissionmanager.PermissionManager
import kotlinx.android.synthetic.main.activity_permission_manager.*

class PermissionManagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission_manager)
        btnRequest.setOnClickListener {
            val permissionList = arrayListOf<String>()
            if (cbCamera.isChecked) {
                permissionList.add(Manifest.permission.CAMERA)
            }
            if (cbLocation.isChecked) {
                permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION)
            }
            if (cbContacts.isChecked) {
                permissionList.add(Manifest.permission.READ_CONTACTS)
            }
            if (cbMicrophone.isChecked) {
                permissionList.add(Manifest.permission.RECORD_AUDIO)
            }
            cbCamera.isChecked = false
            cbLocation.isChecked = false
            cbContacts.isChecked = false
            cbMicrophone.isChecked = false

            PermissionManager.requestPermission(
                this,
                permissionList.toTypedArray(),
                onShowRationaleListener = { permission ->
                    supportFragmentManager.beginTransaction()
                        .add(R.id.containerRationale, RationaleFragment.newInstance(permission))
                        .commit()
                },
                onDeniedListener = { permission ->
                    showToast("Denied $permission")
                },
                onGrantedListener = { permission ->
                    showToast("Granted $permission")
                })
        }
    }
}