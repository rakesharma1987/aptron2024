package com.example.ap_training_01.activity

import android.app.Dialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.ap_training_01.R
import com.example.ap_training_01.adapters.UserInfoListAdapter
import com.example.ap_training_01.databinding.ActivityUserInfoBinding
import com.example.ap_training_01.databinding.LayoutCreateUserBinding
import com.example.ap_training_01.databinding.LayoutUpdateUserBinding
import com.example.ap_training_01.factory.DbFactory
import com.example.ap_training_01.repository.DbRepository
import com.example.ap_training_01.viewModel.DbViewModel
import java.io.ByteArrayOutputStream

class UserInfoActivity : AppCompatActivity(), AdapterView.OnItemLongClickListener {
//    private lateinit var myDbAdapter: DbAdapter
    private lateinit var binding: ActivityUserInfoBinding
    private var clickedPosition: Int = 0
    lateinit var dbFactory: DbFactory
    lateinit var dbViewModel: DbViewModel
    lateinit var lBinding: LayoutCreateUserBinding
    lateinit var bitmapToBase64: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dbFactory = DbFactory(DbRepository(this))
        dbViewModel = ViewModelProvider(this, dbFactory)[DbViewModel::class.java]

//        myDbAdapter = DbAdapter(this)

        setupListItem()

        registerForContextMenu(binding.listUserInfo)

        binding.listUserInfo.setOnItemLongClickListener(this)
        

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflator = menuInflater
        menuInflator.inflate(R.menu.db_operation_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item_create ->{
                lBinding = LayoutCreateUserBinding.inflate(layoutInflater)
                val dialog = Dialog(this)
                dialog.setContentView(lBinding.root)
                dialog.setCancelable(false)
                dialog.show()

                lBinding.profileImage.setOnClickListener {
                    if (ContextCompat.checkSelfPermission(this@UserInfoActivity, android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                        startActivityForResult(intent, 1001)
                    }else{
                        ActivityCompat.requestPermissions(this@UserInfoActivity, arrayOf(android.Manifest.permission.CAMERA), 1001)
                    }
                }
                lBinding.btnSave.setOnClickListener {
                    dbViewModel.saveData(lBinding.etFname.text.toString(), lBinding.etLname.text.toString(), lBinding.etEmail.text.toString(), bitmapToBase64)
//                    myDbAdapter.saveData(lBinding.etFname.text.toString(), lBinding.etLname.text.toString(), lBinding.etEmail.text.toString())
                    dialog.dismiss()
                    setupListItem()
                }

            }
            
            R.id.item_clear_all ->{
//                myDbAdapter.deleteAll()
                setupListItem()

            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun setupListItem(){
//        val userList = myDbAdapter.getData()
        val userList = dbViewModel.getUserData()
        val userListAdapter = UserInfoListAdapter(userList)
        binding.listUserInfo.adapter = userListAdapter
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)

        val menuInfator = menuInflater
        menuInfator.inflate(R.menu.db_oepration_ctx_menu, menu)

    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item_update ->{
                val lBinding = LayoutUpdateUserBinding.inflate(layoutInflater)
                val dialog  = Dialog(this);
                dialog.setContentView(lBinding.root)
                dialog.setCancelable(false)
                dialog.show()

//                val userList = myDbAdapter.getData()
//                val user = userList[clickedPosition]
//                lBinding.etFname.setText(user.fName)
//                lBinding.etLname.setText(user.lName)
//                lBinding.etEmail.setText(user.email)
//
//                lBinding.btnUpdate.setOnClickListener {
//                    myDbAdapter.updateUser(user.id, lBinding.etFname.text.toString(), lBinding.etLname.text.toString(), lBinding.etEmail.text.toString())
//                    dialog.dismiss()
//                    setupListItem()
//                }

            }

            R.id.item_delete ->{
//                val userList = myDbAdapter.getData()
//                val user = userList[clickedPosition]
//                myDbAdapter.deleteUser(user.id)
//                setupListItem()
            }
        }
        return super.onContextItemSelected(item)
    }

    override fun onItemLongClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long): Boolean {
//        Log.d("Clicked Position: ", "$position")
        clickedPosition = position
        return false
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1001 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, 1001)
        }else{
            Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent)
        if (requestCode == 1001 && resultCode == RESULT_OK){
            val bitmap = intent!!.extras!!.get("data") as Bitmap
            lBinding.profileImage.setImageBitmap(bitmap)
            bitmapToBase64 = encodeImagetoBase64(bitmap)!!
            Log.d("BASE64", "onActivityResult: $bitmapToBase64")
        }else{
            Toast.makeText(this, "Something went wrong...", Toast.LENGTH_SHORT).show()
        }
    }

    private fun encodeImagetoBase64(bm: Bitmap): String? {
        val baos = ByteArrayOutputStream()
        bm.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val b = baos.toByteArray()
        return Base64.encodeToString(b, Base64.DEFAULT)
    }
}