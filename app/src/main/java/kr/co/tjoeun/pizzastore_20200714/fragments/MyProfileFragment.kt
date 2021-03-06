package kr.co.tjoeun.pizzastore_20200714.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.service.voice.VoiceInteractionSession
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_my_profile.*
import kr.co.tjoeun.pizzastore_20200714.NicknameChangeActivity
import kr.co.tjoeun.pizzastore_20200714.R

class MyProfileFragment : Fragment() {

    //    닉네임을 가지러 간다고 명시하는 숫자를 담은 변수
    val REQ_FOR_NEW_NICKNAME = 2003

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_profile, container, false)
    }

    //    프래그먼트의 동작 처리 담당 함수
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        changeNickNameBtn.setOnClickListener {

            val myIntent = Intent(activity, NicknameChangeActivity::class.java)

            startActivityForResult(myIntent, REQ_FOR_NEW_NICKNAME)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQ_FOR_NEW_NICKNAME)        {
            if (resultCode == Activity.RESULT_OK) {
                val newNickName = data?.getStringExtra("nickName")
                nickNameTxt.text = newNickName
            }
        }
    }

}