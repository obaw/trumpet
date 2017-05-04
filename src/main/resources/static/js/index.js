/**
 * Created by xiaowei on 17-5-4.
 */
$(function () {
  /*菜单按钮*/
  $(".menu-ico").click(function () {
    //this
    var menuico = $(this);
    if (menuico.hasClass("active")) {
      menuico.removeClass("active");
    } else {
      menuico.addClass("active");
    }
    //menu
    var menu = $(".menu");
    if (menu.hasClass("active")) {
      menu.removeClass("active");
    } else {
      menu.addClass("active");
    }
  });
  /*搜索*/
  $(".search").click(function () {
    $(".menu").addClass("active");
  })
});