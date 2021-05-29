package com.jectpack.aidl.client

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.jectpack.aidl.client.bean.AidlViewModel
import com.robert.jectpack.R
import com.robert.jectpack.databinding.ActivityAidlBinding
import com.robert.jectpack.databinding.ActivityAidlPoolsBinding

class AidlPoolsActivity : AppCompatActivity()/*, View.OnClickListener*/{

    private val TAG = AidlPoolsActivity::class.java.simpleName;

    private lateinit var binding : ActivityAidlPoolsBinding //此时binding值不能为null, 只是延迟初始化
//    private var binding : ActivityAidlBinding? = null; //此时允许binding为空， 需要可空类型定义

//    private var bookManager : IBookManager?= null; //此时允许binding为空， 需要可空类型定义






//    private val bookManagerConnection = object : ServiceConnection {
//        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
//            bookManager =  IBookManager.Stub.asInterface(service)
//
//        }
//
//        override fun onServiceDisconnected(name: ComponentName?) {
//            bookManager = null;
//        }
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //绑定方式一：通过xml的生成类直接绑定布局
//        binding = ActivityAidlBinding.inflate(layoutInflater)

        //绑定方式二：通过DataBindingUtil 和 xml 来绑定布局
        binding = DataBindingUtil.setContentView(this, R.layout.activity_aidl_pools)

        val viewModel : AidlViewModel = ViewModelProvider(this).get(AidlViewModel::class.java)
        viewModel.context = this
        binding.aidlViewModel = viewModel

    }

    override fun onDestroy() {
        super.onDestroy()
        BinderPoolsHelper.getInstance().onDestroy()
    }


//    override fun onClick(v: View) {
//        when(v.id){
////            R.id.btn_aidl_start_service -> {
////                startService()
////            };
//            R.id.btn_aidl_add_service -> {
//                thread {
//                    try {
//                        addBook(Book(bookIndex, "书名" + bookIndex.toString()));
//                        bookIndex++;
//                    }catch (e : java.lang.Exception){
//                        e.printStackTrace()
//                    }
//                }
//            };
//
//            R.id.btn_aidl_getlist_service -> {
//
//                thread { getList() }
//            };
//
//            R.id.btn_aidl_register_service -> {
//
//                thread { registerBookListener() }
//            };
//
//            R.id.btn_aidl_unregister_service -> {
//                thread { unRegisterBookListener() }
//            };
//
//            R.id.btn_aidl_start_pools_service -> {
//                thread {  getBookManager() }
//            };
//
//            R.id.btn_aidl_decrypt_service-> {
//                thread {  decrypt() }
//            };
//
//            R.id.btn_aidl_encrypt_service -> {
//                thread {  encrypt() }
//            };
//            else -> {
//                UIUtils.showTip(this, "没有任何按钮匹配响应 ！！！")
//            }
//        }
//    }



//    private fun startService() {
//
//        //bookManager
//        Intent(this, RemoteService::class.java).also { intent ->
//            bindService(intent, bookManagerConnection, Context.BIND_AUTO_CREATE)
//        }
//
//    }


}