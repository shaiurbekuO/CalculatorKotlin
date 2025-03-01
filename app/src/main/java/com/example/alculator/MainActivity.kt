package com.example.alculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {
    private var firstNum: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Сан батырмаларын табу
        val num0: Button = findViewById(R.id.num0)
        val num1: Button = findViewById(R.id.num1)
        val num2: Button = findViewById(R.id.num2)
        val num3: Button = findViewById(R.id.num3)
        val num4: Button = findViewById(R.id.num4)
        val num5: Button = findViewById(R.id.num5)
        val num6: Button = findViewById(R.id.num6)
        val num7: Button = findViewById(R.id.num7)
        val num8: Button = findViewById(R.id.num8)
        val num9: Button = findViewById(R.id.num9)

        // Басқа батырмаларды табу
        val on: Button = findViewById(R.id.on)
        val off: Button = findViewById(R.id.off)
        val ac: Button = findViewById(R.id.ac)
        val del: Button = findViewById(R.id.del)
        val div: Button = findViewById(R.id.div)
        val times: Button = findViewById(R.id.times)
        val min: Button = findViewById(R.id.min)
        val equal: Button = findViewById(R.id.egual)
        val plus: Button = findViewById(R.id.plus)
        val point: Button = findViewById(R.id.point)

        // Экранды табу
        val screen: TextView = findViewById(R.id.screen)

        // AC батырмасына әсер ету
        ac.setOnClickListener {
            firstNum = 0.0
            screen.text = "0"
        }

        // OFF батырмасына әсер ету
        off.setOnClickListener {
            screen.visibility = View.GONE
        }

        // ON батырмасына әсер ету
        on.setOnClickListener {
            screen.visibility = View.VISIBLE
            screen.text = "0"
        }

        // Сан батырмаларын тізімге қосу
        val nums = listOf(num0, num1, num2, num3, num4, num5, num6, num7, num8, num9)

        // Сан батырмаларына әсер ету
        for (b in nums) {
            b.setOnClickListener {
                if (screen.text.toString() != "0") {
                    screen.text = "${screen.text}${b.text}"
                } else {
                    screen.text = b.text.toString()
                }
            }
        }

        // Операция батырмаларын тізімге қосу
        val opers = listOf(div, times, plus, min)

        // Операция батырмаларына әсер ету
        for (b in opers) {
            b.setOnClickListener {
                firstNum = screen.text.toString().toDouble()
                operation = b.text.toString()
                screen.text = "0"
            }
        }

        // DEL батырмасына әсер ету
        del.setOnClickListener {
            val num = screen.text.toString()
            if (num.length > 1) {
                screen.text = num.substring(0, num.length - 1)
            } else if (num.length == 1 && num != "0") {
                screen.text = "0"
            }
        }

        // Нүкте батырмасына әсер ету
        point.setOnClickListener {
            if (!screen.text.toString().contains(".")) {
                screen.text = "${screen.text}."
            }
        }

        // Тең батырмасына әсер ету
        equal.setOnClickListener {
            val secondNum = screen.text.toString().toDouble()
            val result = when (operation) {
                "/" -> firstNum / secondNum
                "x" -> firstNum * secondNum
                "+" -> firstNum + secondNum
                "-" -> firstNum - secondNum
                else -> firstNum + secondNum
            }
            screen.text = result.toString()
            firstNum = result
        }
    }
}