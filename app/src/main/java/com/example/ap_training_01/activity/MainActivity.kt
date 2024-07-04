package com.example.ap_training_01.activity

import android.app.DatePickerDialog
import android.content.DialogInterface
import android.content.DialogInterface.OnClickListener
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.DatePicker
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.ap_training_01.R
import com.example.ap_training_01.databinding.ActivtyMainBinding
import java.util.Calendar

class MainActivity: AppCompatActivity(), View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    lateinit var calender: Calendar
    var dayOfMonth: Int = 0
    var month: Int = 0
    var year: Int = 0

    lateinit var binding: ActivtyMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivtyMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btn3.setOnClickListener(this)
        binding.btnShow.setOnClickListener(this)
        binding.btnDial.setOnClickListener(this)
        binding.btnCall.setOnClickListener(this)
        binding.btnCustomDialog.setOnClickListener(this)
        binding.rgGender.setOnCheckedChangeListener(this)
        binding.btnCustomDialog1.setOnClickListener(this)
        binding.ivDob.setOnClickListener(this)

        registerForContextMenu(binding.tilName)
        registerForContextMenu(binding.btnShow)

        calender = Calendar.getInstance()
        dayOfMonth = calender.get(Calendar.DAY_OF_MONTH)// current date
        month = calender.get(Calendar.MONTH) // current month
        year = calender.get(Calendar.YEAR) // current year

//        binding.tvDisplay.text = dayOfMonth.toString()+"/"+(month + 1).toString()+"/"+year.toString()


    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        val rbButtion = findViewById<RadioButton>(checkedId)
//        mGender = rbButtion.text.toString()
    }

    override fun onClick(v: View?) {
        val id = v!!.id
        if (id == R.id.btn_3) {
//        if ((etInput.text.toString().length < 10)){
//            Toast.makeText(this, "Mobile no must be 10 digit", Toast.LENGTH_SHORT).show()
//            return
//        }else {
//            tvDisplay.text = etInput.text.toString()
//        }

            val intent = Intent(this, SecondActivity::class.java)
//        intent.putExtra("name", etInput.text.toString())
//        intent.putExtra("gender", mGender)

//            val bundle = Bundle()
//            bundle.putString("name", etInput.editText!!.text.toString())
//            bundle.putString("gender", mGender)
//            bundle.putInt("age", etAge.text.toString().toInt())
//            intent.putExtras(bundle)
//            startActivity(intent)
        }

        if (id == R.id.btn_show){
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com/guide/components/intents-filters"))
            startActivity(intent)
        }

        if (id == R.id.btn_dial){
//            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${etMobile.text.toString()}"))
//            startActivity(intent)
        }

//        if (id == R.id.btn_call){
//
//            val popoUpmenu = PopupMenu(this, btnCall)
//            popoUpmenu.menuInflater.inflate(R.menu.menu_options, popoUpmenu.menu)
//            popoUpmenu.setOnMenuItemClickListener(object: PopupMenu.OnMenuItemClickListener{
//                override fun onMenuItemClick(item: MenuItem?): Boolean {
//                    val id = item!!.itemId
//                    if (id == R.id.item_select_group){
//                        Toast.makeText(this@MainActivity, item.title, Toast.LENGTH_SHORT).show()
//                    }else if (id == R.id.item_stard_message){
//                        Toast.makeText(this@MainActivity, item.title, Toast.LENGTH_SHORT).show()
//
//                    }else if (id == R.id.item_chat){
//                        Toast.makeText(this@MainActivity, item.title, Toast.LENGTH_SHORT).show()
//
//                    }else if (id == R.id.item_logout){
//                        Toast.makeText(this@MainActivity, item.title, Toast.LENGTH_SHORT).show()
//
//                    }else if (id == R.id.item_search){
//                        Toast.makeText(this@MainActivity, item.title, Toast.LENGTH_SHORT).show()
//
//                    }
//
//                    return true
//
//                }
//
//            })
//            popoUpmenu.show()
//
//
////            if (ContextCompat.checkSelfPermission(this@MainActivity, android.Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
////                val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:${etMobile.text.toString()}"))
////                startActivity(intent)
////            }else{
////                ActivityCompat.requestPermissions(this@MainActivity, arrayOf(android.Manifest.permission.CALL_PHONE), 1001)
////            }
//        }

//        if (id == R.id.btn_custom_dialog){
//            val customDialog = Dialog(this)
//            customDialog.setContentView(R.layout.layout_custom_dialog)
//            customDialog.setCancelable(false)
//            customDialog.show()
//            val etFname = customDialog.findViewById<EditText>(R.id.et_fname)
//            val etLname = customDialog.findViewById<EditText>(R.id.et_lname)
//            val btnSubmit = customDialog.findViewById<Button>(R.id.btn_submit)
//
//            btnSubmit.setOnClickListener(object: View.OnClickListener{
//                override fun onClick(v: View?) {
//                    val fName = etFname.text.toString()
//                    val lName = etLname.text.toString()
//                    tvDisplay.text = "$fName $lName"
//                    customDialog.dismiss()
//                }
//
//            })
//        }

        if (id == R.id.iv_dob){
            var datePicker = DatePickerDialog(this)
            datePicker.setOnDateSetListener(object: DatePickerDialog.OnDateSetListener{
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
//                    etInput.(dayOfMonth.toString()+"/"+(month + 1).toString()+"/"+year.toString())
                }

            })
            datePicker.show()
        }
    }

//    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if (requestCode == 1001 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
//            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:${etMobile.text.toString()}"))
//            startActivity(intent)
//        }else{
//            Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
//        }
//    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_options, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.item_select_group){
            Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
        }else if (id == R.id.item_stard_message){
            Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()

        }else if (id == R.id.item_chat){
            Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()

        }else if (id == R.id.item_logout){
            Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()

        }else if (id == R.id.item_search){
            Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()

        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu_options, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.item_select_group){
            Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()
        }else if (id == R.id.item_stard_message){
            Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()

        }else if (id == R.id.item_chat){
            Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()

        }else if (id == R.id.item_logout){
            Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()

        }else if (id == R.id.item_search){
            Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()

        }
        return super.onContextItemSelected(item)
    }

    override fun onBackPressed() {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setIcon(resources.getDrawable(R.drawable.ic_alert))
        alertDialog.setTitle("Exit")
        alertDialog.setMessage("Do you want to exit?")
        alertDialog.setCancelable(false)
        alertDialog.setPositiveButton("Yes", object: OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
//                super.onBackPressed()
                finish()
            }

        })

        alertDialog.setNegativeButton("No", object: OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {

            }

        })

        alertDialog.show()
    }

}