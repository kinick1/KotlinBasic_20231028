package kr.ac.wku.kotlinbasic_20231028

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import kr.ac.wku.kotlinbasic_20231028.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.btnLog.setOnClickListener {
//        로그 버튼이 클릭되면 실행괼 코드 스코프

//        로그 찍어보기
            Log.d("메인화면", "로그 버튼 클릭됨")  //디버그 로그 출력
            Log.e("메인화면","e로 로그 찍어보기") //에러 로그 출력
            Log.wtf("메인화면","wtf로 로그 찍어보기") //일종의 에러 로그
        }

        binding.btnToast.setOnClickListener {
//            토스트 버튼이 클릭되면=> 토스트 띄우기

            Toast.makeText(this, "toast 클릭됨", Toast.LENGTH_SHORT).show()
        }

        binding.btnVariable.setOnClickListener {
            //코틀린 변수 문법 연습

            // 내 이름을 저장할 변수 (String) 생성 => 변동 가능성이 있다

            var myName: String

            //  내 이름을 저장하기

            myName="조철왕"

            //이름 변경 => 조철뚝

            myName ="조철뚝"
            Toast.makeText(this, myName, Toast.LENGTH_SHORT).show()

            val motherName:String
            motherName="어머니"

            //어머니 이름 변경 시도
            // motherName="어머니2"    //syntax 에러 발생 => 상수로 선언한 공간의 값을 변경 시도:

//          내 출생년도 val에 저장. 변경 불가 => 변수 생성과 동시에 저장
            var myBirthYear=1980    //코틀린은 자료형을 따진다
            //myBirthYear="조철뚝" => 에러발생 => type mismatch 에러

//            코틀린에서는 모든 변수 참조형
//            myBirthYear.compareTo() =>
        }

            binding.btnCondition.setOnClickListener {

                //사용자의 나이를 val에 저장 => EditText를 이용해 입력받기

                //EditText는 .toString()으로 String입력값을 받아오는 역할
                //Int로 변환=> Castinf 필요
                val userAge=binding.edtUserAge.text.toString().toInt()

                //20살 이상? 성인문구 토스트

//                if (userAge>=20){
//                    Toast.makeText(this, "성인입니다", Toast.LENGTH_SHORT).show()
//                }
//                else if (userAge>=17){
//                    Toast.makeText(this, "고등학생입니다", Toast.LENGTH_SHORT).show()
//                }
//                else{
//                    Toast.makeText(this, "미성년자입니다", Toast.LENGTH_SHORT).show()
//                }

                //when 활용문
                when(userAge){
                    25->{
                        Toast.makeText(this, "25살입니다", Toast.LENGTH_SHORT).show()
                    }
                    27,28,29->{
                        Toast.makeText(this, "20대 후반입니다", Toast.LENGTH_SHORT).show()
                    }
                    in 30..39->{    //.. <-사이값 표현
                        Toast.makeText(this,"30대 입니다", Toast.LENGTH_SHORT).show()
                    }
                }
            }

    }
}