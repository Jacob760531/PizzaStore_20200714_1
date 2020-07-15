package kr.co.tjoeun.pizzastore_20200714

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_view_pizza_store_detail.*
import kotlinx.android.synthetic.main.fragment_pizza_store_list.*
import kr.co.tjoeun.pizzastore_20200714.adapters.PizzaStoreAdapter
import kr.co.tjoeun.pizzastore_20200714.datas.PizzaStore


class ViewPizzaStoreDetailActivity : BaseActivity() {

    lateinit var mAdapter : PizzaStoreAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pizza_store_detail)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        callBtn.setOnClickListener {
            val permissionListener = object: PermissionListener{
                override fun onPermissionGranted() {
                    val phoneNum = tellNumTxt.text.toString()
                    val myUri = Uri.parse("tel:${phoneNum}")
                    val myIntent = Intent(Intent.ACTION_CALL,myUri)
                    startActivity(myIntent)
                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                    Toast.makeText(mContext,"통화할수 없다 권한을 니가 거부했는데 어쩌라고",Toast.LENGTH_SHORT).show()
                }

            }

            TedPermission.with(mContext).setPermissions(Manifest.permission.CALL_PHONE).setDeniedMessage("설정에서 권한설정해라").setPermissionListener(permissionListener).check()


        }


    }

    override fun setValues() {
        val receivedStore = intent.getSerializableExtra("Store") as PizzaStore

        storeNameTxt.text = receivedStore.name
        tellNumTxt.text = receivedStore.phoneNum
        Glide.with(mContext).load(receivedStore.logoUrl).into(storeLogo)



    }


}