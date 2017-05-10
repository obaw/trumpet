/**
 * Created by xiaowei on 17-5-4.
 */
var audio;
var playBtn;
$(function () {
  window.name = "music.163.com";
  audio = $("#audio")[0];
  playBtn = $("#playBtn");
  userPlayList();
  initQueue();
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
  /*搜索回车*/
  $("#search").keyup(function (event) {
    if (event.keyCode == 13) {
      search($("#search").val());
    }
  });
  /*播放按钮点击*/
  playBtn.click(function () {
    playBtnClick();
  });
  /*点击进度条*/
  $("#slider").click(function () {
    audio.currentTime = $("#slider").val();
  });
  /*点击播放列表*/
  $(".playlist-btn").click(function () {
    if ($(".queue").hasClass("active")) {
      $(".queue").removeClass("active");
    } else {
      $(".queue").addClass("active");
    }
  })
});

/**
 * ajax配置
 * @param {URL} 接口地址
 * @param {Map} 参数
 * @param {Function} 函数
 */

function ajaxCfg(url, param, func) { // 接口参数定义
  $.ajax({
    url: url,
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

/*用户歌单*/
function userPlayList() {
  var uid = localStorage.getItem("uid");
  console.log(uid);
  if (uid == null || uid == "") {
    uid = prompt("请输入您的id:", "33182671");
    localStorage.setItem("uid", uid);
  }
  ajaxCfg("/netease/userPlaylist", {"uid": uid}, function (result) {
    $(result.list).each(function () {
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
        song.find("p").text(this.name + "-" + this.artists[0].name);
        song.find("span:eq(0) i:eq(0)").text(i + 1);
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

/*搜索歌曲*/
function search(keyword) {
  $(".results-list ul").empty();
  ajaxCfg("/netease/search", {"keyword": keyword}, function (data) {
    $(data.list).each(function (i) {
      var searchResult = $("#cloneSearch").clone();
      searchResult.show();
      searchResult.find("span:eq(0) i:eq(0)").text(i + 1);
      searchResult.find("p").text(this.name + "-" + this.artists[0].name);
      searchResult.removeAttr("id");
      var songId = this.id;
      searchResult.click(function () {
        song(songId);
      })
      searchResult.appendTo(".results-list ul");
    });
  })
}

/*歌曲详情*/
function song(songId) {
  ajaxCfg("/netease/song", {"id": songId}, function (data) {
    play(null, data.object);
  })
}

/*播放歌曲*/
function play(playlistId, song) {
  $(".queue-list").children(".playing").removeClass("playing");
  var pic = song.album.blurPicUrl;
  if (playlistId != null) {
    $("#" + playlistId).find(".art").css("background-image",
        "url('" + pic + ")'");
  }
  $(".bg-blur").css("background-image", "url('" + pic + ")'");
  var url = song.mp3Url.replace("m2.music.126.net", "p2.music.126.net");
  $("#audio").attr("src", url);
  $("#bottomArt").css("background-image", "url('" + pic + ")'");
  audio.addEventListener("loadedmetadata", function () {
    $('.song-length').text(transTime(this.duration));
    playBtn.find("i").html("pause");
    $('#slider').attr("max", this.duration);
    listen();
  }, false);
  var queue = localStorage.getItem("queue");
  if (queue == null) {
    var queueList = new Array();
    queueList.push(song);
    localStorage.setItem("queue", JSON.stringify(queueList));
    addQueue([song]);
  } else {
    var queueList = JSON.parse(queue);
    var isExist = false;
    queueList.forEach(function (value, index, array) {
      if (value.id == song.id) {
        isExist = true;
      }
    });
    if (!isExist) {
      queueList.push(song);
      localStorage.setItem("queue", JSON.stringify(queueList));
      addQueue([song]);
    }
  }
  $("#" + song.id).addClass("playing");
}

/*播放按钮点击*/
function playBtnClick() {
  var i = playBtn.find("i");
  //改变暂停/播放icon
  if (audio.paused) {
    i.html("pause");
    audio.play();
  } else {
    i.html("play_arrow");
    audio.pause();
  }
}

function listen() {
  //监听音频播放时间并更新进度条
  audio.addEventListener('timeupdate', function () {
    var value = Math.round(
        (Math.floor(audio.currentTime) / Math.floor(audio.duration)) * 100, 0);
    $(".sliderBg").css("width", value + "%");
    $("#slider").val(audio.currentTime);
    $('.current-time').html(transTime(audio.currentTime));
  }, false);
  //监听播放完成事件
  audio.addEventListener('ended', function () {
    audio.currentTime = 0;
    audio.pause();
    playBtn.find("i").html("play_arrow");
    var nowSong = $(".queue-list").children(".playing").eq(0);
    nowSong.removeClass("playing");
    var nextSong = nowSong.next();
    if (nextSong.is("li")) {
      nextSong.click();
    }
  }, false);
}

//转换音频时长显示
function transTime(time) {
  var duration = parseInt(time);
  var minute = parseInt(duration / 60);
  var sec = duration % 60 + '';
  var isM0 = ':';
  if (minute == 0) {
    minute = '00';
  } else if (minute < 10) {
    minute = '0' + minute;
  }
  if (sec.length == 1) {
    sec = '0' + sec;
  }
  return minute + isM0 + sec;
}

/*添加播放列表*/
function addQueue(songs) {
  songs.forEach(function (value, index, array) {
    //获取最后一首index
    var lastSong = $(".queue-list li").last();
    var index = 1;
    if (lastSong.is("li")) {
      index = Number(lastSong.find("span:eq(0) i:eq(0)").html()) + 1;
    }
    var song = $("#cloneQueue").clone();
    song.find("p").text(value.name + "-" + value.artists[0].name);
    song.find("span:eq(0) i:eq(0)").text(index);
    song.attr("id", value.id);
    song.show();
    var songOb = value;
    song.click(function () {
      play(null, songOb);
    })
    song.appendTo(".queue-list");
  });
}

/*初始化播放列表*/
function initQueue() {
  var queue = localStorage.getItem("queue");
  if (queue != null) {
    var queueList = JSON.parse(queue);
    if (queueList.length > 0) {
      addQueue(queueList);
    }
  }
}