package kr.co.tjoeun.pizzastore_20200714

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_nickname_change.*

class NicknameChangeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nickname_change)

        setupEvents()
        setValues()
    }

    override fun setupEvents() {
//        ok버튼을 누르면 완료 처리 -> 데이터 들고 돌아가기
        okBtn.setOnClickListener {

//            입력한 닉네임을 받아야 들고 돌아감.
            val inputNickname = newNickNameEdt.text.toString()

//            결과첨부
            val resultIntent = Intent()

            resultIntent.putExtra("nickName",inputNickname)

            setResult(Activity.RESULT_OK,resultIntent)
            finish()
        }

    }

    override fun setValues() {

    }



}