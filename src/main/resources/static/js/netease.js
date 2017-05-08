function netease(url, param, func) { // 接口参数定义
  var $path = 'http://localhost:8081'; // flyurl
  $.ajax({
    url: $path + url,
    type: 'get',
    data: param,
    dataType: "json",
    ansync: true,
    success: function (result) {
      console.log(result);
      if (result.code == 200) {
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

function getPlaylist(uid) {
  netease("/user/playlist",{"uid": uid}, function (result) {
        return result.playlist;
  });
}

function flightHandler(json) {
  console.log(json);
}