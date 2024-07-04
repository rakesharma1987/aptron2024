package com.example.ap_training_01.dataBase

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.ap_training_01.model.User


class DbAdapter(private val context: Context) {
    private val DBNAME = "_aptron"
    private val TABLE_NAME = "user"
    private val DB_VERSION = 1

    private val COL_SNO = "sno"
    private val COL_FNAME = "fname"
    private val COL_LNAME = "lname"
    private val COL_EMAIL = "email"

    val CREATETABLE = "CREATE TABLE $TABLE_NAME ($COL_SNO INTEGER PRIMARY KEY AUTOINCREMENT, $COL_FNAME TEXT, $COL_LNAME TEXT, $COL_EMAIL TEXT)"
    val dbHelper = MyDbHelper(context)
    val db = dbHelper.writableDatabase



    fun saveData(fName: String, lName: String, email: String){
       val contentValue = ContentValues()
        contentValue.put(COL_FNAME, fName)
        contentValue.put(COL_LNAME, lName)
        contentValue.put(COL_EMAIL, email)
        val id = db.insert(TABLE_NAME, null, contentValue)
        if (id > 0){
            Toast.makeText(context, "Successfully saved.", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context, "Something went wrong.", Toast.LENGTH_SHORT).show()
        }
    }


    fun getData(): ArrayList<User>{
        val userList = ArrayList<User>()
        val arra = arrayOf(COL_SNO, COL_FNAME, COL_LNAME, COL_EMAIL)
        val cursor = db.query(TABLE_NAME, arra, null, null, null, null, null)
        if (cursor.count > 0){
            cursor.moveToFirst()

            do{
                val srNo = cursor.getInt(0)
                val fName = cursor.getString(1)
                val lName = cursor.getString(2)
                val email = cursor.getString(3)
                userList.add(User(srNo, fName, lName, email))

            }while (cursor.moveToNext())
        }
        return userList

    }


    fun updateUser(id: Int, fName: String, lName: String, email: String){
        val contentValue = ContentValues()
        contentValue.put(COL_FNAME, fName)
        contentValue.put(COL_LNAME, lName)
        contentValue.put(COL_EMAIL, email)

        val id = db.update(TABLE_NAME, contentValue, "$COL_SNO = $id", null)
        if (id > 0){
            Toast.makeText(context, "Successfully updated.", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context, "Something went wrong.", Toast.LENGTH_SHORT).show()
        }

    }


    fun deleteUser(id: Int){
        val id = db.delete(TABLE_NAME, "$COL_SNO = $id", null)

        if (id > 0){
            Toast.makeText(context, "Successfully deleted.", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context, "Something went wrong.", Toast.LENGTH_SHORT).show()
        }
    }

    fun deleteAll(){
        val id = db.delete(TABLE_NAME, null, null)
        if (id > 0){
            Toast.makeText(context, "Successfully all data deleted.", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context, "Something went wrong.", Toast.LENGTH_SHORT).show()
        }
    }

    inner class MyDbHelper(context: Context): SQLiteOpenHelper(context, TABLE_NAME, null, DB_VERSION){
        override fun onCreate(db: SQLiteDatabase?) {
            db?.execSQL(CREATETABLE)

        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            TODO("Not yet implemented")
        }

    }
}