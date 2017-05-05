/**
 * Created by xiaowei on 17-5-4.
 */
$(function () {
  var uid = localStorage.getItem("uid");
  console.log(uid);
  if (uid == null || uid == "") {
    uid = prompt("请输入您的id:", "33182671");
    localStorage.setItem("uid", uid);
  }
  ajaxCfg("/netease/userPlaylist", {"uid": uid}, function (data) {
    $(data.list).each(function () {
      var playlistId = this.id;
      var clone = $("#clonePlaylist");
      var playlist = clone.clone();
      /*歌单封面*/
      playlist.find(".art").css("background-image",
          "url('" + this.coverImgUrl + ")'");
      /*歌单名称*/
      playlist.find("h1").text(this.name);
      playlist.removeAttr("id");
      /*歌单点击事件*/
      playlist.click(function () {
        playlistDetail(playlistId);
      });
      playlist.show();
      playlist.appendTo(".tab");
    });
  });
  $(".bottom").addClass("active");
  /*菜单按钮*/
  $(".menu-ico").click(function () {
    //this
    var menuico = $(this);
    //menu
    var menu = $(".menu");
    if (menuico.hasClass("back")) {
      $(this).removeClass("back");
      $(".content").removeClass("active");
      $(".playlist-content").removeClass("active");
    } else if (menuico.hasClass("active")) {
      menuico.removeClass("active");
      if (menu.hasClass("active")) {
        menu.removeClass("active");
      }
    } else {
      menuico.addClass("active");
      menu.addClass("active");
    }
  });
  /*搜索*/
  $(".search").click(function () {
    $(".menu-ico").addClass("active");
    $(".menu").addClass("active");
  });
  $("#search").keyup(function (event) {
      console.log($("#search").val());
  })
});

/**
 * ajax配置
 * @param {URL} 接口地址
 * @param {Map} 参数
 * @param {Function} 函数
 */

function ajaxCfg(url, param, func) { // 接口参数定义
  var $path = 'http://192.168.1.152:8080'; // flyurl
  $.ajax({
    url: $path + url,
    type: 'post',
    data: param,
    dataType: "json",
    ansync: true,
    success: function (result) {
      if (result.statusCode == 200) {
        func(result);
      } else {
        alert(result.discribe);
      }
    },
    error: function (e) {
      console.log(e);
    }
  });
}

/*歌单详情*/
function playlistDetail(id) {
  var playlist = $("#" + id);
  if (playlist.is("div")) {
    playlist.addClass("active");
  } else {
    ajaxCfg("/netease/playlist", {"id": id}, function (playlistData) {
      var playlist = playlistData.object;
      var detail = $("#clonePlaylistContent").clone();
      detail.show();
      detail.removeAttr("id");
      detail.attr("id", id);
      detail.appendTo(".tab");
      detail.addClass("active");
      detail.find(".songs h1").text(playlist.name);
      var songs = playlist.tracks;
      var cover = playlist.coverImgUrl;
      detail.find(".art").css("background-image", "url('" + cover + ")'");
      $(".bg-blur").css("background-image", "url('" + cover + ")'");
      $(songs).each(function (i) {
        var song = $("#cloneSong").clone();
        song.find("p").eq(0).text(this.name);
        song.find("p").eq(1).text("-" + this.artists[0].name);
        song.find("span i").text(i + 1);
        song.show();
        var songOb = this;
        song.click(function () {
          play(id, songOb);
        })
        song.removeAttr("id");
        song.appendTo(detail.find(".songs-list"));
        // console.log(this.name + "-" + this.mp3Url);
      });
    });
  }
  $(".content").addClass("active");
  $(".menu-ico").addClass("back");
}

/*播放歌曲*/
function play(playlistId, song) {
  var pic = song.album.blurPicUrl;
  $("#" + playlistId).find(".art").css("background-image",
      "url('" + pic + ")'");
  $(".bg-blur").css("background-image", "url('" + pic + ")'");
  var url = song.mp3Url.replace("m2.music.126.net", "p2.music.126.net");
  $("#audio").attr("src", url);
}