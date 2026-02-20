"use strict";
/*    JavaScript 7th Edition
      Chapter 12
      Project 12-01

      Project to display a dropdown menu
      Author: Nicholas Watson
      Date:   11/3/2025

      Filename: project12-01.js
*/

$(() => {
    $("li.submenu").mouseover((e) => {
        $(e.currentTarget).children("ul").show()
    })
    $("li.submenu").mouseout((e) => {$(e.currentTarget).children("ul").hide()})
})




                                                