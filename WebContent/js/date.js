/*
'use strict';
​
let birth_year = document.querySelector('.birth_year');
let birth_month = document.querySelector('.birth_month');
let birth_day = document.querySelector('.birth_day');

/**
  * selectのoptionタグを生成するための関数
  * @param {Element} elem 変更したいselectの要素
  * @param {Number} val 表示される文字と値の数値
  */
function createOptionForElements(elem, val) {
   let option = document.createElement('option');
   option.text = val;
   option.value = val;
   elem.appendChild(option);
}

//年の生成
for(let i = 1920; i <= 2020; i++) {
   createOptionForElements(birth_year, i);
}
//月の生成
for(let i = 1; i <= 12; i++) {
   createOptionForElements(birth_month, i);
}
//日の生成
for(let i = 1; i <= 31; i++) {
   createOptionForElements(birth_day, i);
}

/**
  * 日付を変更する関数
  */
function changeTheDay() {
   //日付の要素を削除
   birth_day.innerHTML = '';

   //選択された年月の最終日を計算
   let lastDayOfTheMonth = new Date(birth_year.value, birth_month.value,
0).getDate();

   //選択された年月の日付を生成
   for(let i = 1; i <= lastDayOfTheMonth; i++) {
     createOptionForElements(birth_day, i);
   }
}

birth_year.addEventListener('change', function() {
   changeTheDay();
});

birth_month.addEventListener('change', function() {
   changeTheDay();
});