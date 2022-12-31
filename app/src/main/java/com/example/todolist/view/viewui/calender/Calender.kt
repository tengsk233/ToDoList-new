package com.example.todolist.view.viewui.calender

import android.content.ContentValues.TAG
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.flow.collect
import java.time.Month
import java.time.MonthDay

//建一个函数，day就是第几天，selectDay用来判断是否是被点击的那天，然后抛出去一个lambda，处理点击事件，lambda传入的day就是用来说明是第几天。
@Composable
fun Day(day: Int, selectDay: Int, dayClick: (Int) -> Unit) {
    Text(text = day.toString(),
        textAlign = TextAlign.Center,
        color =  Color.Gray,
        modifier = Modifier
            .clickable {
                dayClick(day)
            })
}

//然后写月份,首先我们写一个枚举类来定义月份，虽然java.time里有自带的，但是由于版本需要安卓8及以上，所以就自己写了，直接复制里面的内容修改就行。

enum class MonthEnum {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;
    companion object {
        private val enums = values()
        fun of(month: Int): MonthEnum {
            if (month < 1 || month > 12) {
                throw RuntimeException("Invalid value for MonthOfYear: $month")
            }
            return enums[month - 1]
        }
    }
    fun maxLength(): Int {
        return when (this) {
            FEBRUARY -> 29
            APRIL, JUNE, SEPTEMBER, NOVEMBER -> 30
            else -> 31
        }
    }
    fun minLength(): Int {
        return when (this) {
            FEBRUARY -> 28
            APRIL, JUNE, SEPTEMBER, NOVEMBER -> 30
            else -> 31
        }
    }
    fun length(leapYear: Boolean): Int {
        return when (this) {
            FEBRUARY -> if (leapYear) 29 else 28
            APRIL, JUNE, SEPTEMBER, NOVEMBER -> 30
            else -> 31
        }
    }
}

/**
 *@param selectDay 动态更新
 *@param monthDayClick 点击高亮
 *LazyVerticalGrid是用来写网格列表，GridCells.Fixed(6)就是每行6个
 *month.length(true) 返回月份的天数，true则代表闰年
 */
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Month(
    month: Month,
    selectDay: Int,
    monthDayClick: (MonthDay) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(top = 60.dp)
    ) {
        Text(
            text = month.name,
            modifier = Modifier
//                .background(Color.Red)
                .fillMaxWidth(),
            color = Color.Gray,
            textAlign = TextAlign.Center
        )
        Log.i(TAG, "Month: ${month.name} ")
        LazyVerticalGrid(cells = GridCells.Fixed(6)) {
            items(month.length(true)) { index ->
                Day(day = index + 1, selectDay, dayClick = {
                    monthDayClick(MonthDay.of(month,it))
                })
            }
        }
    }
}

//接下来是最外层的viewpager，move用于页面切换时需要做的事情
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalPagerApi::class)
@Composable
fun Calendar(selectDay: Int, move: (Int) -> Unit, dayClick: (MonthDay) -> Unit) {
    //对页面更改做出反应¶
    //每当所选页面发生更改时，都会更新PagerState.currentPage属性。
    val pagerState = rememberPagerState()
    LaunchedEffect(pagerState) {
        // 从读取 currentPage 的快照流中收集
        snapshotFlow { pagerState.currentPage }
            .collect {
                move(it)
            }
    }
    HorizontalPager(
        count = 12, state = pagerState, modifier = Modifier
            /*.paint(
                painter = painterResource(
                    id = R.drawable.background
                ), contentScale = ContentScale.Crop
            )*/
            .height(300.dp), verticalAlignment = Alignment.Top
    ) { index ->
    }
}

//最后是用法，selectDay是当前选中的号数，move：因为选择的号数可能是大于切换的下个月份的，导致不高亮显示，所以每次切换时默认高亮显示第一天，最外层lambda是处理day的点击事件。

//iewModel类里的selectDay用作动态更新，MutableState 类是一个单一的值持有者，其读取和写入由 Compose 观察，当值发生变化会更新ui。
/*class MainViewModel : ViewModel() {
}*/

